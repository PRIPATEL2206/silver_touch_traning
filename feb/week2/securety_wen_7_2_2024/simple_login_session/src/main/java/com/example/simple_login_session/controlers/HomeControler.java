package com.example.simple_login_session.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeControler {

    String COUNT="COUNT";

    @GetMapping("/")
    public String home(HttpSession session,Model model) {
        model.addAttribute("count",  incrementCount(session));
        return "home";
    }
    @GetMapping("/admin")
    public String admin(HttpSession session) {
        incrementCount(session);
        return "admin";
    }
    @GetMapping("/user")
    public String user(HttpSession session) {
        incrementCount(session);
        return "user";
    }

    int incrementCount(HttpSession session){
        int count=session.getAttribute(COUNT)==null ? 0: (int) session.getAttribute(COUNT);
        session.setAttribute(COUNT, count+1);
        return count;
    }
}
