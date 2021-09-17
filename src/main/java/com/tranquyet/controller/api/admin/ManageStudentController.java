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
import java.util.Random;

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

        //studentService.delete(new Long[]{1L});

//        String[] codeClass = {"TIN1", "TIN2", "HOA1", "HOA2"};
//        String[] year = {"2000", "2001", "2002", "2003"};
//        StringBuilder createDate = new StringBuilder();
//        Random random = new Random();
//        for(int i = 0 ; i < 340; i++){
//            int numbRandom = random.nextInt(4);
//            System.out.println(i);
//            StudentDTO tempDTO = new StudentDTO();
//            tempDTO.setName("Demo "+ i);
//            tempDTO.setDob(createDate.append("17/9/").append(year[numbRandom]).toString());
//            tempDTO.setPhone("0969164184");
//            tempDTO.setCodeOfClass(codeClass[numbRandom]);
//            tempDTO.setGender("Nam");
//            studentService.save(tempDTO);
//            createDate.delete(0, createDate.length());
//        }


        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{codeOfCourse}")
    public ResponseEntity<List<StudentDTO>> getStudentByCourse(@PathVariable(required = true) Optional<String> codeOfCourse) {
        List<StudentDTO> listStudent = studentService.findStudentByCourse(codeOfCourse.get());
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO studentDTO) {

        if(!studentService.checkDuplicatedStudent(studentDTO)){
            System.out.println("Hello---------->" + studentDTO.toString());
            studentService.save(studentDTO);
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(studentDTO, HttpStatus.CONFLICT);
    }

    @GetMapping("/validated")
    public ResponseEntity<Boolean> getDuplicatedStudent(@RequestParam(name = "nameStudent") String nameStudent
            , @RequestParam(name = "genderStudent") String genderStudent
            , @RequestParam(name = "dobStudent") String dobStudent) {
        String temp = genderStudent;
        int length=temp.length();
        if(temp.contains("Nu")&&length>2){
            temp = genderStudent.substring(0, length-3);
        }else if(temp.contains("Nam")&&length>3){
            temp = genderStudent.substring(0, length-3);
        }
        StudentDTO tempDTO = new StudentDTO();
        tempDTO.setName(nameStudent);
        tempDTO.setGender(temp);
        tempDTO.setDob(dobStudent);
        boolean checkDuplicated = studentService.checkDuplicatedStudent(tempDTO);
        return new ResponseEntity<>(checkDuplicated, HttpStatus.OK);
    }

}
