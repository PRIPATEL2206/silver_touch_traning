package com.example.user_admin_crud.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.user_admin_crud.constants.Roles;
import com.example.user_admin_crud.models.AdminModel;
import com.example.user_admin_crud.models.User;
import com.example.user_admin_crud.repos.AdminRepo;
import com.example.user_admin_crud.services.CustomUserDetailsService;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminControler {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping("/adminRegister")
    public String adminRegister() {
        return "registerAdmin";
    }

    @PostMapping("/adminRegister")
    public String registerAdmin(@ModelAttribute AdminModel admin, RedirectAttributes redirectives) {

        try {
            List<String> roles = new ArrayList<>();
            roles.add(Roles.admin);

            User authUser = userDetailsService.registerUser(admin.getUsername(), admin.getEmail(), admin.getPassword(),
                    roles);

            admin.setPassword(authUser.getPassword());
            admin.setRole(Roles.admin);

            adminRepo.save(admin);

        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/adminDashbord";
    }

    @GetMapping("/adminDashbord")
    public String adminDashbord() {
        return "adminDashbord";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String home(Principal principal) {
        User user = userDetailsService.getUserByUserName(principal.getName());
        Boolean isAdmin = user.getRoles().contains(Roles.admin);
        if (isAdmin) {
            // send to admin dashbord
            return "redirect:/adminDashbord";
        }
        return "redirect:/user";
    }

}
