package com.tranquyet.controller.api.admin;

import com.tranquyet.dto.CourseDTO;
import com.tranquyet.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "https://student-management-reactjs.herokuapp.com/")
@RestController(value = "courseControllerAdmin")
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> showAll(){
        List<CourseDTO> courseDTOList = courseService.findAll();
        return new ResponseEntity<>(courseDTOList, HttpStatus.OK);
    }
}
