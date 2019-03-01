package co.com.jjoc.aspects.rules;

import co.com.jjoc.aspects.model.Course;
import co.com.jjoc.aspects.model.Response;
import co.com.jjoc.aspects.model.ResponseCourse;
import co.com.jjoc.aspects.utils.PaginationUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
@Order(0)
public class PageAspect {

    @AfterReturning(value = "@annotation(co.com.jjoc.aspects.utils.PageRule)", returning = "result")
    public void around(JoinPoint joinPoint, Object result) {

        Map<String,String> parameters = (Map<String,String>) joinPoint.getArgs()[0];
        Response response = (Response) result;

        Page pageContent = PaginationUtils.getPage(response.getData(),Integer.valueOf(parameters.get("page")), Integer.valueOf(parameters.get("items")));

        response.setData(pageContent.getContent());
        response.setCurrentPage(Integer.valueOf(parameters.get("page")));
        response.setTotalPages(pageContent.getTotalPages());
        response.setTotalRows((int)pageContent.getTotalElements());

    }





}
