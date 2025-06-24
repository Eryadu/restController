package io.pragra.restcontroller.restClient.controller;

import io.pragra.restcontroller.restClient.entity.Users;
import io.pragra.restcontroller.restClient.service.RestTemplateConsumer;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class RestTemplateController {
    @Autowired
    private RestTemplateConsumer restTemplateConsumer;

    @GetMapping("/getforentity")
    public ResponseEntity<String> getUser(@RequestParam String login) {
        return restTemplateConsumer.getForEntityAndPersist(login);
    }

    @GetMapping("/getforobject")
    public Users getUserObject(@RequestParam String login) {
        return restTemplateConsumer.getForObjectAndPersist(login);
    }

    @GetMapping("/header")
    public Map<String, String> getUserHeader(@RequestParam String login) {
        return restTemplateConsumer.getHeaders(login);
    }

    @PostMapping("/postforobject")
    public Users postUserObject(@RequestBody Users user) {
        return restTemplateConsumer.postForUser(user);
    }

    @PostMapping("/postforentity")
    public Users postUserEntity(@RequestBody Users user) {
        return restTemplateConsumer.postForEntityUser(user);
    }

    @PostMapping("/postforlocation")
    public ResponseEntity<String> postUserLocation(@RequestBody Users user) {
        return restTemplateConsumer.postForLocationUser(user);
    }

    @GetMapping("/exchangeuser")
    public Users exchangeUser(@RequestParam String login) {
        return restTemplateConsumer.exchangeUser(login);
    }
    @PostMapping("/postforexchange")
    public Users postUserExchange(@RequestBody Users user) {
        return restTemplateConsumer.exchangePostUser(user);
    }

    /*@GetMapping("/excuteuser")
    public Users excuteUser(@RequestParam String login) {
        return restTemplateConsumer.excuteUser(login);
    }*/

}
