package com.example.demothymeleaf.service;

import com.example.demothymeleaf.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> showHome();
    public void insertStudent(Student student);
    public void editStudent(Student student);
    public void deleteStudent(int id);
}
