package com.somallg.spring.core.ch7.aopnamespace;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class MyAdvice {

    public void simpleBeforeAdviceNoArgs(JoinPoint joinPoint ) {
        System.out.println("Executing " + joinPoint.getSignature().getDeclaringTypeName() + " " +
                joinPoint.getSignature().getName() + " no args ");
    }


    public void simpleBeforeAdviceArgs(JoinPoint joinPoint) {
        System.out.println("Executing " + joinPoint.getSignature().getDeclaringTypeName() + " " +
                joinPoint.getSignature().getName() + " args " + Arrays.toString(joinPoint.getArgs()));
    }

}
