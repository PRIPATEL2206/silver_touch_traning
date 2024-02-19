package com.example.restorent_booking_app.controler;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.restorent_booking_app.constants.DefultValue;
import com.example.restorent_booking_app.models.ComplaintModel;
import com.example.restorent_booking_app.repos.ComplaintRepo;
import com.example.restorent_booking_app.repos.UserRepository;
import com.example.restorent_booking_app.services.ImageUploadServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")
public class ComplaintControler {

    @Autowired
    ComplaintRepo complaintRepo;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/manageComplaint")
    public String manageComplaintPage(Model model, Principal principal) {
        List<ComplaintModel> complaints = new ArrayList<>();
        complaintRepo.findAll().forEach(com -> {
            if (com.getDoneByRestorent() == userRepository.findByEmail(principal.getName()).orElseThrow().getId()) {
                complaints.add(com);
            }
        });
        model.addAttribute("complaints", complaints);
        return "restaurantPages/manageComplaint";
    }

    @GetMapping("/addComplaint")
    public String addComplaintPage(Model model) {
        return "restaurantPages/addComplaint";
    }

    @PostMapping("/addComplaint")
    public String addProduct(@ModelAttribute ComplaintModel complaint, @RequestParam("image") MultipartFile file,
            Principal principal)
            throws IOException {
        String complaintImage = DefultValue.profilePic;
        complaintImage = ImageUploadServices.uploadImage(ImageUploadServices.COMPLAINT_UPLOAD_DIRECTORY, file)
                .toString();
        Date date = new Date();
        complaint.setComplaintDate(date.toString());
        complaint.setReply("-");
        complaint.setReplyDate("-");
        complaint.setStatus("pending");
        complaint.setAttachment(complaintImage);
        complaint.setDoneByRestorent(userRepository.findByEmail(principal.getName()).orElseThrow().getId());
        complaintRepo.save(complaint);
        return "redirect:manageComplaint";
    }

}
