package com.redis.demo.student;

import com.redis.demo.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveUserDetails(@RequestBody Student student) {
        this.studentService.addStudentDetails(student);
        return new ResponseEntity(Utility.generateResponse(student, HttpStatus.OK.toString()), null, HttpStatus.OK);
    }

    @GetMapping("/getall/student/details")
    public ResponseEntity<Object> fetchAllStudentDetails() {
        return new ResponseEntity(Utility.generateResponse(this.studentService.getAllStudentDetails(), HttpStatus.OK.toString()), null, HttpStatus.OK);
    }

    @GetMapping("/get/student/details/{id}")
    public ResponseEntity<Object> getStudentDetails(@PathVariable String id) {
        return new ResponseEntity(Utility.generateResponse(this.studentService.getStudentDetails(id), HttpStatus.OK.toString()), null, HttpStatus.OK);

    }

    @DeleteMapping("/delete/student/details/{id}")
    public ResponseEntity<Object> deleteStudentDetails(@PathVariable String id) {
        return new ResponseEntity(Utility.generateResponse(this.studentService.deleteStudent(id), HttpStatus.OK.toString()), null, HttpStatus.OK);
    }

    @PutMapping("/update/student/details")
    public ResponseEntity<Object> updateStudentDetails(@RequestBody Student student) {
        return new ResponseEntity(Utility.generateResponse(this.studentService.updateStudentDetails(student), HttpStatus.OK.toString()), null, HttpStatus.OK);
    }


}
