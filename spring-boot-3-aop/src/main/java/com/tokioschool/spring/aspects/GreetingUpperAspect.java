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
@Order(1)
public class GreetingUpperAspect {
		
	// example of Order Aspect
	@Before(value = "com.tokioschool.spring.aspects.pointcuts.GreetingServicePointcuts.loggerGrretingUpperPC()") // Punto de corte, si es una interfaz se aplica a cualquier clase que implemente una interfza
	public void loggerbeforeGenericd(JoinPoint joinPoint) throws Throwable { // Consejo
		// before
		final String method = joinPoint.getSignature().getName();
		final String args = Arrays.toString(joinPoint.getArgs()).toUpperCase();
		
		log.info("Before Upper: "+method+" con los argumentos "+args);
		
	}
	
}
