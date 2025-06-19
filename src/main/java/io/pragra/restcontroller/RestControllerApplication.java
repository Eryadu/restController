package io.pragra.restcontroller;

import io.pragra.restcontroller.Controller.StudentRcController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class RestControllerApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(RestControllerApplication.class, args);
       context.getBean(StudentRcController.class);

    }

}
