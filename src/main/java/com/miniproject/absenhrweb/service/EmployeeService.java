package com.miniproject.absenhrweb.service;

import com.miniproject.absenhrweb.client.EmployeeClient;
import com.miniproject.absenhrweb.dto.request.EmployeeRequestDto;
import com.miniproject.absenhrweb.dto.response.EmployeeResponseDto;
import com.miniproject.absenhrweb.dto.response.PageResponseDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeClient employeeClient;

    public EmployeeService(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public List<EmployeeResponseDto> findAll() {
        return employeeClient.findAll();
    }
    public List<EmployeeResponseDto> search(String keyword) {
        return employeeClient.search(keyword);
    }

    public List<EmployeeResponseDto> filter(
            String employeeCode,
            String fullName) {

        return employeeClient.filter(
                employeeCode,
                fullName);
    }
    public EmployeeResponseDto create(EmployeeRequestDto dto) {
        return employeeClient.create(dto);
    }
    public EmployeeResponseDto findById(Long id) {
        return employeeClient.findById(id);
    }

    public EmployeeResponseDto update(Long id, EmployeeRequestDto dto) {
        return employeeClient.update(id, dto);
    }
    public void delete(Long id) {

        employeeClient.delete(id);
    }
    public PageResponseDto<EmployeeResponseDto> paging(
            int page,
            int size){

        return employeeClient.paging(page,size);
    }
    public EmployeeResponseDto getProfile(HttpSession session) {

        String token = "Bearer " + session.getAttribute("TOKEN");

        return employeeClient.getProfile(token);
    }
    public EmployeeResponseDto updateProfile(
            HttpSession session,
            EmployeeRequestDto dto) {

        String token = "Bearer " + session.getAttribute("TOKEN");

        return employeeClient.updateProfile(token, dto);
    }
}

