package com.finalproject.urproject.controller;

import com.finalproject.urproject.entity.Employee;
import com.finalproject.urproject.entity.Leave;
import com.finalproject.urproject.repository.EmployeeRepository;
import com.finalproject.urproject.repository.LeaveRepository;
import com.finalproject.urproject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    List<Leave> leaveLi = new ArrayList<>();
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private LeaveRepository repository;
    @Autowired
    private EmployeeRepository repo;

    @RequestMapping(path = {"/leaves"})
    public String listAllLeaves(Map<String, Object> models, Model model) {
        List<Leave> leaveList = leaveService.findAllLeave();

        model.addAttribute("leaveList", leaveList);

        return "leaves";
    }

    @GetMapping("/new_leave")
    public String addEmployeeLeave(Model model) {

        List<Employee> employeeList = repo.findAll();
        model.addAttribute("leave", new Leave());
        model.addAttribute("employeeList", employeeList);
        return "new_leave";
    }

    @PostMapping("/new_leave")
    public String saveEmployeeLeave(Leave leave) {
        repository.save(leave);
        return "redirect:/leave/new_leave?success";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeLeave(@PathVariable(name = "id") Long id, Model model) {

        Leave leave = repository.findById(id).get();
        model.addAttribute("leave", leave);
        return "new_leave";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeLeave(@PathVariable(name = "id") Long id, Model model) {
        leaveService.delete(id);
        return "redirect:/leave/leaves";
    }

    @GetMapping("/datediff")
    public String calculateDays() {
        //leaveService.delete(id);
        return "action.js";
    }

}
