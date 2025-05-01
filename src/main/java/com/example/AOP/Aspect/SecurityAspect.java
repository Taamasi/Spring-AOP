package com.example.AOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    @Before("execution(* com.example.AOP.service.*.*(..))")
    public void checkSecurity() {
        System.out.println("Checking security before method execution");
    }
}
