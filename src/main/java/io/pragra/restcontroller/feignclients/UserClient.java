package io.pragra.restcontroller.feignclients;

import io.pragra.restcontroller.restClient.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//name : is application name; unique throughout feignClient
@FeignClient(name = "userClient", url = "https://api.github.com/users")
//@FeignClient(name = "userClient", url = "https://jsonplaceholder.typicode.com/posts") //to create fake user(OPEN API)

public interface UserClient {
    @GetMapping("/{userLogin}")
    ResponseEntity<Users> getUsersByFeign(@PathVariable String userLogin);

    @PostMapping("")
    ResponseEntity<Users> createUsersByFeign(@RequestBody Users users);

    @DeleteMapping("/{id}")
    void deleteUsersByFeign(@PathVariable Integer id);
}


