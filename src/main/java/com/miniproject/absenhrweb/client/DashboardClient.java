package com.miniproject.absenhrweb.client;

import com.miniproject.absenhrweb.dto.response.DashboardSummaryDto;
import com.miniproject.absenhrweb.dto.response.HrAttendanceResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(
        name = "dashboardClient",
        url = "${host.rest.api}")
public interface DashboardClient {

    @GetMapping("/hr/dashboard-summary")
    DashboardSummaryDto getDashboardSummary();

}