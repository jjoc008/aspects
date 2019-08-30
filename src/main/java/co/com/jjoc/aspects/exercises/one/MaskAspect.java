package co.com.jjoc.aspects.exercises.one;

import co.com.jjoc.aspects.model.Response;
import co.com.jjoc.aspects.services.InitService;
import co.com.jjoc.aspects.utils.LogUtils;
import co.com.jjoc.aspects.utils.MaskUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class MaskAspect {

    public void proccess() throws Throwable {

    }

}
