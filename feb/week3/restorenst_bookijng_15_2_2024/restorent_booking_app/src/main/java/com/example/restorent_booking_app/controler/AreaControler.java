package com.example.restorent_booking_app.controler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restorent_booking_app.models.AreaModel;
import com.example.restorent_booking_app.repos.AreaRepo;
import com.example.restorent_booking_app.repos.CityRepo;

@Controller
@RequestMapping("/admin")
public class AreaControler {
    @Autowired
    AreaRepo areaRepo;
    @Autowired
    CityRepo cityRepo;

    @GetMapping("/manageArea")
    public String manageAreaPage(Model model) {
        Map<Long, String> cities = new HashMap<>();
        cityRepo.findAll().forEach(city -> cities.put(city.getId(), city.getCityName()));
        model.addAttribute("areas", areaRepo.findAll());
        // cities.get(cities);
        model.addAttribute("cities", cities);
        return "adminPages/manageArea";
    }

    @GetMapping("/addArea")
    public String addAreaPage(Model model) {
        model.addAttribute("cities", cityRepo.findAll());
        return "adminPages/addArea";
    }

    @PostMapping("/addArea")
    public String addArea(@ModelAttribute AreaModel area) {
        areaRepo.save(area);
        return "redirect:manageArea";
    }

    @GetMapping("/editArea/{areaId}")
    public String editAreaPage(@PathVariable Long areaId, Model model) {
        model.addAttribute("cities", cityRepo.findAll());
        model.addAttribute("area", areaRepo.getReferenceById(areaId));
        return "adminPages/addArea";
    }

    @PostMapping("/editArea/{areaId}")
    public String editArea(@PathVariable Long areaId, Model model, @ModelAttribute AreaModel area) {
        area.setId(areaId);
        areaRepo.save(area);
        return "redirect:../manageArea";
    }

    @GetMapping("/deleteArea/{areaId}")
    public String deleteArea(@PathVariable Long areaId) {
        areaRepo.delete(areaRepo.getReferenceById(areaId));
        return "redirect:../manageArea";
    }

}
