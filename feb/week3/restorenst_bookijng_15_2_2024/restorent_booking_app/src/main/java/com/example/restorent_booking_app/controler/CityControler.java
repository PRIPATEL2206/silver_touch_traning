package com.example.restorent_booking_app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restorent_booking_app.constants.DefultValue;
import com.example.restorent_booking_app.models.AreaModel;
import com.example.restorent_booking_app.models.CityModel;
import com.example.restorent_booking_app.repos.AreaRepo;
import com.example.restorent_booking_app.repos.CityRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class CityControler {

    @Autowired
    CityRepo cityRepo;

    @Autowired
    AreaRepo areaRepo;

    @GetMapping("/manageCity")
    public String manageCityPage(Model model, Pageable pageable) {
        model.addAttribute("cities", cityRepo.findAll());
        pageable = PageRequest.of(pageable.getPageNumber(), DefultValue.MAX_PAGE);
        Page<CityModel> pageContent = cityRepo.findAll(pageable);
        model.addAttribute("currentPage", pageContent.getNumber());
        model.addAttribute("totalPages", pageContent.getTotalPages());
        model.addAttribute("cities", pageContent.getContent());
        return "adminPages/manageCity";
    }

    @GetMapping("/addCity")
    public String addCityPage() {
        return "adminPages/addCity";
    }

    @PostMapping("/addCity")
    public String addCity(@ModelAttribute CityModel city) {
        cityRepo.save(city);
        return "redirect:manageCity";
    }

    @GetMapping("/editCity/{cityId}")
    public String editCityPage(@PathVariable Long cityId, Model model) {

        model.addAttribute("city", cityRepo.getReferenceById(cityId));
        return "adminPages/addCity";
    }

    @PostMapping("/editCity/{cityId}")
    public String editCity(@PathVariable Long cityId, Model model, @ModelAttribute CityModel city) {
        city.setId(cityId);
        cityRepo.save(city);
        return "redirect:../manageCity";
    }

    @GetMapping("/deleteCity/{cityId}")
    public String deleteCity(@PathVariable Long cityId) {
        List<AreaModel> areaOfCity = areaRepo.findAllByCityId(cityId);
        for (int i = 0; i < areaOfCity.size(); i++) {
            areaRepo.delete(areaOfCity.get(i));
        }
        cityRepo.delete(cityRepo.getReferenceById(cityId));
        return "redirect:../manageCity";
    }

}
