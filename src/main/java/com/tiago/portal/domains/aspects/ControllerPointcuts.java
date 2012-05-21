package com.tiago.portal.domains.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ControllerPointcuts {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerPointcuts.class);
	
	@Pointcut("@annotation(com.tiago.portal.domains.anotations.Gatekepper)")
	public void gatekeeperOperation(){
	}
	
	@Before(value="gatekeeperOperation() && target(bean)", argNames="bean")
	public void doSomething(JoinPoint jp, Object bean){
		Object[] args = jp.getArgs();
		logger.info("ASASDASSSSSSSSSSSSSSSSSSSSSSSSSSSSS"+ args.toString());
	}
	
}
