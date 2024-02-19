package com.example.overses_consultancy_12_2_2024.controlers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.overses_consultancy_12_2_2024.models.Appointment;
import com.example.overses_consultancy_12_2_2024.repos.ApointmentRepo;
import com.example.overses_consultancy_12_2_2024.repos.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApointmentControler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApointmentRepo apointmentRepo;

    @GetMapping("/student/bookApointment/{id}")
    public String bookApoinmentPage(@PathVariable("id") Long consoltentId, Principal principal, Model model) {
        Long studentId = (userRepository.findByUsername(principal.getName()).orElseThrow(null)).getId();
        model.addAttribute("studentId", studentId);
        model.addAttribute("consoltentId", consoltentId);
        return "bookApointment";
    }

    @PostMapping("/student/bookApointment/")
    public String bookApointment(HttpServletRequest request) {
        Appointment appointment = new Appointment();
        appointment.setDescription("ok");
        appointment.setStatus("pending");
        appointment.setStartTime(request.getParameter("startTime"));
        appointment.setEndTime(request.getParameter("endTime"));
        appointment.setDescription(request.getParameter("description"));
        appointment.setConsultant_Id(Long.parseLong(request.getParameter("consultant_Id")));
        appointment.setStudent_Id(Long.parseLong(request.getParameter("student_Id")));
        appointment.setCreated_on(appointment.getStartTime());
        appointment.setModified_on(appointment.getStartTime());
        apointmentRepo.save(appointment);
        return "redirect:/";
    }

}