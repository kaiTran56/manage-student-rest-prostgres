package com.tranquyet.controller.api.admin;

import com.tranquyet.service.StudentService;
import com.tranquyet.service.excel.ExcelService;
import com.tranquyet.service.excel.StudentStorageService;
import com.tranquyet.util.excel.table.AutoNameGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController(value = "excelFileApiAdmin")
@RequestMapping(value = "/api/excel")
public class ExcelFileController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/download")
    public ResponseEntity excelCustomersReport() throws IOException {
        StudentStorageService.addStudent(studentService.getAll());
        ByteArrayInputStream in = new ExcelService().createDataExcel();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", "attachment; filename="+ AutoNameGeneration.getName());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }

}
