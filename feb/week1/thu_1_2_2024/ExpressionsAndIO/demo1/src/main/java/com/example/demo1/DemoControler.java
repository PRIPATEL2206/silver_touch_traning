package com.example.demo1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoControler {
    @GetMapping("ok")
    public String requestMethodName() {
        return "mfngjfnfjn";
    }
    
}
