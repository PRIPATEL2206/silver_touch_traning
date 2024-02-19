package com.example.restorent_booking_app.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.restorent_booking_app.constants.Roles;
import com.example.restorent_booking_app.models.User;
import com.example.restorent_booking_app.repos.AreaRepo;
import com.example.restorent_booking_app.repos.CityRepo;
import com.example.restorent_booking_app.repos.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthControler {

    @Autowired
    AreaRepo areaRepo;

    @Autowired
    CityRepo cityRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homeRedirect(Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        if (user.getRoles().contains(Roles.ADMIN)) {
            return "redirect:/admin/dashBoard";
        }
        return "redirect:/restaurant/dashBoard";
    }

    @GetMapping("/registerRestorent")
    public String registerRestorent(Model model) {
        model.addAttribute("cities", cityRepo.findAll());
        model.addAttribute("areas", areaRepo.findAll());
        return "auth/restorentRegister";
    }

    @PostMapping("/registerRestorent")
    public String registerRestorent(@ModelAttribute User restorent) {
        List<String> roles = new ArrayList<>();
        roles.add(Roles.RESTORENT);
        restorent.setRoles(roles);
        restorent.setPassword(passwordEncoder.encode(restorent.getPassword()));
        userRepository.save(restorent);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

}
