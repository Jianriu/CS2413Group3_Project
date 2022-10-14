package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyController {
    @CrossOrigin
    @GetMapping(value="/")
    public String getMethodName(@RequestParam(required = false) String param) {
        return "Is it working or nah?";
    }
    
}
