package com.example.restorent_booking_app.controler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restorent_booking_app.constants.DefultValue;
import com.example.restorent_booking_app.models.SubCategoryModel;
import com.example.restorent_booking_app.repos.CategoryRepo;
import com.example.restorent_booking_app.repos.SubCategoryRepo;

@Controller
@RequestMapping("/admin")
public class SubCategoryControler {
    @Autowired
    SubCategoryRepo subCategoryRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/manageSubCategory")
    public String manageSubCategoryPage(Model model, Pageable pageable) {
        Map<Long, String> categories = new HashMap<>();

        pageable = PageRequest.of(pageable.getPageNumber(), DefultValue.MAX_PAGE);
        Page<SubCategoryModel> pageContent = subCategoryRepo.findAll(pageable);

        categoryRepo.findAll().forEach(category -> categories.put(category.getId(), category.getCategoryName()));
        model.addAttribute("subCategories", pageContent.getContent());
        model.addAttribute("categories", categories);
        model.addAttribute("currentPage", pageContent.getNumber());
        model.addAttribute("totalPages", pageContent.getTotalPages());

        return "adminPages/manageSubCategory";
    }

    @GetMapping("/addSubCategory")
    public String addSubCategoryPage(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "adminPages/addSubCategory";
    }

    @PostMapping("/addSubCategory")
    public String addSubCategory(@ModelAttribute SubCategoryModel subCategory) {
        subCategoryRepo.save(subCategory);
        return "redirect:manageSubCategory";
    }

    @GetMapping("/editSubCategory/{subCategoryId}")
    public String editSubCategoryPage(@PathVariable Long subCategoryId, Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("subCategory", subCategoryRepo.getReferenceById(subCategoryId));
        return "adminPages/addSubCategory";
    }

    @PostMapping("/editSubCategory/{subCategoryId}")
    public String editSubCategory(@PathVariable Long subCategoryId, Model model,
            @ModelAttribute SubCategoryModel subCategory) {
        subCategory.setId(subCategoryId);
        subCategoryRepo.save(subCategory);
        return "redirect:../manageSubCategory";
    }

    @GetMapping("/deleteSubCategory/{subCategoryId}")
    public String deleteSubCategory(@PathVariable Long subCategoryId) {
        subCategoryRepo.delete(subCategoryRepo.getReferenceById(subCategoryId));
        return "redirect:../manageSubCategory";
    }

}
