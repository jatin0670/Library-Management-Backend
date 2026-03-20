package com.librarymanagement.LibraryManagement.service;

import com.librarymanagement.LibraryManagement.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public List<StudentDTO> getAllStudent();

    public StudentDTO createStudent(StudentDTO studentdto);

    public void deleteStudent(Long id);
}
