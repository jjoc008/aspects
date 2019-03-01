package co.com.jjoc.aspects.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PaginationUtils {

    private PaginationUtils(){super();}

    public static Page getPage(List<?> data, Integer page, Integer items){

        Pageable pageable = PageRequest.of(page, items);

        int start = pageable.getPageNumber() * pageable.getPageSize();
        int end = (pageable.getPageNumber() * pageable.getPageSize()) + (pageable.getPageSize());
        end = end > data.size() ?data.size() : end;

        return new PageImpl<>(data.subList(start,end ), pageable, data.size());

    }

}
