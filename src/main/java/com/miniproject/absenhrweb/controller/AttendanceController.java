package com.miniproject.absenhrweb.controller;

import com.miniproject.absenhrweb.service.AttendanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(
            AttendanceService attendanceService) {

        this.attendanceService = attendanceService;
    }

    @GetMapping()
    public String attendance(Model model) {

        model.addAttribute(
                "dashboard",
                attendanceService.getDashboard()
        );

        model.addAttribute(
                "histories",
                attendanceService.getHistory()
        );

        return "employee/attendance";
    }

    @PostMapping("/checkin")
    public String checkIn(@RequestParam String location) {

        attendanceService.checkIn(location);

        return "redirect:/attendance";
    }
    @PostMapping("/checkout")
    public String checkOut() {

        attendanceService.checkOut();

        return "redirect:/attendance";
    }

}