package com.miniproject.absenhrweb.controller;

import com.miniproject.absenhrweb.dto.request.LoginRequestDto;
import com.miniproject.absenhrweb.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {

        model.addAttribute(
                "loginRequest",
                new LoginRequestDto());

        return "login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute LoginRequestDto request,
            HttpSession session,
            Model model) {

        try {

            String role = loginService.login(request, session);

            if ("ADMIN".equals(role)) {
                return "redirect:/dashboard";
            }

            return "redirect:/attendance";

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Username atau Password salah");

            model.addAttribute(
                    "loginRequest",
                    request);

            return "login";
        }
    }
}