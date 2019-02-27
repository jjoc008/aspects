package co.com.jjoc.aspects.controllers;

import co.com.jjoc.aspects.model.Student;
import co.com.jjoc.aspects.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {


    @Autowired
    StudentService studentService;


    @GetMapping("/students")
    public List<Student> getStudents() throws IOException {

        return this.studentService.getStudents();

    }

}
