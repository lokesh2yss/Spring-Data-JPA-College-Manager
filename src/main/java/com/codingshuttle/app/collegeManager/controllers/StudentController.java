package com.codingshuttle.app.collegeManager.controllers;

import com.codingshuttle.app.collegeManager.entities.StudentEntity;
import com.codingshuttle.app.collegeManager.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping(path = "/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity) {
        return studentService.createNewStudent(studentEntity);
    }

    @PutMapping(path = "/{studentId}/admission-record/{admissionRecordId}")
    public StudentEntity assignAdmissionRecordToStudent(@PathVariable Long studentId, @PathVariable Long admissionRecordId) {
        return studentService.assignAdmissionRecordToStudent(studentId, admissionRecordId);
    }
}
