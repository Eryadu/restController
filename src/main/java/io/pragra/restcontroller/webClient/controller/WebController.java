package io.pragra.restcontroller.webClient.controller;

import io.pragra.restcontroller.webClient.entity.WebUser;
import io.pragra.restcontroller.webClient.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class WebController {
    @Autowired
   private WebService webService;

    @GetMapping("/fetchwebuser")
    public ResponseEntity<String> fetchUser(@RequestParam String username) {
       return webService.fetchUserWithWebAndPersist(username);
    }
    @GetMapping("/fetchuser")
    public Mono<WebUser> fetchUserData(@RequestParam String username){
        return webService.getUserData(username);
    }

    @PostMapping("/createuser")
    public Mono<WebUser> createUserWithWeb(@RequestBody WebUser webUser){
        return webService.createUser(webUser);
    }
    @GetMapping("/fetchuserwithsuccess")
    public Mono<ResponseEntity<WebUser>> fetchUserWithSuccess(@RequestParam String username){
        return webService.fetchUserWithSuccessResponse(username);
    }

    @GetMapping("/fetchuserwitherrorresponse")
    public Mono<WebUser> fetchUserWithErrorResponse(@RequestParam String username){
        return webService.fetchUserWithErrorResponse(username);
    }
    @GetMapping("/fetchuserwithretry")
    public Mono<WebUser> fetchUserWithRetryWhen(@RequestParam String username){
        return webService.fetchUserWithRetry(username);
    }

}
