package com.miniproject.absenhrweb.service;

import com.miniproject.absenhrweb.client.AttendanceTodayClient;
import com.miniproject.absenhrweb.dto.response.AttendanceTodayResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceTodayService {

    private final AttendanceTodayClient attendanceTodayClient;

    public AttendanceTodayService(
            AttendanceTodayClient attendanceTodayClient) {

        this.attendanceTodayClient = attendanceTodayClient;
    }

    public List<AttendanceTodayResponseDto> getTodayAttendances() {

        return attendanceTodayClient.getTodayAttendances();

    }

}