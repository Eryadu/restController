package io.pragra.restcontroller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class StudentRc {
    // GenerationType.IDENTITY
    //Relies on the database to auto-increment the ID
    // GenerationType.AUTO
    //Let Hibernate decide based on the DB dialect. Means Hibernate first select the ID generated by Db and thn inserted
    // into query to save in db. So Hibernate act as bridge.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;
    private String firstName;
    private String lastName;
    private String studentEmail;
    private String studentPhone;
}
