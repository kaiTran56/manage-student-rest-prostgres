package com.tranquyet.controller.api.admin;

import com.tranquyet.dto.CourseDTO;
import com.tranquyet.dto.StudentDTO;
import com.tranquyet.service.CourseService;
import com.tranquyet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "https://app-manage-student.herokuapp.com/")
@CrossOrigin(origins = "http://localhost:3000/")
@RestController(value = "manageStudentApiAdmin")
@RequestMapping(value = "/api/student")
public class ManageStudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;


    @GetMapping
    public ResponseEntity<StudentDTO> getAll() {
        StudentDTO dto = new StudentDTO();
        dto.setListResult(studentService.getAll());
//        Long[] ids={1L,2L};
//        studentRepository.deleteAll();
//        courseService.delete(ids);

//        CourseDTO courseDTO = new CourseDTO();
//        courseDTO.setName("TIN1");
//        courseService.save(courseDTO);
//        CourseDTO courseDTO_1 = new CourseDTO();
//        courseDTO_1.setName("TIN2");
//        courseService.save(courseDTO_1);
//        CourseDTO courseDTO_2 = new CourseDTO();
//        courseDTO_2.setName("HOA1");
//        courseService.save(courseDTO_2);
//        CourseDTO courseDTO_3 = new CourseDTO();
//        courseDTO_3.setName("HOA2");
//        courseService.save(courseDTO_3);
//        System.out.println("Successfully!");

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{codeOfCourse}")
    public ResponseEntity<List<StudentDTO>> getStudentByCourse(@PathVariable(required = true) Optional<String> codeOfCourse) {
        List<StudentDTO> listStudent = studentService.findStudentByCourse(codeOfCourse.get());
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO studentDTO) {
        System.out.println("Hello---------->"+studentDTO.toString());
        studentService.save(studentDTO);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

}
