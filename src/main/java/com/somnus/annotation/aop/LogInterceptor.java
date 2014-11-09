package com.somnus.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	//定义一个方法作为切入点
	@Pointcut("execution(public * com.somnus.annotation.service..*.add(..))")
	public void myMethod(){};
	
	@Before("myMethod()")
//	@Before("execution(public * com.somnus.annotation.service..*.add(..))")
	public void before() 
	{
		System.out.println("method before");
	}
	
	@AfterReturning("myMethod()")
//	@Before("execution(public * com.somnus.annotation.service..*.add(..))")
	public void AfterReturning() 
	{
		System.out.println("method after returning");
	}
	
	@AfterThrowing("myMethod()")
//	@AfterThrowing("execution(public * com.somnus.annotation.service..*.add(..))")
	public void AfterThrowin() 
	{
		System.out.println("method after throwin");
	}
	
	
	@Around("myMethod()")
//	@Around("execution(public * com.somnus.annotation.service..*.add(..))")
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable 
	{
		System.out.println("method around start");
		pjp.proceed();
		System.out.println("method around end");
	}
	
}
