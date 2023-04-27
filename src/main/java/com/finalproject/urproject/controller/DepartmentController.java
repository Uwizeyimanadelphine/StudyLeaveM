package com.finalproject.urproject.controller;

import com.finalproject.urproject.entity.Department;
import com.finalproject.urproject.repository.DepartmentRepository;
import com.finalproject.urproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository repository;

    @RequestMapping(path = {"/departments"})
    public String listAllDepartment(Model model) {
        List<Department> departmentList = departmentService.findAllDepartment();
        model.addAttribute("departmentList", departmentList);
        return "departments";
    }

    @GetMapping("/new_dep")
    public String addDepartment(Model model) {

        model.addAttribute("department", new Department());
        return "new_dep";
    }

    @PostMapping("/save_dep")
    public String saveDepartment(Department department) {
        departmentService.save(department);
        return "redirect:/department/new_dep?success";
    }

    @RequestMapping(path = {"/search"})
    public String searchEmployee(Model model, @Param("keyword") String keyword) {
        List<Department> departmentList = departmentService.listAll(keyword);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("keyword", keyword);

        return "employeelist";
    }

    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable(name = "id") Long id, Model model) {

        Department department = repository.findById(id).get();
        model.addAttribute("department", department);
        return "new_dep";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable(name = "id") Long id, Model model) {
        departmentService.delete(id);
        return "redirect:/department/departments";
    }
}
