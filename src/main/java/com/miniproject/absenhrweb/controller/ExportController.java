package com.miniproject.absenhrweb.controller;

import com.miniproject.absenhrweb.client.ExportClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ExportController {

    private final ExportClient exportClient;

    public ExportController(ExportClient exportClient) {
        this.exportClient = exportClient;
    }

    @GetMapping("/attendance/export/excel")
    public ResponseEntity<byte[]> exportAttendanceExcel(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        byte[] file = exportClient.exportAttendanceExcel(
                startDate.toString(),
                endDate.toString()
        );
        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=attendance-report.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file);
    }
}