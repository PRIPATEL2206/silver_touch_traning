package com.example.restorent_booking_app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restorent_booking_app.models.CategoryModel;
import com.example.restorent_booking_app.models.SubCategoryModel;
import com.example.restorent_booking_app.repos.CategoryRepo;
import com.example.restorent_booking_app.repos.SubCategoryRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class CatagoryControler {

    @Autowired
    CategoryRepo catagoryRepo;

    @Autowired
    SubCategoryRepo subCategoryRepo;

    @GetMapping("/manageCategory")
    public String manageCategoryPage(Model model) {
        model.addAttribute("categories", catagoryRepo.findAll());
        return "adminPages/manageCategory";
    }

    @GetMapping("/addCategory")
    public String addCategoryPage() {
        return "adminPages/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCity(@ModelAttribute CategoryModel category) {
        catagoryRepo.save(category);
        return "redirect:manageCategory";
    }

    @GetMapping("/editCategory/{categoryId}")
    public String editCategoryPage(@PathVariable Long categoryId, Model model) {

        model.addAttribute("category", catagoryRepo.getReferenceById(categoryId));
        return "adminPages/addCategory";
    }

    @PostMapping("/editCategory/{categoryId}")
    public String editCategory(@PathVariable Long categoryId, Model model, @ModelAttribute CategoryModel category) {
        category.setId(categoryId);
        catagoryRepo.save(category);
        return "redirect:../manageCategory";
    }

    @GetMapping("/deleteCategory/{categoryId}")
    public String deleteCity(@PathVariable Long categoryId) {
        List<SubCategoryModel> subCategoryOfCategory = subCategoryRepo.findAllByCategoryId(categoryId);
        for (int i = 0; i < subCategoryOfCategory.size(); i++) {
            subCategoryRepo.delete(subCategoryOfCategory.get(i));
        }
        catagoryRepo.delete(catagoryRepo.getReferenceById(categoryId));
        return "redirect:../manageCategory";
    }

}
