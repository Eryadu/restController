package io.pragra.restcontroller.restClient.repo;

import io.pragra.restcontroller.restClient.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    List<Users> findByName (String login);
}
