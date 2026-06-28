package com.miniproject.absenhrweb.service;

import com.miniproject.absenhrweb.client.AttendanceClient;
import com.miniproject.absenhrweb.dto.request.CheckInRequestDto;
import com.miniproject.absenhrweb.dto.response.AttendanceResponseDto;
import com.miniproject.absenhrweb.dto.response.DashboardEmployeeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceClient attendanceClient;

    public AttendanceService(
            AttendanceClient attendanceClient) {

        this.attendanceClient = attendanceClient;
    }

    public List<AttendanceResponseDto> getHistory() {

        return attendanceClient.getHistory();

    }
    public void checkIn(String location) {

        CheckInRequestDto request = new CheckInRequestDto();
        request.setLocation(location);

        attendanceClient.checkIn(request);
    }
    public void checkOut() {

        attendanceClient.checkOut();
    }
    public DashboardEmployeeResponseDto getDashboard() {

        return attendanceClient.getDashboard();

    }
}