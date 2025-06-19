package io.pragra.restcontroller.Service;

import io.pragra.restcontroller.entity.GitHubUser;
import io.pragra.restcontroller.repo.GitUserRepo;
import io.pragra.restcontroller.feignclients.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Component
public class GitHubUserService {

    @Autowired
    private GitUserRepo gitUserRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;
    @Autowired
    private StudentClient studentClient;

    public GitHubUser fetchAndPersist(String login) {

        //Rest template
        //Check DB first before fetching from API
        List<GitHubUser> gitHubUsers = gitUserRepo.findByName(login);

        if (!gitHubUsers.isEmpty()) {
            // Return the first user found
            return gitHubUsers.get(0);
        }

        // ResponseEntity<GitHubUser> gitHubUserResponseEntity = restTemplate
        // .getForEntity("http://api.github.com/users/" + login, GitHubUser.class);

        // If not found in DB, fetch from GitHub API
        ResponseEntity<GitHubUser> response = restTemplate
                .exchange("https://api.github.com/users/" + login, HttpMethod.GET, null, GitHubUser.class);

        GitHubUser gitHubUser = response.getBody();
        if (gitHubUser != null && gitHubUser.getId() != null) {
            gitUserRepo.save(gitHubUser);
            return gitHubUser;
        }
        // Optional: handle user not found in both DB and API
        return null;
    }


    public GitHubUser fetchAndPersistWithFeignClient(String login){
        ResponseEntity<GitHubUser> githubUserResponseEntity = studentClient.getGitUser(login);
        if(Objects.nonNull(githubUserResponseEntity.getBody())
                && Objects.nonNull(githubUserResponseEntity.getBody().getId())){
            gitUserRepo.save(githubUserResponseEntity.getBody());
            return githubUserResponseEntity.getBody();
        }
        return new GitHubUser();
    }
}

