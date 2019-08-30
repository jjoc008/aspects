package co.com.jjoc.aspects.services;


import co.com.jjoc.aspects.model.Course;
import co.com.jjoc.aspects.model.ResponseCourse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class CourseService {

    public ResponseCourse getCourses() throws IOException {

        File file = ResourceUtils.getFile("classpath:course_data.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        ObjectMapper mapper = new ObjectMapper();
        List<Course> list = Arrays.asList(mapper.readValue(jsonData, Course[].class));

        ResponseCourse responseCourse = new ResponseCourse();
        responseCourse.setData(list);

        return responseCourse;

    }


}
