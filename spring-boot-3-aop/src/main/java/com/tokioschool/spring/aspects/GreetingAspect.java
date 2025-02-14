package com.tokioschool.spring.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(2)
public class GreetingAspect {
	
	@Pointcut("execution(String com.tokioschool.spring.services.GreetingService.sayHello(..))")
	private void greetingSayHelloPointCut() {};
	
	@Pointcut("execution(String com.tokioschool.spring.services.GreetingService.*(String,..))")
	private void greetingStringStartParamPointCut() {};
	//execution(Return package.class/inter.metodo(args) >> return puede ser {* (a todo), tipo de objeto especifico)
	/*@Before(value = "greetingSayHelloPointCut()") // Punto de corte, si es una interfaz se aplica a cualquier clase que implemente una interfza
	public void loggerBefore(JoinPoint joinPoint) { // Consejo
		final String method = joinPoint.getSignature().getName();
		final String args = Arrays.toString(joinPoint.getArgs());
		
		log.info("Antes: "+method+" con los argumentos "+args);
	}
	
	
	@After(value = "greetingSayHelloPointCut()") // Punto de corte, si es una interfaz se aplica a cualquier clase que implemente una interfza
	public void loggerAfter(JoinPoint joinPoint) { // Consejo
		final String method = joinPoint.getSignature().getName();
		final String args = Arrays.toString(joinPoint.getArgs());
		
		log.info("Despues: "+method+" con los argumentos "+args);
	}*/
	
	// reemplaza el before y after
	@Around(value = "greetingSayHelloPointCut()") // Punto de corte, si es una interfaz se aplica a cualquier clase que implemente una interfza
	public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // Consejo
		// before
		final String method = proceedingJoinPoint.getSignature().getName();
		final String args = Arrays.toString(proceedingJoinPoint.getArgs());
		
		log.info("@Around: "+method+" con los argumentos "+args);
		
		// ejecuta el meotod
		Object result = proceedingJoinPoint.proceed();
		
		//after 
		return result;
	}
	
	// despues del return, join point para cualquier metodo de GreetingService, que tenga como parametro inicila un string
	@AfterReturning("greetingStringStartParamPointCut()")
	public void loggerAfterReturning(JoinPoint joinPoint) {
		final String method = joinPoint.getSignature().getName();
		final String args = Arrays.toString(joinPoint.getArgs());
		
		log.info("@AfterReturning: "+method+" con los argumentos "+args);
	}
	
	// despues del Throwin, join point para cualquier metodo de GreetingService que genere una excepcion
	@AfterThrowing("execution(* com.tokioschool.spring.services.GreetingService.*(..))")
	public void loggerThrowing(JoinPoint joinPoint) {
		final String method = joinPoint.getSignature().getName();
		final String args = Arrays.toString(joinPoint.getArgs());
		
		log.info("@AfterThrowing: "+method+" con los argumentos "+args);
	}
	
}
