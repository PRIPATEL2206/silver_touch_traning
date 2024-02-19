package com.example.restorent_booking_app.controler;

import java.io.IOException;
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

import com.example.restorent_booking_app.constants.DefultValue;
import com.example.restorent_booking_app.models.ProductModel;
import com.example.restorent_booking_app.repos.CategoryRepo;
import com.example.restorent_booking_app.repos.ProductRepo;
import com.example.restorent_booking_app.repos.SubCategoryRepo;
import com.example.restorent_booking_app.repos.UserRepository;
import com.example.restorent_booking_app.services.ImageUploadServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")

public class ProductControler {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    SubCategoryRepo subCategoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/manageProduct")
    public String manageProductPage(Model model, Principal principal) {
        Map<Long, String> subCategories = new HashMap<>();
        Map<Long, String> categories = new HashMap<>();
        List<ProductModel> products = new ArrayList<>();

        categoryRepo.findAll().forEach(cat -> categories.put(cat.getId(), cat.getCategoryName()));
        subCategoryRepo.findAll().forEach(subCat -> subCategories.put(subCat.getId(), subCat.getSubCategoryName()));

        productRepo.findAll().forEach(pro -> {
            if (pro.getDoneByRestorent() == userRepository.findByEmail(principal.getName()).orElseThrow().getId()) {
                products.add(pro);
            }
        });
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("subCategories", subCategories);
        return "restaurantPages/manageProductPage";
    }

    @GetMapping("/addProduct")
    public String addProductPage(Model model) {
        model.addAttribute("subCategories", subCategoryRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        return "restaurantPages/addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute ProductModel product, @RequestParam("image") MultipartFile file,
            Principal principal)
            throws IOException {
        String productImge = DefultValue.profilePic;
        productImge = ImageUploadServices.uploadImage(ImageUploadServices.PRODUCT_UPLOAD_DIRECTORY, file)
                .toString();

        product.setDoneByRestorent(userRepository.findByEmail(principal.getName()).orElseThrow().getId());
        product.setProdutImage(productImge);
        productRepo.save(product);
        return "redirect:manageProduct";
    }

    @GetMapping("/editProduct/{productId}")
    public String editProductPage(@PathVariable Long productId, Model model) {
        model.addAttribute("product", productRepo.getReferenceById(productId));
        model.addAttribute("subCategories", subCategoryRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());

        return "restaurantPages/addProduct";
    }

    @PostMapping("/editProduct/{productId}")
    public String editProduct(@PathVariable Long productId, @ModelAttribute ProductModel product,
            @RequestParam("image") MultipartFile file, Principal principal) throws IOException {
        String productImge = DefultValue.profilePic;
        productImge = ImageUploadServices.uploadImage(ImageUploadServices.PRODUCT_UPLOAD_DIRECTORY, file)
                .toString();
        product.setDoneByRestorent(userRepository.findByEmail(principal.getName()).orElseThrow().getId());
        product.setProdutImage(productImge);
        product.setId(productId);
        productRepo.save(product);
        return "redirect:../manageProduct";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        productRepo.delete(productRepo.getReferenceById(productId));
        return "redirect:../manageProduct";
    }

}
