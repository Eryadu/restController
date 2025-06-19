package io.pragra.restcontroller.util;


import io.pragra.restcontroller.entity.StudentRc;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentUtils {
    public void convertPatchDto(StudentRc dto,StudentRc entity) {
        if(Objects.nonNull(dto.getStudentName())){
            entity.setStudentName(dto.getStudentName());
        }
        if(Objects.nonNull(dto.getStudentEmail())){
            entity.setStudentEmail(dto.getStudentEmail());
        }
        if (Objects.nonNull(dto.getStudentPhone())){
            entity.setStudentPhone(dto.getStudentPhone());
        }
    }
}
