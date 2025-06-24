package io.pragra.restcontroller.feignclients;

import io.pragra.restcontroller.restClient.entity.Users;
import io.pragra.restcontroller.restClient.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserClient userClient;
    @Autowired
    private UsersRepo usersRepo;

    public Users getUsersByFeignAndPersist (String login){
        Optional<Users> usersList = usersRepo.findByLogin(login);
        if(usersList.isPresent()){
            return usersList.get();
        }
        ResponseEntity<Users> responseEntity = userClient.getUsersByFeign(login);
        Users users = responseEntity.getBody();
        if(users != null && responseEntity.getStatusCode() == HttpStatus.OK ){
            usersRepo.save(users);
            return users;
        }
        // Optional: handle user not found in both DB and API
        return null;
    }

    public ResponseEntity<Users> createUserByFeign(Users users){
        ResponseEntity<Users> usersByFeign = userClient.createUsersByFeign(users);
        Users user = usersByFeign.getBody();
        if(user != null && usersByFeign.getStatusCode() == HttpStatus.CREATED){
            usersRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return null;
    }

    public void deleteUserByFeign(Integer id){
        Optional<Users> optionalUsers = usersRepo.findById(Long.valueOf(id));
        if(optionalUsers.isPresent()){
            userClient.deleteUsersByFeign(id);
        }

    }
}
