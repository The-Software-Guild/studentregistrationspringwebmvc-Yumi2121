package com.softra.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LoggingAspect {
	
	@Around(value = "dummy()")
	public Object logAround(ProceedingJoinPoint pjp) {
		Object returnValue = null;
		
		try {
			String methodname = pjp.getSignature().getName();
			returnValue = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	@Pointcut(value = "execution (* *.save*(..))")
	public void dummy() {
		
	}
	
	 @Before(value = "dummy()")
	//during execution, if any method name start with .save.. then accepting everything and return anything
	public void logBefore(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("Inside " + methodName);
	}
	
	@AfterReturning(value = "dummy()", returning = "r")
	public void logAfter(JoinPoint jp, Object r) {
		String methodName = jp.getSignature().getName();
		System.out.println("Exiting  " + methodName);
	}
	
}
