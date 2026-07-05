package com.miniproject.absenhrweb.controller;

import com.miniproject.absenhrweb.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String report(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            Model model) {

        model.addAttribute(
                "dashboard",
                reportService.getDashboardSummary()
        );

        if (startDate != null && endDate != null) {

            model.addAttribute(
                    "attendanceList",
                    reportService.getAttendanceReport(startDate, endDate)
            );

        } else {

            model.addAttribute(
                    "attendanceList",
                    reportService.getAllAttendanceReport()
            );
        }

        model.addAttribute("tableTitle", "Attendance Report");

        return "admin/report";
    }
    @GetMapping("/late-summary")
    public String lateSummary(Model model) {

        model.addAttribute(
                "lateSummary",
                reportService.getLateSummary());

        return "admin/late-summary";
    }
}
