package com.miniproject.absenhrweb.controller;

import com.miniproject.absenhrweb.service.AttendanceTodayService;
import com.miniproject.absenhrweb.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;
    private final AttendanceTodayService attendanceTodayService;

    public DashboardController(
            DashboardService dashboardService,
            AttendanceTodayService attendanceTodayService) {

        this.attendanceTodayService = attendanceTodayService;
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public String dashboard(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            Model model) {

            model.addAttribute(
                "dashboard",
                dashboardService.getDashboardSummary());

            model.addAttribute(
                    "tableTitle",
                    "Attendance Report");

            model.addAttribute(
                    "attendanceList",
                    attendanceTodayService.getTodayAttendances());

            model.addAttribute(
                    "tableTitle",
                    "Today's Attendance");

                return "admin/dashboard";
    }
}