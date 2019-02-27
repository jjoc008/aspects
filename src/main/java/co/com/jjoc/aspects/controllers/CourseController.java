package co.com.jjoc.aspects.controllers;

import co.com.jjoc.aspects.model.Course;
import co.com.jjoc.aspects.model.Student;
import co.com.jjoc.aspects.services.CourseService;
import co.com.jjoc.aspects.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CourseController {


    @Autowired
    CourseService courseService;


    @GetMapping("/courses")
    public List<Course> getStudents() throws IOException {

        return this.courseService.getCourses();

    }

}
