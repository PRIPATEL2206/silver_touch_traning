package com.example.user_admin_crud.controler;

import java.io.IOException;
import java.nio.file.Path;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.user_admin_crud.constants.Roles;
import com.example.user_admin_crud.models.AdminModel;
import com.example.user_admin_crud.models.EmployeeModel;
import com.example.user_admin_crud.models.User;
import com.example.user_admin_crud.repos.AdminRepo;
import com.example.user_admin_crud.repos.EmployeeRepo;
import com.example.user_admin_crud.services.CustomUserDetailsService;
import com.example.user_admin_crud.services.ImageUploadServices;

@Controller
public class UserControler {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    AdminRepo adminRepo;

    @GetMapping("/addEmployee")
    public String addUser() {
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute EmployeeModel employee, @RequestParam("image") MultipartFile file)
            throws IOException {
        Path fileNameAndPath = ImageUploadServices.uploadImage(file);
        List<String> roles = new ArrayList<>();
        roles.add(Roles.employee);
        User authUser = userDetailsService.registerUser(employee.getUserName(), employee.getEmail(),
                employee.getPassword(),
                roles);
        employee.setRole(Roles.employee);
        employee.setPassword(authUser.getPassword());
        employee.setPhoto(fileNameAndPath.toString());
        employeeRepo.save(employee);
        return "redirect:/addEmployee";
    }

    @GetMapping("/allUsers")
    public String getAllUser(Model model) {
        model.addAttribute("employees", employeeRepo.findAll());
        model.addAttribute("admins", adminRepo.findAll());
        return "allUsers";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable("id") int employeeId, Model model) {
        System.err.println(employeeId);
        EmployeeModel emp = employeeRepo.getReferenceById(employeeId);
        employeeRepo.delete(emp);
        return "redirect:/allUsers";
    }

    @GetMapping("deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable("id") int employeeId, Model model) {
        AdminModel admin = adminRepo.getReferenceById(employeeId);
        adminRepo.delete(admin);
        return "redirect:/allUsers";
    }

    @GetMapping("updateEmployee/{id}")
    public String getUpdatePage(@PathVariable("id") int employeeId, Model model) {
        EmployeeModel emp = employeeRepo.getReferenceById(employeeId);
        model.addAttribute("employee", emp);
        return "updateEmployee";
    }

    @GetMapping("updateAdmin/{id}")
    public String getAdminUpdatePage(@PathVariable("id") int employeeId, Model model) {
        AdminModel admin = adminRepo.getReferenceById(employeeId);
        model.addAttribute("admin", admin);
        return "updateAdmin";
    }

    @PostMapping("updateEmployee/{id}")
    public String updatePage(@PathVariable("id") int employeeId, @ModelAttribute EmployeeModel updateEmp,
            @RequestParam("image") MultipartFile file) throws IOException {
        Path fileNameAndPath = ImageUploadServices.uploadImage(file);

        // update employee
        updateEmp.setPhoto(fileNameAndPath.toString());
        updateEmp.setId(employeeId);
        employeeRepo.save(updateEmp);
        return "redirect:/allUsers";
    }

    @PostMapping("updateAdmin/{id}")
    public String updateAdminPage(@PathVariable("id") int adminId, @ModelAttribute AdminModel updateAdmin,
            Model model) {
        updateAdmin.setId(adminId);
        adminRepo.save(updateAdmin);
        return "redirect:/allUsers";
    }

    @GetMapping("/user")
    public String userDashBord(Principal principal) {
        String name = principal.getName();
        System.out.println(name);
        EmployeeModel employeeModel = employeeRepo.findByUserName(name)
                .orElseThrow(() -> new UsernameNotFoundException(name));
        return "redirect:/user/" + employeeModel.getId();
    }

    @GetMapping("/user/{id}")
    public String perticularUser(@PathVariable("id") int employeeId, Model model, Principal principal) {
        try {
            EmployeeModel emp = employeeRepo.getReferenceById(employeeId);
            EmployeeModel emp1 = employeeRepo.findByUserName(principal.getName()).orElseThrow();

            if (emp.getId() == emp1.getId()) {
                model.addAttribute("employee", emp);
                return "user";
            }
        } catch (Exception e) {

        }
        return "notFound404";
    }

}
