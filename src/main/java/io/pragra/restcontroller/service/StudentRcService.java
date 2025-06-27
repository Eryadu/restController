package io.pragra.restcontroller.service;

import io.pragra.restcontroller.entity.StudentRc;
import io.pragra.restcontroller.repo.StudentRcRepo;
import io.pragra.restcontroller.util.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentRcService {

    @Autowired
    StudentRcRepo studentRcRepo;

    @Autowired
    StudentUtils studentUtils;

    //To fetch all student from Db
    public List<StudentRc> getAllStudentRc() {
        return studentRcRepo.findAll();
    }

    //Fetch Student by ID only
    public Optional<StudentRc> getStudentRcById(int id) {
        Optional<StudentRc> studentRc = studentRcRepo.findById(id);
            return studentRc;
    }

    //Create new entry
    public StudentRc createStudentRc(StudentRc studentRc) {
        return studentRcRepo.save(studentRc);
    }

    //Update data in Db
    public StudentRc updateStudentRc(StudentRc studentRc) {
        Optional<StudentRc> studentRc1 = studentRcRepo.findById(studentRc.getStudentId());
        if(studentRc1.isPresent()) {
            return studentRcRepo.save(studentRc);
        }
        return studentRc;
    }

    //Patch
    // dto object of StudentRc is coming from Db
    // entity object of StudentRc is coming from front request
    public StudentRc patchStudentRc(StudentRc dto) {
        Optional<StudentRc> studentRc1 = studentRcRepo.findById(dto.getStudentId());
            //Entity is coming from Db and Dto is coming from FrontEnd
        StudentRc entity= null;
        if(!studentRc1.isPresent()) {
            return null;
        }
        entity = studentRc1.get();

        // we can write all data in util class
        /*if(Objects.nonNull(dto.getStudentName())){
            entity.setStudentName(dto.getStudentName());
        }
        if(Objects.nonNull(dto.getStudentEmail())){
            entity.setStudentEmail(dto.getStudentEmail());
        }
        if (Objects.nonNull(dto.getStudentPhone())){
            entity.setStudentPhone(dto.getStudentPhone());
        }*/

        studentUtils.convertPatchDto(dto, entity);
        return studentRcRepo.save(entity);

        // implementation by Lambda
        /*return studentRcRepo.findById(dto.getStudentId())
                .map(entity -> {
                    studentUtils.convertPatchDto(dto, entity);
                    return studentRcRepo.save(entity);
                })
                .orElse(null);
                //.orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + dto.getStudentId()));*/

    }

    //Find by Name
    public List<StudentRc> findStudentRcByStudentName(String name) {
       return studentRcRepo.findAllByStudentName(name);
    }

    //Find by NameAndEmail
    public List<StudentRc> findStudentRcByStudentNameAndEmail(String name,String email) {
        return studentRcRepo.findAllByStudentNameAndStudentEmail(name,email);
    }

    //find and add list of StudentRc
    public List<StudentRc> addMultipleStudentRc(List<StudentRc> studentRcList) {
        List<StudentRc> studentRcList1 = studentRcRepo.findAll();
        //studentRcList1.sort(new NameComparator());
        // Other Option if don't want to create different class for Comparator
        studentRcList1.sort(Comparator.comparing(StudentRc::getStudentName));
        return studentRcRepo.saveAll(studentRcList);
    }

    //Delete Entry
    public StudentRc deleteStudentRc(Integer id) {
        Optional<StudentRc> studentRc2 = studentRcRepo.findById(id);
        if(!studentRc2.isPresent()) {
            return null;
        }
        //it returned optional studentRc object, so we convert first to studentRc object
            StudentRc studentRc3 = studentRc2.get();
            studentRcRepo.delete(studentRc3);
            return studentRc3;
    }

    //findAllLastNameByFirstName
    public List<String> findStudentRcByLastName(String name){
        return studentRcRepo.findAllLastNameByFirstName(name);
    }

    // deleteStudentByName
    public void deleteStudentRcByName(String name){
          studentRcRepo.deleteByStudentName(name);
    }

    // updateStudentRcByName HQL
    public void updateStudentRcName(String name, Integer id) {
        studentRcRepo.updateStudentRc(name, id);
    }

    //insertStudentRcByHQL
    public void insertStudentRcByHQL(String name, String firstname, String lastname, String email, String phone) {
        studentRcRepo.insertStudentRc(name, firstname, lastname, email, phone);
    }
}

