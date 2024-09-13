package com.assessment.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam("pram") String itemid) {
    	
    	System.out.println(itemid);
    	
        return "Hello, World!";
    }
    
}
