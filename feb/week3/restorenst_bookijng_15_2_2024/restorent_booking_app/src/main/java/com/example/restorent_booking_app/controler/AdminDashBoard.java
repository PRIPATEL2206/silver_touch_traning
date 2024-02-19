package com.example.restorent_booking_app.controler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restorent_booking_app.constants.Roles;
import com.example.restorent_booking_app.repos.CategoryRepo;
import com.example.restorent_booking_app.repos.ComplaintRepo;
import com.example.restorent_booking_app.repos.OfferRepo;
import com.example.restorent_booking_app.repos.SubCategoryRepo;
import com.example.restorent_booking_app.repos.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminDashBoard {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OfferRepo offerRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    SubCategoryRepo subCategoryRepo;

    @Autowired
    ComplaintRepo complaintRepo;

    @GetMapping("/dashBoard")
    public String adminDashBoard() {
        return "adminPages/adminDahBord";
    }

    @GetMapping("manageOffers")
    public String displayOffers(Model model) {
        Map<Long, String> restaurants = new HashMap<>();
        Map<Long, String> categories = new HashMap<>();
        Map<Long, String> subCategories = new HashMap<>();

        userRepository.findAll().forEach(res -> {
            if (res.getRoles().contains(Roles.RESTORENT)) {
                restaurants.put(res.getId(), res.getUsername());
            }
        });
        categoryRepo.findAll().forEach(cat -> categories.put(cat.getId(), cat.getCategoryName()));
        subCategoryRepo.findAll().forEach(subCat -> subCategories.put(subCat.getId(), subCat.getSubCategoryName()));

        model.addAttribute("restaurants", restaurants);
        model.addAttribute("offers", offerRepo.findAll());
        model.addAttribute("categories", categories);
        model.addAttribute("subCategories", subCategories);

        return "adminPages/offerDetails";
    }

    @GetMapping("manageComplaint")
    public String displayComplaint(Model model) {
        Map<Long, String> restaurants = new HashMap<>();
        userRepository.findAll().forEach(res -> {
            if (res.getRoles().contains(Roles.RESTORENT)) {
                restaurants.put(res.getId(), res.getUsername());
            }
        });
        model.addAttribute("complaints", complaintRepo.findAll());
        model.addAttribute("restaurants", restaurants);
        return "adminPages/complaintDetails";
    }

}
