package com.tokioschool.spring.aspects.pointcuts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {
	
	@Pointcut("execution(String com.tokioschool.spring.services.GreetingService.sayHello(..))")
	public void greetingSayHelloPointCut() {};
	
	@Pointcut("execution(String com.tokioschool.spring.services.GreetingService.*(String,..))")
	public void greetingStringStartParamPointCut() {};
	
	@Pointcut("execution(* com.tokioschool.spring.services.GreetingService.*(..))")
	public void loggerGrretingUpperPC() { };
}
