package co.com.jjoc.aspects.services;


import co.com.jjoc.aspects.model.Course;
import co.com.jjoc.aspects.model.ResponseCourse;
import co.com.jjoc.aspects.model.ResponseStudent;
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
import java.util.*;

@Service
public class StudentService {


    public ResponseStudent getStudents(Map<String, String> parameters) throws IOException {

        File file = ResourceUtils.getFile("classpath:student_data.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        ObjectMapper mapper = new ObjectMapper();
        List<Student> list = Arrays.asList(mapper.readValue(jsonData, Student[].class));

        //ordenamiento
        String orderField = parameters.get("orderField");
        String order = parameters.get("order");

        if("name".equals(orderField)){

            if("ASC".equals(order)){
                Collections.sort(list, Comparator.comparing(Student::getName));
            }else{
                Collections.sort(list, Comparator.comparing(Student::getName, Comparator.reverseOrder()));
            }

        }else if("age".equals(orderField)) {

            if("ASC".equals(order)){
                Collections.sort(list, Comparator.comparing(Student::getAge));
            }else{
                Collections.sort(list, Comparator.comparing(Student::getAge, Comparator.reverseOrder()));
            }

        }

        Pageable page = PageRequest.of(Integer.valueOf(parameters.get("page")), Integer.valueOf(parameters.get("items")));

        int start = page.getPageNumber() * page.getPageSize();
        int end = (page.getPageNumber() * page.getPageSize()) + (page.getPageSize());
        end = end > list.size() ?list.size() : end;

        Page<Student> pageContent = new PageImpl<>(list.subList(start,end ), page, list.size());

        ResponseStudent responseStudent = new ResponseStudent();
        responseStudent.setData(pageContent.getContent());
        responseStudent.setCurrentPage(Integer.valueOf(parameters.get("page")));
        responseStudent.setTotalPages(pageContent.getTotalPages());
        responseStudent.setTotalRows(list.size());

        return responseStudent;

    }


}
