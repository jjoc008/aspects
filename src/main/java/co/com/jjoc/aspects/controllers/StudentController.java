package co.com.jjoc.aspects.controllers;

import co.com.jjoc.aspects.model.ResponseStudent;
import co.com.jjoc.aspects.model.Student;
import co.com.jjoc.aspects.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {


    @Autowired
    StudentService studentService;


    @GetMapping("/students")
    public ResponseStudent getStudents(@RequestParam Map<String, String> parameters) throws IOException {

        return this.studentService.getStudents(parameters);

    }

}