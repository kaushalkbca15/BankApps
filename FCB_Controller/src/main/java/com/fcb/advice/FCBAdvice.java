package com.fcb.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FCBAdvice {

	@Before(value="within(com.fcb.service..*)")
	public void before(JoinPoint joinPoint) {
		Logger logger=Logger.getLogger(joinPoint.getTarget().getClass());
		logger.info("inter into :"+joinPoint.getSignature().getName());
		
		
	}
	@AfterReturning(pointcut="within(com.fcb.service..*)",returning="returnValue")
	public void after(JoinPoint  joinPoint,Object returnValue) {
		Logger logger=Logger.getLogger(joinPoint.getTarget().getClass());
		logger.info("Execution compleated on : "+joinPoint.getSignature().getName()+""+returnValue);
		
	}
	
	
}
