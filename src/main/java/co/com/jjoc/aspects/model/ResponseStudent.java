package co.com.jjoc.aspects.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseStudent extends Response {

    private List<Student> data;
    private Class<?> classDto = Student.class;

    @Override
    public void setData(List data) {
        this.data = data;
    }
}
