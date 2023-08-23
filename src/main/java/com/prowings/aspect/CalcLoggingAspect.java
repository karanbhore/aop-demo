package com.prowings.aspect;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalcLoggingAspect {

	@Pointcut("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void mypointcut() {

	}

	@Before("mypointcut()")
	public void logBeforeAddition(JoinPoint joinpoint) {
		System.out.println("logBefore addition() is running!");
		System.out.println("hijacked : " + joinpoint.getSignature().getName());
		System.out.println("_____________________________");
	}

	@AfterReturning("mypointcut()")
	public void logAfterReturningAddition(JoinPoint joinpoint) {
		System.out.println("logAfterReturning addition() is running!");
		System.out.println("hijacked : " + joinpoint.getSignature().getName());
		System.out.println("_____________________________");
	}

	@AfterThrowing("mypointcut()")
	public void logAfterThrowingAddition(JoinPoint joinpoint) {
		System.out.println("logAfterThrowing addition() is running!");
		System.out.println("hijacked : " + joinpoint.getSignature().getName());
		System.out.println("_____________________________");
	}

	@After("mypointcut()")
	public void logAfterAddition(JoinPoint joinpoint) {
		System.out.println("logAfter addition() is running!");
		System.out.println("hijacked : " + joinpoint.getSignature().getName());
		System.out.println("_____________________________");
	}

	@Around("execution(* com.prowings.service.Calculator.sum(..))")
	public void logAroundsum(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("**LoggingAspect.logAroundMethod()-Before method call");

		long start = System.nanoTime();

		Integer result = (Integer) pjp.proceed();
		System.out.println("method returned value =" + result);

		long end = System.nanoTime();
		
		String methodName = pjp.getSignature().getName();
		System.out.println("execution of " + methodName + " took" + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

		System.out.println("********LoggingAspect.logAroundMethod() -After method call");
		System.out.println("_____________________________");
	}

}
