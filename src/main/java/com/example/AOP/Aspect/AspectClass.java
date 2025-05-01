package com.example.AOP.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

    @Before("execution(* com.example.AOP.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.AOP.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.AOP.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.AOP.service.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("Exception in method: " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + error);
    }

    @Around("execution(* com.example.AOP.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logging in around method: " + joinPoint.getSignature().getName());
       Object result = joinPoint.proceed();
        System.out.println("Logging in around method after excecution: ");
        return result;
    }

}