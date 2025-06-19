package io.pragra.restcontroller.repo;

import io.pragra.restcontroller.entity.GitHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GitUserRepo extends JpaRepository<GitHubUser, Integer> {
    List<GitHubUser> findByName(String name);
}
