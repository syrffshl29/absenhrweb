package com.miniproject.absenhrweb.service;

import com.miniproject.absenhrweb.client.DashboardClient;
import com.miniproject.absenhrweb.dto.response.DashboardSummaryDto;
import com.miniproject.absenhrweb.dto.response.HrAttendanceResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {

    private final DashboardClient dashboardClient;

    public DashboardService(DashboardClient dashboardClient) {
        this.dashboardClient = dashboardClient;
    }

    public DashboardSummaryDto getDashboardSummary() {
        return dashboardClient.getDashboardSummary();
    }

}