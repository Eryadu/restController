package io.pragra.restcontroller.webClient.repo;

import io.pragra.restcontroller.webClient.entity.WebUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface WebUserRepo extends JpaRepository<WebUser, Long> {
    Optional<WebUser>  findByLogin (String login);
}
