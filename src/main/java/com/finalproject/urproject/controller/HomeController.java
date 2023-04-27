package com.finalproject.urproject.controller;

import com.finalproject.urproject.repository.DepartmentRepository;
import com.finalproject.urproject.repository.EmployeeRepository;
import com.finalproject.urproject.service.DepartmentService;
import com.finalproject.urproject.service.EmployeeService;
import com.finalproject.urproject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LeaveService leaveService;


    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping(path = {"/dashboard"})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String listAllEmployee(Model model) {
        model.addAttribute("activePage", "dashboard");
        return "dashboard";
    }

    @GetMapping("/barChart")
    public String getEmployee(Model model) {

        List<String> nameList = leaveService.findAllLeave().stream().map(x -> x.getEducationLevel()).collect(Collectors.toList());
        List<Long> ageList = leaveService.findAllLeave().stream().map(x -> x.getId()).collect(Collectors.toList());
        model.addAttribute("name", nameList);
        model.addAttribute("age", ageList);
        return "dashboard";
    }

    @GetMapping("/profile")
    public String userProfile() {
        return "profile";
    }

}