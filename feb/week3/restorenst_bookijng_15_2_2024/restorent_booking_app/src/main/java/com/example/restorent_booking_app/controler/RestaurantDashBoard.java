package com.example.restorent_booking_app.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")
public class RestaurantDashBoard {

    @GetMapping("/dashBoard")
    public String restaurantDashBoard() {
        return "restaurantPages/restaurantDashBoard";
    }

}
