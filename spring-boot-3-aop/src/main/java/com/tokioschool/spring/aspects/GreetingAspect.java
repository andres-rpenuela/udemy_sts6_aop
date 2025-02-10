package com.tokioschool.spring.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class GreetingAspect {
	//execution(Return package.class/inter.metodo(args) >> return puede ser {* (a todo), tipo de objeto especifico)
	@Before(value = "execution(String com.tokioschool.spring.services.GreetingService.sayHello(..))") // Punto de corte, si es una interfaz se aplica a cualquier clase que implemente una interfza
	public void loggerBefore(JoinPoint joinPoint) { // Consejo
		final String method = joinPoint.getSignature().getName();
		final String args = Arrays.toString(joinPoint.getArgs());
		
		log.info("Antes: "+method+" con los argumentos "+args);
	}
}
