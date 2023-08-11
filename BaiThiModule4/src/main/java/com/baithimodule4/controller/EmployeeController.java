package com.baithimodule4.controller;

import com.baithimodule4.model.Employee;
import com.baithimodule4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employeeList = iEmployeeService.getAll();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
        return new ResponseEntity<>(iEmployeeService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(iEmployeeService.add(employee),HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<>(iEmployeeService.add(employee),HttpStatus.OK);
    }
    @PostMapping ("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable int id){
        iEmployeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
