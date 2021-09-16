package com.tranquyet.controller.api.admin;

import com.tranquyet.service.StudentService;
import com.tranquyet.service.excel.ExcelService;
import com.tranquyet.service.excel.StudentStorageService;
import com.tranquyet.util.excel.table.AutoNameGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

//@CrossOrigin(origins = "https://app-manage-student.herokuapp.com/")
@CrossOrigin(origins = "http://localhost:3000/")
@RestController(value = "excelFileApiAdmin")
@RequestMapping(value = "/api/excel")
public class ExcelFileController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/download/{codeOfClass}")
    public ResponseEntity excelCustomersReport(@PathVariable(name = "codeOfClass") Optional<String> codeOfClass) throws IOException {
        String name = codeOfClass.get();
        System.out.println(name);
        if(name.equals("All")){
            StudentStorageService.addStudent(studentService.findAll());
        }else{
            StudentStorageService.addStudent(studentService.findStudentByCourse(name));
        }

        ByteArrayInputStream in = new ExcelService().createDataExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+ AutoNameGeneration.getName());
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }

}
