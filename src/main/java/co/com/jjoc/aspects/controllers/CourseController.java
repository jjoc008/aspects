package co.com.jjoc.aspects.controllers;

import co.com.jjoc.aspects.model.Course;
import co.com.jjoc.aspects.model.ResponseCourse;
import co.com.jjoc.aspects.model.Student;
import co.com.jjoc.aspects.services.CourseService;
import co.com.jjoc.aspects.services.StudentService;
import co.com.jjoc.aspects.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {


    @Autowired
    CourseService courseService;


    @GetMapping("/courses")
    public ResponseCourse getStudents(@RequestParam Map<String, String> parameters) throws IOException {

        long initialTime = LogUtils.getInitialTime();
        ResponseCourse responseCourse = this.courseService.getCourses(parameters);
        long elapsedTime = LogUtils.getFinalTime(initialTime);

        System.out.println("Llamado a servicio curso tiempo de ejecucion: "+elapsedTime+"ms");
        return responseCourse;

    }

}
