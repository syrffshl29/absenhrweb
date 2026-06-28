package com.miniproject.absenhrweb.client;

import com.miniproject.absenhrweb.dto.response.AttendanceTodayResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(
        name = "attendanceTodayClient",
        url = "${host.rest.api}"
        )
public interface AttendanceTodayClient {
    @GetMapping("/hr/attendance/today")
    List<AttendanceTodayResponseDto> getTodayAttendances();
}
