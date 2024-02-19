package com.example.hello.controlers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HelloControler {
   @GetMapping("/hello")
   public String hello() {
    System.out.println("ok1");
       return "hello";
   }
}
