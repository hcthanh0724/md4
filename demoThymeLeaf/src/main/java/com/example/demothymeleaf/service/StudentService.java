package com.example.demothymeleaf.service;

import com.example.demothymeleaf.DAO.StudentDAO;
import com.example.demothymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<Student> showHome() {
        return studentDAO.showHome();
    }

    @Override
    public void insertStudent(Student student) {
        studentDAO.insertStudent(student);
    }

    @Override
    public void editStudent(Student student) {
        studentDAO.editStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }
    public Student findById(int id){
        return studentDAO.selectStudent(id);
    }
}
