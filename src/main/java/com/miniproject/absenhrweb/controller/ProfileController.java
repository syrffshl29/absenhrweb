package com.miniproject.absenhrweb.controller;

import com.miniproject.absenhrweb.dto.request.EmployeeRequestDto;
import com.miniproject.absenhrweb.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private final EmployeeService employeeService;

    public ProfileController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/profile")
    public String profile(
            HttpSession session,
            Model model) {

        model.addAttribute(
                "employee",
                employeeService.getProfile(session));

        return "profile/view";
    }

    @GetMapping("/profile/edit")
    public String editProfile(
            HttpSession session,
            Model model) {

        model.addAttribute(
                "employee",
                employeeService.getProfile(session));

        return "profile/edit";
    }

    @PostMapping("/profile/update")
    public String updateProfile(
            @ModelAttribute EmployeeRequestDto dto,
            HttpSession session) {

        employeeService.updateProfile(session, dto);

        return "redirect:/profile";
    }
}

