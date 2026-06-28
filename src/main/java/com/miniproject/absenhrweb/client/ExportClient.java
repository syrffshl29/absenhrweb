package com.miniproject.absenhrweb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(
        name = "exportClient",
        url = "${host.rest.api}"
)
public interface ExportClient {

    @GetMapping("/hr/attendance/export/excel")
    byte[] exportAttendanceExcel(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate);
}