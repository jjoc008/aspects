package co.com.jjoc.aspects.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Response {

    protected Integer totalRows;
    protected Integer totalPages;
    protected Integer currentPage;

    public abstract List getData();
    public abstract void setData(List data);
    public abstract Class<?> getClassDto();

}
