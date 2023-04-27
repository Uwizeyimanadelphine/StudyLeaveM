package com.finalproject.urproject.controller;

import com.finalproject.urproject.entity.Department;
import com.finalproject.urproject.entity.Employee;
import com.finalproject.urproject.repository.DepartmentRepository;
import com.finalproject.urproject.repository.EmployeeRepository;
import com.finalproject.urproject.service.DepartmentService;
import com.finalproject.urproject.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository repository;

    @GetMapping("/new_employee")
    public String showNewMark(Model model) {
        List<Department> departmentList = repository.findAll();
        model.addAttribute("employee", new Employee());
        model.addAttribute("departmentList", departmentList);

        return "new_employee";
    }

    @RequestMapping(path = {"/employeelist"})
    public String listAllDepartment(Model model) {
        List<Employee> employeeList = employeeService.findAllEmployee();
        model.addAttribute("employees", employeeList);
        return "employeelist";
    }

    @PostMapping("/save")
    public String saveEmployee(Model model, Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/new_employee?success";
    }

    @RequestMapping(path = {"/search"})
    public String searchEmployee(Model model, @Param("keyword") String keyword) {
        List<Employee> employeeList = employeeService.listAll(keyword);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("keyword", keyword);

        return "employeelist";
    }

    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable(name = "id") Long id, Model model) {
        List<Department> departmentList = repository.findAll();
        model.addAttribute("departmentList", departmentList);
        Employee employee = repo.findById(id).get();
        model.addAttribute("employee", employee);
        return "profile";
    }

    @GetMapping("/add_leave/{id}")
    public String addLeave(@PathVariable(name = "id") Long id, Model model) {
        Employee employee = repo.findById(id).get();
        model.addAttribute("employee", employee);
        return "redirect:/leave/new_leave";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id, Model model) {
        employeeService.delete(id);
        return "redirect:/employee/employeelist";
    }

    @GetMapping("/profile")
    public String userProfile() {
        return "profile";
    }

    @GetMapping("/emp_leave")
    public String empLeave() {
        return "emp_leave";
    }

    @PostMapping("/update")
    public String editEmployee(Model model, Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/employeelist";
    }

}
