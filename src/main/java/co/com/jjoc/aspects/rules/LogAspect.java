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
    public void around(ProceedingJoinPoint proceedingJoinPoint ) {

        long initialTime = LogUtils.getInitialTime();
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long elapsedTime = LogUtils.getFinalTime(initialTime);

        System.out.println("Llamado a servicio "+proceedingJoinPoint.getSignature().getName()+" : "+elapsedTime+"ms");

    }



}
