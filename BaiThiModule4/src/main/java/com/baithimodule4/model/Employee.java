package com.baithimodule4.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employeeCode;
    private String name;
    private int age;
    private double salary;
    @ManyToOne
    private Department department;
}
