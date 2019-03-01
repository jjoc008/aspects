package co.com.jjoc.aspects.rules;

import co.com.jjoc.aspects.model.Response;
import co.com.jjoc.aspects.utils.OrderUtils;
import co.com.jjoc.aspects.utils.PaginationUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Aspect
@Component
@Order(1)
public class OrderAspect {

    @AfterReturning(value = "@annotation(co.com.jjoc.aspects.utils.OrderRule)", returning = "result")
    public void around(JoinPoint joinPoint, Object result) {

        Map<String,String> parameters = (Map<String,String>) joinPoint.getArgs()[0];
        Response response = (Response) result;

        List data = new ArrayList(response.getData());

        OrderUtils.applyOrderRule(
                response.getClassDto(),
                data,
                parameters
        );

        response.setData(data);

    }

}
