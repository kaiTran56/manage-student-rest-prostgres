package com.tranquyet.service.impl;

import com.tranquyet.converter.StudentConverter;
import com.tranquyet.dto.StudentDTO;
import com.tranquyet.entity.CourseEntity;
import com.tranquyet.entity.StudentEntity;
import com.tranquyet.repository.CourseRepository;
import com.tranquyet.repository.StudentRepository;
import com.tranquyet.service.StudentService;
import com.tranquyet.util.constant.value.ConstantValue;
import com.tranquyet.util.student.AutoCodeGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentConverter studentConverter;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> listStudent = new ArrayList<StudentDTO>();
        studentRepository.findAll().forEach(p -> {
            listStudent.add(studentConverter.toDTO(p));
        });
        return listStudent;
    }

    @Override
    public List<StudentDTO> findStudentByCourse(String codeOfCourse) {
        CourseEntity courseEntity = courseRepository.findOneByName(codeOfCourse);
        List<StudentDTO> listStudent = new ArrayList<>();
        if (courseEntity != null) {
            listStudent = studentRepository.getStudentByCourse(courseEntity.getId())
                    .stream().filter(p -> p != null).map(p -> studentConverter.toDTO(p))
                    .collect(Collectors.toList());
        }
        return listStudent;
    }

    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> listStudent = new ArrayList<StudentDTO>();
        studentRepository.getAll().forEach(p -> {
            listStudent.add(studentConverter.toDTO(p));
        });
        return listStudent;
    }

    @Override
    public int getTotalItems() {
        return (int) studentRepository.count();
    }

    @Override
    public StudentDTO findById(Long id) {
        return null;
    }

    @Override
    public StudentDTO save(StudentDTO dto) {
        CourseEntity courseEntity = courseRepository.findOneByName(dto.getCodeOfClass());
        StudentEntity studentTemp = new StudentEntity();
        if (dto.getId() != null) {
            StudentEntity old = studentRepository.findOneById(dto.getId());
            old = studentConverter.toEntity(dto);
            old.setCourse(courseEntity);
            studentTemp = old;
        } else  {
            studentTemp = studentConverter.toEntity(dto);
            studentTemp.setCourse(courseEntity);
            studentTemp.setCode(AutoCodeGeneration.generateCode());
        }
        return studentConverter.toDTO(studentRepository.save(studentTemp));
    }

    @Override
    public void delete(Long[] ids) {
//        for (Long id : ids) {
//            StudentDTO dto = findById(id);
//            dto.setDeleteTag(ConstantValue.DELETE_TAG);
//            save(dto);
//        }
        studentRepository.deleteAll();
    }

    @Override
    public boolean checkDuplicatedStudent(StudentDTO dto) {
        Optional<StudentEntity> checkNullEntity = Optional.of(studentConverter.toEntity(dto));
        return checkNullEntity.filter(studentEntity -> studentRepository.getDuplicateStudent(studentEntity.getName()
                , studentEntity.getGender()
                , studentEntity.getDob())).isPresent();
    }
}
