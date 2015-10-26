package com.somallg.spring.core.ch7.aspectjannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Autowired
    private InputWrapper inputWrapper;

    @Pointcut("execution(* foo*(String)) && args(s)")
    public void fooString(String s) {

    }

    @Pointcut("execution(* foo*(int)) && args(intValue)")
    public void fooExecution(int intValue) {
    }

    @Pointcut("bean(myDependency*)")
    public void inMyDependency() {
    }

    @Before("fooExecution(intValue) && inMyDependency()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
        inputWrapper.setInputInt(intValue);
        System.out.println("Executing " + joinPoint.getSignature().getDeclaringTypeName() + " " +
                joinPoint.getSignature().getName() + " args " + intValue);
    }

    @Before("fooString(s) && inMyDependency()")
    public void beforeAdviceString(JoinPoint joinPoint, String s) {
        inputWrapper.setInputString(s);
    }

    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int intValue) throws Throwable {
        System.out.println("Before execution: " + pjp.getSignature().getDeclaringTypeName() + " " + pjp.getSignature().getName()
                + " argument: " + intValue);

        Object retVal = pjp.proceed();

        System.out.println("After execution: " + pjp.getSignature().getDeclaringTypeName() + " " + pjp.getSignature().getName()
                + " argument: " + intValue);

        return retVal;
    }

}
