package com.example.demothymeleaf.DAO;

import com.example.demothymeleaf.model.Student;

import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student student);
    public List<Student> showHome();
    public Student selectStudent(int id);
    public boolean editStudent(Student student);
    public boolean delete(int id);
    public List<Student> search(String name);
}
