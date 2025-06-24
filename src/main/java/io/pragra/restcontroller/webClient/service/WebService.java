package io.pragra.restcontroller.webClient.service;

import io.pragra.restcontroller.restClient.entity.Users;
import io.pragra.restcontroller.restClient.repo.UsersRepo;
import io.pragra.restcontroller.webClient.entity.WebUser;
import io.pragra.restcontroller.webClient.repo.WebUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class WebService {

    @Autowired
    private WebUserRepo webUserRepo;
    @Autowired
    private WebClient webClient;

    private static final String user_url = "https://api.github.com/users/";

    //responseEntityMono give immediate response but don't consist actual result until API respond,
    // so we can use it as Async or Sync.
    public ResponseEntity<String> fetchUserWithWebAndPersist(String username) {
        Optional<WebUser> webUsers = webUserRepo.findByLogin(username);
        if(webUsers.isPresent()) {
            return ResponseEntity.ok("WebUser Found in Db " + webUsers.get());
        }
        // Mono is similar to optional, one or none
        Mono<WebUser> responseEntityMono = webClient
                .get()
                .uri(user_url + username)
                .header("username", "yad")
                .retrieve()
                .bodyToMono(WebUser.class);

        //.block method to use this service as Synchronous (until it's not completed, we have to wait)
        // this will give us actual result
        // we can use this one for async or for completable future
        //ResponseEntity<WebUser> userResponseEntity = responseEntityMono.block();
        WebUser userResponseEntity = responseEntityMono.block();
        webUserRepo.save(userResponseEntity);
        return ResponseEntity.ok("Web Client Saved in DB " + userResponseEntity);
        /*WebUser entityBody = userResponseEntity.getBody();
        if (entityBody != null && userResponseEntity.getStatusCode() == HttpStatus.OK) {
            webUserRepo.save(entityBody);
            return userResponseEntity;
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);*/
    }
    //-------------------------------------------------------------------------------------------------------

    // Simple get() without saving into DB
    public Mono<WebUser> getUserData(String username) {
        return
                webClient.get()
                        .uri(user_url + username)
                        .retrieve()
                        .bodyToMono(WebUser.class);
    }
    //-------------------------------------------------------------------------------------------------------
    //Using Post()
    public Mono<WebUser> createUser(WebUser webUser) {
        return
                webClient.post()
                        .uri("https://jsonplaceholder.typicode.com/posts")
                        .bodyValue(webUser)
                        .retrieve()
                        .bodyToMono(WebUser.class);
    }
    //-------------------------------------------------------------------------------------------------------
    // Implementing Timeout() and handling timeout exception
    // Handling successful responses // it will throw timeoutException so to handle
    // that we use .onErrorResume or .RetryWhen methods.
    public Mono<ResponseEntity<WebUser>> fetchUserWithSuccessResponse(String username) {
        return webClient.get()
                .uri(user_url + username)
                .retrieve()
                .toEntity(WebUser.class)
                .timeout(Duration.ofMillis(1500))
                .onErrorResume(e -> {
                    System.out.println("Error: " + e.getMessage());
                    //return Mono.error(e)
                            return Mono.just(ResponseEntity.notFound().build());
                });
                /*.onErrorResume(TimeoutException.class, e -> Mono
                        .just(ResponseEntity.internalServerError().build()));*/

                        }
    //-------------------------------------------------------------------------------------------------------
    // Handling error responses with .onStatus
    public Mono<WebUser> fetchUserWithErrorResponse(String username) {
        return webClient.get()
                .uri(user_url + username)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono
                        .error(new HttpClientErrorException(HttpStatus.UNAUTHORIZED)))
                .onStatus(HttpStatusCode::is4xxClientError,clientResponse ->
                        (Mono.error(new RuntimeException("Client Error: " + clientResponse.statusCode()))))
               /* .onStatus(HttpStatusCode::is5xxServerError, clientResponse ->
                        (Mono.error(new RuntimeException("Server Error : " + clientResponse.statusCode())))*/
                .bodyToMono(WebUser.class);
        }
    //-------------------------------------------------------------------------------------------------------
    // Handling error responses with .onStatus
    // We can handle timeoutException by .timeout with retryWhen()
    public Mono<WebUser> fetchUserWithRetry(String username) {
        return webClient.get()
                .uri(user_url + username)
                .retrieve()
                .bodyToMono(WebUser.class)
                .timeout(Duration.ofMillis(1000))
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(1500))) ; //Retries 3 times, wait 1500ms between
    }
}
