package com.example.hello.controlers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.hello.models.User;
import com.example.hello.repos.UserRepo;




@Controller
public class UserDataControler {
    @Autowired
    UserRepo userrepo;

    @GetMapping("/details")
    public String login() {
        return "details";
    }

    @SuppressWarnings("null")
    @PostMapping("/details")
    public String formSubmit(@ModelAttribute User user, RedirectAttributes redirectives) {
        userrepo.save(user);
        return "redirect:/allUsers";		
	}
    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        System.out.println("JFBD");
        model.addAttribute("users", userrepo.findAll());
        System.out.println(userrepo.findAll());
        return "allUser";
    }
    
}
