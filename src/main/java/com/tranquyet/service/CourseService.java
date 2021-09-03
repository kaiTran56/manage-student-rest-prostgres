package com.tranquyet.service;

import com.tranquyet.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    public List<CourseDTO> findAll();

    int getTotalItems();

    CourseDTO findById(Long id);

    CourseDTO findByName(String name);

    CourseDTO save(CourseDTO dto);

    void delete(Long[] ids);

}
