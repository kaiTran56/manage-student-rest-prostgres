package com.tranquyet.converter;

import com.tranquyet.dto.StudentDTO;
import com.tranquyet.entity.CourseEntity;
import com.tranquyet.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    public StudentDTO toDTO(StudentEntity entity){
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        dto.setDob(entity.getDob());
        dto.setGender(entity.getGender());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setCodeOfClass(entity.getCourse().getName());
        dto.setDeleteTag(entity.getDeleteTag());
        dto.setNote(entity.getNote());
        return dto;
    }

    public StudentEntity toEntity(StudentDTO dto){
        StudentEntity entity = new StudentEntity();
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(dto.getCodeOfClass());
        entity.setId(dto.getId());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedBy(dto.getModifiedBy());
        entity.setModifiedDate(dto.getModifiedDate());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setDob(dto.getDob());
        entity.setGender(dto.getGender());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setCourse(courseEntity);
        entity.setDeleteTag(dto.getDeleteTag());
        entity.setNote(dto.getNote());
        return entity;
    }
}
