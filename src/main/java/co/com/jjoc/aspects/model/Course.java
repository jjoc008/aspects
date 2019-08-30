package co.com.jjoc.aspects.model;

import co.com.jjoc.aspects.utils.Mask;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private String code;
    @Mask(charMask = "0", from = 2, end = 6)
    private String name;

}
