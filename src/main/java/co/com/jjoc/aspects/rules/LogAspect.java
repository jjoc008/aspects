package co.com.jjoc.aspects.rules;

import co.com.jjoc.aspects.model.Response;
import co.com.jjoc.aspects.model.ResponseCourse;
import co.com.jjoc.aspects.utils.LogUtils;
import co.com.jjoc.aspects.utils.OrderUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    @Around(value = "execution(* co.com.jjoc.aspects.controllers.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {

        long initialTime = LogUtils.getInitialTime();

            Object result = proceedingJoinPoint.proceed();

        long elapsedTime = LogUtils.getFinalTime(initialTime);

        System.out.println("Llamado metodo: "+proceedingJoinPoint.getSignature().getName()+" : "+elapsedTime+"ms");

        return result;
    }



}
