package com.example.service;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeService() { }

    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeDao.create(employee);
    }

    @Transactional
    public Employee getEmployee(int id) {
        return employeeDao.read(id);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }

    @Transactional
    public List<Employee> listEmployee() {
        return employeeDao.findAll();
    }

}
