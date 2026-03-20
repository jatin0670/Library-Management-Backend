package com.librarymanagement.LibraryManagement.controller;

import com.librarymanagement.LibraryManagement.dto.StudentDTO;
import com.librarymanagement.LibraryManagement.service.imp.StudentServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentServiceImp studentservice;

    @GetMapping("/allstudents")
    public List<StudentDTO> getStudent(){
        return studentservice.getAllStudent();
    }

    @PostMapping("/student")
    public StudentDTO postStudent(@RequestBody StudentDTO studentdto){
        return studentservice.createStudent(studentdto);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentservice.deleteStudent(id);
        return "Student Deleted";
    }

}
