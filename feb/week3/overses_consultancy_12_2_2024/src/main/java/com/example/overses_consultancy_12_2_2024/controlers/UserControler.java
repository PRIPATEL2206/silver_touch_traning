package com.example.overses_consultancy_12_2_2024.controlers;

import java.io.IOException;
import java.nio.file.Path;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.overses_consultancy_12_2_2024.constants.Roles;
import com.example.overses_consultancy_12_2_2024.models.Appointment;
import com.example.overses_consultancy_12_2_2024.models.User;
import com.example.overses_consultancy_12_2_2024.repos.ApointmentRepo;
import com.example.overses_consultancy_12_2_2024.repos.UserRepository;
import com.example.overses_consultancy_12_2_2024.services.ImageUploadServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserControler {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ApointmentRepo apointmentRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String userRedirect(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).orElseThrow();
        if (user.getRoles().contains(Roles.cunsoltent)) {
            return "redirect:/cunsoltent/" + user.getId();
        }
        return "redirect:/student/" + user.getId();
    }

    @GetMapping("/student/{id}")
    public String studentDashBord(@PathVariable("id") Long studentId, Model model) {
        List<User> consoltents = new ArrayList<>();
        List<User> allUser = userRepository.findAll();
        List<Appointment> appointments = this.getApoitmentsOfStudent(studentId);
        for (User user : allUser) {
            if (user.getRoles().contains(Roles.cunsoltent)) {
                consoltents.add(user);
            }
        }
        model.addAttribute("consoltents", consoltents);
        model.addAttribute("appointments", appointments);
        return "studentDashBord";
    }

    @GetMapping("/cunsoltent/{id}")
    public String cunsoltentDashBord(@PathVariable("id") Long cunsoltentId, Model model) {

        List<Appointment> appointments = this.getApoitmentsOfcunsoltent(cunsoltentId);
        System.out.println(appointments);
        model.addAttribute("appointments", appointments);

        return "cunsoltentDashBord";
    }

    @GetMapping("/approve/{id}")
    public String aprove(@PathVariable("id") Long apointmentId) {
        Appointment appointment = apointmentRepo.getReferenceById(apointmentId);
        appointment.setStatus("aprove");

        apointmentRepo.save(appointment);
        return "redirect:/";
    }

    @GetMapping("/decline/{id}")
    public String decline(@PathVariable("id") Long apointmentId) {
        Appointment appointment = apointmentRepo.getReferenceById(apointmentId);
        appointment.setStatus("decline");

        apointmentRepo.save(appointment);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updatePageUrl(Principal principal) {
        Long id = userRepository.findByUsername(principal.getName()).orElseThrow().getId();
        return "redirect:/updateUser/" + id;
    }

    @GetMapping("/updateUser/{id}")
    public String updateUserPage(@PathVariable Long id, Model model) {
        User user = userRepository.getReferenceById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute User updatedUser, @PathVariable Long id,
            @RequestParam("image") MultipartFile file) throws IOException {
        User user = userRepository.getReferenceById(id);
        user.setEmail(updatedUser.getEmail());
        user.setSpecification(updatedUser.getSpecification());
        System.out.println("profile : " + updatedUser.getProfile());
        if (updatedUser.getProfile() != null && !user.getProfile().equals(updatedUser.getProfile())) {
            Path fileNameAndPath = ImageUploadServices.uploadImage(file);
            user.setProfile(fileNameAndPath.toString());
        }
        userRepository.save(user);
        return "redirect:/updateUser/" + user.getId();
    }

    @GetMapping("user/changePassword/{id}")
    public String changePasswordPage(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "changePassword";
    }

    @PostMapping("user/changePassword/{id}")
    public String changePassword(HttpServletRequest request, @PathVariable Long id) {
        User user = userRepository.getReferenceById(id);
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("newPassword");
        System.out.println(oldPass);
        // System.out.println(user.getPassword());
        System.out.println(passwordEncoder.encode(oldPass).equals(user.getPassword()));
        if (passwordEncoder.encode(oldPass).equals(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPass));
            return "redirect:/";
        }
        return "redirect:/user/changePassword/{id}";
    }

    public List<Appointment> getApoitmentsOfcunsoltent(Long cunsId) {
        List<Appointment> userApoitments = new ArrayList<>();
        apointmentRepo.findAll().forEach(apoitment -> {
            System.out.println(apoitment.getStatus().equals("decline"));
            if (apoitment.getConsultant_Id() == cunsId && !apoitment.getStatus().equals("decline")) {
                userApoitments.add(apoitment);
            }
        });
        return userApoitments;
    }

    public List<Appointment> getApoitmentsOfStudent(Long stid) {
        List<Appointment> userApoitments = new ArrayList<>();
        apointmentRepo.findAll().forEach(apoitment -> {
            if (apoitment.getStudent_Id() == stid) {
                userApoitments.add(apoitment);
            }
        });
        return userApoitments;
    }

}
