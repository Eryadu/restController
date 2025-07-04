package io.pragra.restcontroller.restClient.repo;

import io.pragra.restcontroller.restClient.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByLogin (String login);
}
