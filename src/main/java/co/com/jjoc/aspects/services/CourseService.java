package co.com.jjoc.aspects.services;


import co.com.jjoc.aspects.model.Course;
import co.com.jjoc.aspects.model.ResponseCourse;
import co.com.jjoc.aspects.model.Student;
import co.com.jjoc.aspects.utils.OrderUtils;
import co.com.jjoc.aspects.utils.PaginationUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class CourseService {


    public ResponseCourse getCourses(Map<String, String> parameters) throws IOException {

        File file = ResourceUtils.getFile("classpath:course_data.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        ObjectMapper mapper = new ObjectMapper();
        List<Course> list = Arrays.asList(mapper.readValue(jsonData, Course[].class));

        OrderUtils.applyOrderRule(Course.class,list, parameters);
        Page<Course> pageContent = PaginationUtils.getPage(list,Integer.valueOf(parameters.get("page")), Integer.valueOf(parameters.get("items")));

        ResponseCourse responseCourse = new ResponseCourse();
        responseCourse.setData(pageContent.getContent());
        responseCourse.setCurrentPage(Integer.valueOf(parameters.get("page")));
        responseCourse.setTotalPages(pageContent.getTotalPages());
        responseCourse.setTotalRows(list.size());

        return responseCourse;

    }


}
