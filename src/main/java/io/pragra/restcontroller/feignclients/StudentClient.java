package io.pragra.restcontroller.feignclients;

import io.pragra.restcontroller.entity.GitHubUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "studentClient", url = "https://api.github.com/users")
public interface StudentClient {
    @GetMapping("/{login}")
   ResponseEntity<GitHubUser> getGitUser(@PathVariable String login);
}
