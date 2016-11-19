package com.example.dao;

import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao implements GenericDao<Employee, Long> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee create(Employee employee) {
        final String sql = "INSERT INTO employee(ID, NAME, AGE) VALUES(?, ?, ?)";
        Object[] objects = {employee.getId(), employee.getName(), employee.getAge()};
        jdbcTemplate.update(sql, objects);
        return employee;
    }

    @Override
    public Employee read(Long id) {
        final String sql = "SELECT * FROM employee WHERE ID = ?";
        Employee employee = jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                new BeanPropertyRowMapper<Employee>(Employee.class));
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        final String sql = "UPDATE employee SET NAME = ?, AGE = ? WHERE ID = ?";
        Object[] args = {employee.getName(), employee.getAge(), employee.getId()};
        jdbcTemplate.update(sql, args);
        return employee;
    }

    @Override
    public void delete(int id) {
        final String sql = "DELETE FROM employee WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

}
