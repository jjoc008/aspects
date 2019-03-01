package co.com.jjoc.aspects.services;

import co.com.jjoc.aspects.model.ResponseStudent;
import co.com.jjoc.aspects.model.Student;
import co.com.jjoc.aspects.utils.OrderRule;
import co.com.jjoc.aspects.utils.OrderUtils;
import co.com.jjoc.aspects.utils.PageRule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class StudentService {

    @PageRule
    @OrderRule
    public ResponseStudent getStudents(Map<String, String> parameters) throws IOException {

        File file = ResourceUtils.getFile("classpath:student_data.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        ObjectMapper mapper = new ObjectMapper();
        List<Student> list = Arrays.asList(mapper.readValue(jsonData, Student[].class));

        ResponseStudent responseStudent = new ResponseStudent();
        responseStudent.setData(list);

        return responseStudent;

    }


}
