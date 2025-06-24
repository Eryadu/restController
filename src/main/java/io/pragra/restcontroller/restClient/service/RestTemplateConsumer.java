package io.pragra.restcontroller.restClient.service;

import io.pragra.restcontroller.feignclients.UserClient;
import io.pragra.restcontroller.restClient.entity.Users;
import io.pragra.restcontroller.restClient.repo.UsersRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class RestTemplateConsumer {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsersRepo usersRepo;

    private static final String user_url = "https://api.github.com/users/";

    // getForEntity :-> return object of ResponseEntity class with staus code and Resource as Object
    public ResponseEntity<String> getForEntityAndPersist(String login){
        Optional<Users> usersList = usersRepo.findByLogin(login);
        if(usersList.isPresent()){
            return ResponseEntity.ok("User Found in Db " + usersList.get());
        }
        ResponseEntity<Users> responseEntity = restTemplate.getForEntity(user_url +login, Users.class);
        Users users = responseEntity.getBody();
        if(users != null && responseEntity.getStatusCode() == HttpStatus.OK ){
            usersRepo.save(users);
            return ResponseEntity.ok("User saved in DB " + users);
        }
        // Optional: handle user not found in both DB and API
        return null;
    }
    //----------------------------------------------------------------------------------------------------
    // getForObject :-> it return resource as Object only
    public Users getForObjectAndPersist(String login){
        Optional<Users> usersList1 = usersRepo.findByLogin(login);
        if(usersList1.isPresent()){
            return usersList1.get();
        }
        Users responseEntity = restTemplate.getForObject(user_url +login, Users.class);
        Users users1 = responseEntity;
        if(users1 != null ){
            usersRepo.save(users1);
            return users1;
        }
        // Optional: handle user not found in both DB and API
        return null;
    }
    //----------------------------------------------------------------------------------------------------
    // headForHeader
    public Map<String, String> getHeaders(String login){
        HttpHeaders httpHeaders = restTemplate.headForHeaders(user_url + login);
        Map<String, String> headers = new HashMap<>();
        httpHeaders.forEach((key, value) -> {
            headers.put(key.toString(), value.toString());
        });
      return headers;
    }

    //----------------------------------------------------------------------------------------------------
    // PostForObject
    public Users postForUser(Users users){
        try{
            Users usersObject = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts",users, Users.class);
            System.out.println("User created successfully");
            return usersObject;
        }catch (HttpClientErrorException ex){
            //handle client errors (4xx)
            System.out.println("Client Error: "+ex.getStatusCode()+ " - " + ex.getResponseBodyAsString());
        }catch (Exception ex){
            // handle server error (5xx)
            System.out.println("Server Error: "+ex.getMessage());
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------------
    // PostForEntity
    public Users postForEntityUser(Users users){
        try{
            ResponseEntity<Users> usersResponse = restTemplate
                    .postForEntity("https://jsonplaceholder.typicode.com/posts",users, Users.class);
            System.out.println("User created successfully");
            return usersResponse.getStatusCode() == HttpStatus.CREATED ? usersResponse.getBody() : null;
        }catch (HttpClientErrorException ex){
            //handle client errors (4xx)
            System.out.println("Client Error: "+ex.getStatusCode()+ " - " + ex.getResponseBodyAsString());
        }catch (Exception ex){
            // handle server error (5xx)
            System.out.println("Server Error: "+ex.getMessage());
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------------
    // PostForLocation
    public ResponseEntity<String> postForLocationUser(Users users){
        try{
            URI uri = restTemplate
                    .postForLocation("https://jsonplaceholder.typicode.com/posts", users, Users.class);
            if (uri != null) {
                return ResponseEntity.ok("User created at location: " + uri);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User creation failed");
            }
        }catch (Exception ex){
            // handle server error (5xx)
            System.out.println("Server Error: "+ex.getMessage());
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------------
    // exchange with GET method
    public Users exchangeUser(String login) {
        ResponseEntity<Users> exchangeEntity = restTemplate
                .exchange("https://api.github.com/users/" + login, HttpMethod.GET, null, Users.class);
        if (exchangeEntity != null) {
            return exchangeEntity.getBody();
        } else {
            return null;
        }
    }

    // exchange with Post method
    public Users exchangePostUser(Users users) {

        //set header for http entity(payload+header)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //wrap payload(user) and headers
        HttpEntity<Users> httpEntity = new HttpEntity<>(users, headers);

        try{
            ResponseEntity<Users> exchangeEntityPost = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, httpEntity, Users.class);
            System.out.println("User created successfully");
        return exchangeEntityPost.getStatusCode()==HttpStatus.CREATED? exchangeEntityPost.getBody():null;
        }
        catch (HttpClientErrorException ex){
            //handle client errors (4xx)
            System.out.println("Client Error: "+ex.getStatusCode()+ " - " + ex.getResponseBodyAsString());
        }catch (Exception ex){
            // handle server error (5xx)
            System.out.println("Server Error: "+ex.getMessage());
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------------
  /*  // Execute with Get method
    public Users excuteUser(String login) {
            Users executed = restTemplate
                    .execute(user_url + login, HttpMethod.GET, null,(ClientHttpResponse response) -> {
                        if(response.getBody() != null) {
                            return response.getBody();
                        }else {
                return null;
    }

    };

}*/
}
