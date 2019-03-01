package co.com.jjoc.aspects.model;

import co.com.jjoc.aspects.utils.OrderField;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Course {

    @OrderField(name = "code")
    private String code;

    @OrderField(name = "name")
    private String name;

}
