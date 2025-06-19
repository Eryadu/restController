package io.pragra.restcontroller.repo;

import io.pragra.restcontroller.entity.StudentRc;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// in jpaRepository, we pass class and primary key type
public interface StudentRcRepo extends JpaRepository<StudentRc,Integer> {

    // if we want JPA understand out method then we need to use Standard Method name, it started
    // with find-ALL-ByStudent-Name
    //JPA returned the value based on methodName+Return Type+ input
    List<StudentRc> findAllByStudentName(String name);
    List<StudentRc> findAllByStudentNameAndStudentEmail(String name, String email);
    //---------------------------------------------------------------------------------------------------
    // we want to get student lastName with their firstName using HQL, as this is not a part of JPA so we can write
    // customize methode name (no need to follow convention)
    // s is Alias for table name, Student is Entity name similar to Table name in SQL query, lastName is Property Name
    // same as column name in SQL table
    // different way to write query 1. ? -> replaced by whatEver name in String name, 2. ?-> :name 3. ?1 ,?2 if more column
    // then we can denote by numbers as well
   //---------------------------------------------------------------------------------------------------
   // @Query("SELECT s.lastName from StudentRc s where s.firstName = ?")
   // @Query("SELECT s.lastName from StudentRc s where s.firstName = :name")
    // @Query("SELECT s.lastName from StudentRc s where s.firstName = ?1")
  //---------------------------------------------------------------------------------------------------
    //Native query -> by default is false
    // StudentRc is table name and firstName is column name
   @Query(nativeQuery = true, value = "SELECT * from STUDENT_RC s where s.FIRST_NAME = ?")
    List<String> findAllLastNameByFirstName(String name);

   // to make any change in DB we need to tell JPA with @Modifying and @Transactional annotation else by default it
    // considered select query.
   @Transactional
   @Modifying
   @Query("DELETE from StudentRc s where s.studentName = :name")
   void deleteByStudentName(String name);

    @Transactional
    @Modifying
    @Query ("update StudentRc s set s.firstName = :name where s.studentId=:id ")
    void updateStudentRc(String name, Integer id);


    @Transactional
    @Modifying
    @Query ("INSERT INTO StudentRc(studentName, firstName,lastName, studentEmail, studentPhone) " +
            "VALUES ( :name, :firstname, :lastname, :email, :phone) ")
    void insertStudentRc(String name, String firstname, String lastname, String email, String phone);

}
