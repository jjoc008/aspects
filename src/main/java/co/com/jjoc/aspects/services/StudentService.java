package co.com.jjoc.aspects.services;


import co.com.jjoc.aspects.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {


    public List<Student> getStudents() throws IOException {

        File file = ResourceUtils.getFile("classpath:student_data.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        ObjectMapper mapper = new ObjectMapper();
        List<Student> list = Arrays.asList(mapper.readValue(jsonData, Student[].class));

        return list;

    }


}
