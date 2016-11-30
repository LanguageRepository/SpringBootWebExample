package com.example.controller;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/get/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee index(@PathVariable(value = "employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/upd",method = RequestMethod.PUT)
    public void updateDepartment(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAll() {
        return employeeService.listEmployee();
    }

}
