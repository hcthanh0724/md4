package com.baithimodule4.service;

import com.baithimodule4.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IEmployeeService {
    List<Employee> getAll();
    Employee add(Employee employee);
    Employee edit(Employee employee);
    void delete(int id);
    Employee findById(int id);
}
