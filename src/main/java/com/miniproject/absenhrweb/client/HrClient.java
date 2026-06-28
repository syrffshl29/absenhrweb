package com.miniproject.absenhrweb.client;

import com.miniproject.absenhrweb.dto.response.DashboardSummaryDto;
import com.miniproject.absenhrweb.dto.response.HrAttendanceResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(
        name = "HrClient",
        url = "${host.rest.api}")
public interface HrClient {

    @GetMapping("/hr/dashboard-summary")
    DashboardSummaryDto getDashboardSummary();

    @GetMapping("/hr/attendance/filter")
    List<HrAttendanceResponseDto> getAttendanceReport(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate);

    @GetMapping("/hr/attendance/all")
    List<HrAttendanceResponseDto> getAllAttendanceReport();
}

