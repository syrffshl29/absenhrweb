package com.miniproject.absenhrweb.client;

import com.miniproject.absenhrweb.dto.request.EmployeeRequestDto;
import com.miniproject.absenhrweb.dto.response.EmployeeResponseDto;
import com.miniproject.absenhrweb.dto.response.PageResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "employeeClient",
        url = "${host.rest.api}")
public interface EmployeeClient {

    @GetMapping("/employee")
    List<EmployeeResponseDto> findAll();

    @GetMapping("/employee/{id}")
    EmployeeResponseDto findById(
            @PathVariable("id") Long id);

    @PostMapping("/employee")
    EmployeeResponseDto create(@RequestBody EmployeeRequestDto request);

    @PutMapping("/employee/{id}")
    EmployeeResponseDto update(
            @PathVariable("id") Long id,
            @RequestBody EmployeeRequestDto dto);

    @DeleteMapping("/employee/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping("/employee/search")
    List<EmployeeResponseDto> search(
            @RequestParam("keyword") String keyword);


    @GetMapping("/employee/paging")
    PageResponseDto<EmployeeResponseDto> paging(
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    @GetMapping("/employee/filter")
    List<EmployeeResponseDto> filter(
            @RequestParam(required = false) String employeeCode,
            @RequestParam(required = false) String fullName);

    @GetMapping("/employee/{id}")
    EmployeeResponseDto getById(@PathVariable Long id);

    @GetMapping("/profile")
    EmployeeResponseDto getProfile(
            @RequestHeader("Authorization") String token);

    @PutMapping("/profile")
    EmployeeResponseDto updateProfile(
            @RequestHeader("Authorization") String token,
            @RequestBody EmployeeRequestDto dto);

}