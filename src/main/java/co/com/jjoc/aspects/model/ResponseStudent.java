package co.com.jjoc.aspects.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseStudent {

    private List<Student> data;
    private Integer totalRows;
    private Integer totalPages;
    private Integer currentPage;
}
