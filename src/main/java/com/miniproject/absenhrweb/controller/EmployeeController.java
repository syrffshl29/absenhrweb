package com.miniproject.absenhrweb.controller;

import com.miniproject.absenhrweb.dto.request.EmployeeRequestDto;
import com.miniproject.absenhrweb.dto.response.EmployeeResponseDto;
import com.miniproject.absenhrweb.dto.response.PageResponseDto;
import com.miniproject.absenhrweb.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<EmployeeResponseDto> employees =
                employeeService.findAll();

        model.addAttribute("employees", employees);

        return "admin/employees";
    }
    @GetMapping
    public String list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String employeeCode,
            @RequestParam(required = false) String fullName,
            Model model) {

        if (keyword != null && !keyword.isBlank()) {

            model.addAttribute(
                    "employees",
                    employeeService.search(keyword));

            return "admin/employees";
        }

        if ((employeeCode != null && !employeeCode.isBlank())
                || (fullName != null && !fullName.isBlank())) {

            model.addAttribute(
                    "employees",
                    employeeService.filter(employeeCode, fullName));

            return "admin/employees";
        }

        PageResponseDto<EmployeeResponseDto> employeePage =
                employeeService.paging(page, size);

        model.addAttribute("employeePage", employeePage);
        model.addAttribute("employees", employeePage.getContent());

        return "admin/employees";
    }
    @GetMapping("/create")
    public String createForm(Model model) {

        model.addAttribute(
                "employee",
                new EmployeeRequestDto());

        return "admin/create";
    }
    @PostMapping("/create")
    public String create(
            @Valid
            @ModelAttribute("employee") EmployeeRequestDto employee,
            BindingResult result) {

        if (result.hasErrors()) {
            return "admin/create";
        }

        employeeService.create(employee);

        return "redirect:/employees";
    }
    @GetMapping("/edit/{id}")
    public String editForm(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "employee",
                employeeService.findById(id));

        return "admin/edit";
    }
    @PostMapping("/edit/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute EmployeeRequestDto dto) {

        employeeService.update(id, dto);

        return "redirect:/employees";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        employeeService.delete(id);

        return "redirect:/employees";
    }
    @GetMapping("/search")
    public String search(
            @RequestParam String keyword,
            Model model) {

        model.addAttribute(
                "employees",
                employeeService.search(keyword));

        return "admin/employees";
    }
    @GetMapping("/filter")
    public String filter(
            @RequestParam(required = false) String employeeCode,
            @RequestParam(required = false) String fullName,
            Model model) {

        model.addAttribute(
                "employees",
                employeeService.filter(
                        employeeCode,
                        fullName));

        return "admin/employees";
    }
}