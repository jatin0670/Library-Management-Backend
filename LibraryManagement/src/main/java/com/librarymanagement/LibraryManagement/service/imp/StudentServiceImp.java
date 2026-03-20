package com.librarymanagement.LibraryManagement.service.imp;

import com.librarymanagement.LibraryManagement.dto.StudentDTO;
import com.librarymanagement.LibraryManagement.entity.StudentEntity;
import com.librarymanagement.LibraryManagement.repository.StudentRepo;
import com.librarymanagement.LibraryManagement.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepo studentrepo;

    @Override
    public List<StudentDTO> getAllStudent(){
       List<StudentEntity> studententiy = studentrepo.findAll();
       List<StudentDTO> studentdto = studententiy
               .stream()
               .map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getEmail(), studentEntity.getRoll(), studentEntity.getCourse())).toList();

       return studentdto;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentdto) {
        StudentEntity studententity = new StudentEntity(null, studentdto.getName(), studentdto.getEmail(), studentdto.getRoll(), studentdto.getCourse());
        StudentEntity saved = studentrepo.save(studententity);
        StudentDTO student = new StudentDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getRoll(), saved.getCourse());
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentrepo.deleteById(id);
    }


}
