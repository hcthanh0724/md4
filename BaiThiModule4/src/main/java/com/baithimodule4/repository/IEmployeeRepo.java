package com.baithimodule4.repository;

import com.baithimodule4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
    Employee findEmployeeById(int id);
}
