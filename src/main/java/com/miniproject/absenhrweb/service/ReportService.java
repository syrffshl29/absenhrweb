package com.miniproject.absenhrweb.service;

import com.miniproject.absenhrweb.client.DashboardClient;
import com.miniproject.absenhrweb.client.HrClient;
import com.miniproject.absenhrweb.dto.response.DashboardSummaryDto;
import com.miniproject.absenhrweb.dto.response.HrAttendanceResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    private final HrClient hrClient;

    public ReportService(HrClient hrClient) {
        this.hrClient = hrClient;

    }
    public DashboardSummaryDto getDashboardSummary() {
        return hrClient.getDashboardSummary();
    }
    public List<HrAttendanceResponseDto> getAttendanceReport(
            LocalDate startDate,
            LocalDate endDate) {

        return hrClient.getAttendanceReport(
                startDate.toString(),
                endDate.toString());
    }
    public List<HrAttendanceResponseDto> getAllAttendanceReport() {
        return hrClient.getAllAttendanceReport();
    }
}
