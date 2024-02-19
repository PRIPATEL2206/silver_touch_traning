package com.example.restorent_booking_app.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.restorent_booking_app.models.OfferModel;
import com.example.restorent_booking_app.repos.CategoryRepo;
import com.example.restorent_booking_app.repos.OfferRepo;
import com.example.restorent_booking_app.repos.SubCategoryRepo;
import com.example.restorent_booking_app.repos.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("restaurant/")

public class OffersControler {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    SubCategoryRepo subCategoryRepo;

    @Autowired
    OfferRepo offerRepo;

    @Autowired
    UserRepository userRepository;

    @GetMapping("manageOffers")
    public String manageOffersPage(Model model, Principal principal) {
        Map<Long, String> subCategories = new HashMap<>();
        Map<Long, String> categories = new HashMap<>();
        List<OfferModel> offers = new ArrayList<>();

        categoryRepo.findAll().forEach(cat -> categories.put(cat.getId(), cat.getCategoryName()));
        subCategoryRepo.findAll().forEach(subCat -> subCategories.put(subCat.getId(), subCat.getSubCategoryName()));
        offerRepo.findAll().forEach(off -> {
            if (off.getDoneByRestorent() == userRepository.findByEmail(principal.getName()).orElseThrow().getId()) {
                offers.add(off);
            }
        });
        model.addAttribute("offers", offers);
        model.addAttribute("categories", categories);
        model.addAttribute("subCategories", subCategories);
        return "restaurantPages/manageOffers";
    }

    @GetMapping("addOffer")
    public String addOfferPage(Model model) {
        model.addAttribute("subCategories", subCategoryRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        return "restaurantPages/addOffer";
    }

    @PostMapping("addOffer")
    public String addProduct(@ModelAttribute OfferModel offer, Principal principal) {
        offer.setDoneByRestorent(userRepository.findByEmail(principal.getName()).orElseThrow().getId());
        offerRepo.save(offer);
        return "redirect:manageOffers";
    }

    @GetMapping("editOffer/{offerId}")
    public String editOfferPage(@PathVariable Long offerId, Model model) {
        model.addAttribute("offer", offerRepo.getReferenceById(offerId));
        model.addAttribute("subCategories", subCategoryRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());

        return "restaurantPages/addOffer";
    }

    @PostMapping("editOffer/{offerId}")
    public String editProduct(@PathVariable Long offerId, @ModelAttribute OfferModel offer, Principal principal) {
        offer.setDoneByRestorent(userRepository.findByEmail(principal.getName()).orElseThrow().getId());
        offer.setId(offerId);
        offerRepo.save(offer);
        return "redirect:../manageOffers";
    }

    @GetMapping("deleteOffer/{offerId}")
    public String deleteProduct(@PathVariable Long offerId) {
        offerRepo.delete(offerRepo.getReferenceById(offerId));
        return "redirect:../manageOffers";
    }

}
