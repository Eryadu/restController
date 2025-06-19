package io.pragra.restcontroller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudentDTO {
    private String firstname;
}
