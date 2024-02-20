package com.example.restorent_booking_app.controler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restorent_booking_app.constants.DefultValue;
import com.example.restorent_booking_app.constants.Roles;
import com.example.restorent_booking_app.models.ComplaintModel;
import com.example.restorent_booking_app.models.OfferModel;
import com.example.restorent_booking_app.repos.CategoryRepo;
import com.example.restorent_booking_app.repos.ComplaintRepo;
import com.example.restorent_booking_app.repos.OfferRepo;
import com.example.restorent_booking_app.repos.SubCategoryRepo;
import com.example.restorent_booking_app.repos.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;

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
    public String displayOffers(Model model, Pageable pageable) {
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
        model.addAttribute("categories", categories);
        model.addAttribute("subCategories", subCategories);

        // pagination
        pageable = PageRequest.of(pageable.getPageNumber(), DefultValue.MAX_PAGE);
        Page<OfferModel> offers = offerRepo.findAll(pageable);
        model.addAttribute("currentPage", offers.getNumber());
        model.addAttribute("totalPages", offers.getTotalPages());
        model.addAttribute("offers", offers.getContent());
        return "adminPages/offerDetails";
    }

    @GetMapping("manageComplaint")
    public String displayComplaint(Model model, Pageable pageable) {
        Map<Long, String> restaurants = new HashMap<>();
        userRepository.findAll().forEach(res -> {
            if (res.getRoles().contains(Roles.RESTORENT)) {
                restaurants.put(res.getId(), res.getUsername());
            }
        });

        pageable = PageRequest.of(pageable.getPageNumber(), DefultValue.MAX_PAGE);
        Page<ComplaintModel> complaintPage = complaintRepo.findAll(pageable);

        model.addAttribute("complaints", complaintPage.getContent());
        model.addAttribute("currentPage", complaintPage.getNumber());
        model.addAttribute("totalPages", complaintPage.getTotalPages());
        model.addAttribute("restaurants", restaurants);

        return "adminPages/complaintDetails";
    }

    @PostMapping("reply/{cid}")
    public String postMethodName(@PathVariable Long cid, HttpServletRequest req) {
        ComplaintModel complaint = complaintRepo.getReferenceById(cid);
        complaint.setReply(req.getParameter("reply"));
        complaint.setStatus("replyed");
        complaint.setReplyDate(new Date().toString());
        complaintRepo.save(complaint);
        return "redirect:/admin/manageComplaint";
    }

    @GetMapping("reply/{cid}")
    public String replyPage(@PathVariable Long cid, Model model) {
        model.addAttribute("complain", complaintRepo.getReferenceById(cid));

        return "adminPages/reply";
    }

}
