package com.tranquyet.service.impl;

import com.tranquyet.converter.CourseConverter;
import com.tranquyet.dto.CourseDTO;
import com.tranquyet.repository.CourseRepository;
import com.tranquyet.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseConverter courseConverter;
    @Override
    public List<CourseDTO> findAll() {
        List<CourseDTO> courseDTOList = new ArrayList<>();
        courseRepository.findAll().forEach(p->{
            courseDTOList.add(courseConverter.toDTO(p));
        });
        return courseDTOList;
    }

    @Override
    public int getTotalItems() {
        return 0;
    }

    @Override
    public CourseDTO findById(Long id) {
        return null;
    }

    @Override
    public CourseDTO findByName(String name) {
        return null;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }
}
