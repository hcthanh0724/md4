package com.baithimodule4.service;

import com.baithimodule4.model.Employee;
import com.baithimodule4.repository.IEmployeeRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    @Override
    public List<Employee> getAll() {
        return iEmployeeRepo.findAll();
    }

    @Override
    public Employee add(Employee employee) {
        return iEmployeeRepo.save(employee);
    }

    @Override
    public Employee edit(Employee employee) {
        return iEmployeeRepo.save(employee);
    }

    @Override
    public void delete(int id) {
        iEmployeeRepo.deleteById(id);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepo.findEmployeeById(id);
    }
}
