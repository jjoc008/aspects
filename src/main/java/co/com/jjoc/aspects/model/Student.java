package co.com.jjoc.aspects.model;

import co.com.jjoc.aspects.utils.OrderField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

    @OrderField(name = "name")
    private String name;
    @OrderField(name = "age", type = Integer.class)
    private String age;
    private String identificationNumber;
    private String phone;

}
