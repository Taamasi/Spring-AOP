package com.example.AOP;

import com.example.AOP.service.SampleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return sampleService.sayHello(name);
    }

    @GetMapping("/error")
    public String throwError() {
        return sampleService.throwError();
    }
}
