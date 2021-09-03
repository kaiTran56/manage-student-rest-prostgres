package com.tranquyet.service;

import com.tranquyet.dto.StudentDTO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDTO> findAll();

    List<StudentDTO> findStudentByCourse(String codeOfCourse);

    public List<StudentDTO> getAll();

    int getTotalItems();

    StudentDTO findById(Long id);

    StudentDTO save(StudentDTO dto);

    void delete(Long[] ids);

}
