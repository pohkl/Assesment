package com.sample.assessment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    // Get Currency by POST
    @PostMapping("/currency")
    public String getCurrency(@RequestParam String currencyCode) {
        // Logic to fetch and return currency details
        return "Currency: " + currencyCode;
    
    }
}
