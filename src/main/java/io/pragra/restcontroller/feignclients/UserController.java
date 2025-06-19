package io.pragra.restcontroller.feignclients;

import io.pragra.restcontroller.restClient.entity.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feignClient")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/fetchWithFeign")
    public Users fetchWithFeignUserClient(@RequestParam String username) {
        return userService.getUsersByFeignAndPersist(username);
    }

    @PostMapping("/createWithFeign")
    public ResponseEntity<Users> createWithFeignUserClient(@RequestBody Users user) {
        return userService.createUserByFeign(user);
    }

    @DeleteMapping("/deleteWithFeign")
    public void deleteWithFeignUserClient(@RequestParam Integer id) {
        userService.deleteUserByFeign(id);
    }
}
