package com.example.AOP.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Around("execution(* com.example.AOP.service.*.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Transaction begening");
        Object result;
        try{
            result = joinPoint.proceed();
            System.out.println("Commiting transaction");
        }catch (Throwable th){
            System.out.println("Rollback Transaction");
            throw th;
        }
        return result;
    }
}
