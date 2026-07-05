package com.miniproject.absenhrweb.client;

import com.miniproject.absenhrweb.dto.request.CheckInRequestDto;
import com.miniproject.absenhrweb.dto.response.AttendanceResponseDto;
import com.miniproject.absenhrweb.dto.response.DashboardEmployeeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "attendanceClient",
        url = "${host.rest.api}"
)
public interface AttendanceClient {

    @GetMapping("/attendance/history")
    List<AttendanceResponseDto> getHistory();

    @PostMapping("/attendance/checkin")
    String checkIn(@RequestBody CheckInRequestDto request);

    @PostMapping("/attendance/checkout")
    String checkOut();

    @GetMapping("/attendance/dashboard")
    DashboardEmployeeResponseDto getDashboard();

}