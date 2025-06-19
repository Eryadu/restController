package io.pragra.restcontroller.Controller;


import io.pragra.restcontroller.entity.StudentRc;
import io.pragra.restcontroller.repo.StudentRcRepo;
import io.pragra.restcontroller.Service.StudentRcService;
import io.pragra.restcontroller.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;
import java.util.Optional;

@RestController() // combination of @controller and @responseBody
//@Controller

@RequestMapping("/studentRc")
public class StudentRcController {

    @Autowired
    StudentRcService studentRcService;
    @Autowired
    private StudentRcRepo studentRcRepo;
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE) // produce() is option, implement
    // by library as well i.e. KafkaApache

    //@ResponseBody // it should be used with @Controller to return the HTTp ResponseBody(XML, JSON)
    public List<StudentRc> displayAllStudentRc(){
        return studentRcService.getAllStudentRc();
    }

    @PostMapping("/byId")
    // in query parameter we give value in key-value pair, key is always in string and value
    // would be anything Int, String, Boolean
    public Optional<StudentRc> getStudentRcById(@RequestParam("id") Integer identification){
        Optional<StudentRc> studentRc = studentRcService.getStudentRcById(identification);
        return studentRc;
    }

    @PostMapping("/byId/{id}/{id1}")
    // in path variable we give value direct in url (part of url), we match the value with key and then assign that
    //value to variable
    //in both case Query and path, if key passed in mapping method is same to @RequestParam and variable, then
    // we can eliminate key in @RequestParam as its automatically assigned
    // The names inside @PathVariable("...") must match the placeholders in the URL.

   // public Optional<StudentRc> getStudentRcByPathId(@PathVariable("id") Integer identity)
    public Optional<StudentRc> getStudentRcByPathId(@PathVariable Integer id, @PathVariable Integer id1){
        // as all Key and variable are same(ID) so removed key one and directly
        // mapped passing value with variable, Cause Java automatically detect method and classes
        Optional<StudentRc> studentRc = studentRcService.getStudentRcById(id);
        return studentRc;
    }

    @PostMapping("/create")
    public StudentRc addStudentRc(@RequestBody StudentRc studentRc){
        return studentRcService.createStudentRc(studentRc);
    }

    @PutMapping("/update")
    public StudentRc updateStudentRc(@RequestBody StudentRc studentRc){
        return studentRcService.updateStudentRc(studentRc);
    }

    @PatchMapping("/patch")
    public ResponseEntity<StudentRc> patchStudentRc(@RequestBody StudentRc studentRc){
        StudentRc studentRc1 = studentRcService.patchStudentRc(studentRc);
        ResponseEntity<StudentRc> entityStudent = ResponseEntity.status(HttpStatus.OK)
                .body(studentRc1);
        return entityStudent;
    }

    @GetMapping("/allByName")
    public List<StudentRc> getStudentRcByName(@RequestParam String name){
        return studentRcService.findStudentRcByStudentName(name);
    }
    @GetMapping("/allByNameAndEmail")
    public ResponseEntity<List<StudentRc>> getStudentRcByNameAndEmail(@RequestParam String name, @RequestParam String email){
        List<StudentRc> studentRcByStudentNameAndEmail = studentRcService.findStudentRcByStudentNameAndEmail(name, email);
        return new ResponseEntity<>(studentRcByStudentNameAndEmail, HttpStatus.OK);
    }

    //Save list of Student
    @PostMapping("/studentList")
    public ResponseEntity<List<StudentRc>> addMultipleStudent(@RequestBody List<StudentRc> studentRcList){
        List<StudentRc> studentRcs = studentRcService.addMultipleStudentRc(studentRcList);
        return new ResponseEntity<>(studentRcs, HttpStatus.CREATED);
    }

    // different way to implement the delete or other HTTP methods
    /*@DeleteMapping("/delete/{id}")
    public StudentRc deleteStudentRc(@PathVariable Integer id){
         return studentRcService.deleteStudentRc(id);
    }*/

    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentRcById(@PathVariable Integer id){
        StudentRc stuDeleted = studentRcService.deleteStudentRc(id);
        if(stuDeleted != null){
            return ResponseEntity.ok(" StudentRc with ID " + id + " deleted successfully.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("StudentRc with ID " + id + " not found.");
        }
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudentRcByID(@PathVariable Integer id){
        StudentRc stuDeleted1 = studentRcService.deleteStudentRc(id);
        if(stuDeleted1 != null){
            return ResponseEntity.noContent().build(); // 204 No content
        }else {
            return ResponseEntity.notFound().build(); // 404 Not found
        }
    }

    //@RequestBody Always return Json, XML, so to handle that data we need Object , not handled by primitive Datatype String
    // so we create a DTO first.
    //in case of @RequestParam and @Path Variable, Primitive datatype is fine
    //Just Try with @PostMapping, we can also do with @GetMapping
    // for authentication we can use @RequestHeader
   // @RequestBody is used to extract the HTTP request body data, often in JSON or XML format, and deserialize it into
    // a Java object.

    //@RequestBody is more secure than @RequestParam and @PathVariable
    @PostMapping("/lastname")
    public ResponseEntity<List<String>> getStudentRcByLastName(@RequestBody StudentDTO studentDTO){
        List<String> studentRcByLastName = studentRcService.findStudentRcByLastName(studentDTO.getFirstname());
        ResponseEntity<List<String>> responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(201))
                .contentType(MediaType.APPLICATION_JSON)
                .header("Action", "Created")
                .header("status", String.valueOf("1100"))
                .body(studentRcByLastName);
        return responseEntity;
    }

    @GetMapping("/lastname/{name}")
    public List<String> getStudentRcByLastName(@PathVariable String name){
        return studentRcService.findStudentRcByLastName(name);
    }

    @DeleteMapping("/deletebyname/{name}")
    public ResponseEntity<String> deleteStudentRcByName(@PathVariable String name){
      studentRcService.deleteStudentRcByName(name);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/updatename/{name}/{id}")
    public ResponseEntity<String> updateStudentRcByHQL(@PathVariable String name, @PathVariable Integer id){
        studentRcService.updateStudentRcName(name, id);
        return ResponseEntity.ok("Updated Successfully");
    }

    @PostMapping("/insert/{name}/{firstname}/{lastname}/{email}/{phone}")
    public ResponseEntity<String> insertStudentRc(@PathVariable String name, String firstname,
                                                  String lastname, String email, String phone){
        studentRcService.insertStudentRcByHQL(name, firstname, lastname, email, phone);
        return ResponseEntity.ok("Inserted Successfully");

    }
}
