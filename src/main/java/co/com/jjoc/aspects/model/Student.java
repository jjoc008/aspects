package co.com.jjoc.aspects.model;

import co.com.jjoc.aspects.utils.Mask;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

    private String name;
    private String age;
    @Mask(charMask = "-", from = 1 , end = 3)
    private String identificationNumber;
    private String phone;

}
