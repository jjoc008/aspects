package co.com.jjoc.aspects.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseCourse extends Response {

    private List<Course> data;
    private Class<?> classDto = Course.class;

    @Override
    public void setData(List data) {
        this.data = data;
    }

}
