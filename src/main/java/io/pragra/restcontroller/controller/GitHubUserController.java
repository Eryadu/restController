package io.pragra.restcontroller.controller;

import io.pragra.restcontroller.entity.GitHubUser;
import io.pragra.restcontroller.service.GitHubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class GitHubUserController {
    @Autowired
    private GitHubUserService gitHubUserService;

    @GetMapping("/fetch")
    public GitHubUser fetchUser(@RequestParam String username) {
        return gitHubUserService.fetchAndPersist(username);
    }

    @GetMapping ("/fetchwithfeign")
    public GitHubUser fetchUserWithFeignClient(@RequestParam String username) {
        return gitHubUserService.fetchAndPersistWithFeignClient(username);
    }
}
