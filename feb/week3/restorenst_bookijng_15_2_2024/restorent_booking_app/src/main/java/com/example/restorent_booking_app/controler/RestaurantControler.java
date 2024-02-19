package com.example.restorent_booking_app.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.restorent_booking_app.constants.Roles;
import com.example.restorent_booking_app.models.User;
import com.example.restorent_booking_app.repos.AreaRepo;
import com.example.restorent_booking_app.repos.CityRepo;
import com.example.restorent_booking_app.repos.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RestaurantControler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CityRepo cityRepo;

    @Autowired
    AreaRepo areaRepo;

    @GetMapping("/manageRestaurant")
    public String manageRestaurant(Model model) {
        List<User> restaurants = new ArrayList<>();
        Map<Long, String> cities = new HashMap<>();
        Map<Long, String> areas = new HashMap<>();

        userRepository.findAll().forEach(
                user -> {
                    if (user.getRoles().contains(Roles.RESTORENT)) {
                        restaurants.add(user);
                    }

                });
        cityRepo.findAll().forEach(city -> cities.put(city.getId(), city.getCityName()));
        areaRepo.findAll().forEach(area -> areas.put(area.getId(), area.getAreaName()));
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("cities", cities);
        model.addAttribute("areas", areas);
        return "adminPages/manageRestaurant";
    }

}
