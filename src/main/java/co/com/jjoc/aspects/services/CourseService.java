package co.com.jjoc.aspects.services;


import co.com.jjoc.aspects.model.Course;
import co.com.jjoc.aspects.model.ResponseCourse;
import co.com.jjoc.aspects.model.Student;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {


    public ResponseCourse getCourses(Map<String, String> parameters) throws IOException {

        File file = ResourceUtils.getFile("classpath:course_data.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        ObjectMapper mapper = new ObjectMapper();
        List<Course> list = Arrays.asList(mapper.readValue(jsonData, Course[].class));

        Pageable page = PageRequest.of(Integer.valueOf(parameters.get("page")), Integer.valueOf(parameters.get("items")));

        int start = page.getPageNumber() * page.getPageSize();
        int end = (page.getPageNumber() * page.getPageSize()) + (page.getPageSize());
        end = end > list.size() ?list.size() : end;

        Page<Course> pageContent = new PageImpl<>(list.subList(start,end ), page, list.size());

        ResponseCourse responseCourse = new ResponseCourse();
        responseCourse.setData(pageContent.getContent());
        responseCourse.setCurrentPage(Integer.valueOf(parameters.get("page")));
        responseCourse.setTotalPages(pageContent.getTotalPages());
        responseCourse.setTotalRows(list.size());

        return responseCourse;

    }


}
