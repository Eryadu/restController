package io.pragra.restcontroller.ResponseEntityController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")

//ResponseEntity is powerful class of Spring Framework to return a complete response of web(http) request, developer
// has full control to customize the message , but it wanted to show to user. It included http responseCode, Body, Header)
public class StudentRcResponseEntityController {

        @GetMapping("/success")
        public ResponseEntity<String> successResponse(){
            String response = "success";
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @GetMapping("/failure")
        public ResponseEntity<String> notFoundResponse(){
        String response = "not found";
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        @GetMapping("/customResponse")
        public ResponseEntity<String> customHeaderResponse(){
            String response = "custom header";
            return ResponseEntity
                    .status(HttpStatus.OK).header("Custom-Header", "Custom-Value")
                    .body(response);
        }

}
