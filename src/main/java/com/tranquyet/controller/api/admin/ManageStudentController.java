package com.tranquyet.controller.api.admin;

import com.tranquyet.dto.StudentDTO;
import com.tranquyet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://app-manage-student.herokuapp.com/")
//@CrossOrigin(origins = "http://localhost:3000/")
@RestController(value = "manageStudentApiAdmin")
@RequestMapping(value = "/api/student")
public class ManageStudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<StudentDTO> getAll() {
        StudentDTO dto = new StudentDTO();
        dto.setListResult(studentService.getAll());
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
