package com.example.AOP.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String throwError() {
        throw new RuntimeException("Intentional error for testing AOP");
    }
}
