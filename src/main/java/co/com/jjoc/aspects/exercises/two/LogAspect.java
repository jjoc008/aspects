package co.com.jjoc.aspects.exercises.two;

import co.com.jjoc.aspects.services.InitService;
import co.com.jjoc.aspects.utils.LogUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogAspect {

	public Object around() throws Throwable {

		return null;
	}

}
