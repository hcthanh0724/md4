package com.codegym.crud.service;

import com.codegym.crud.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        students.add(new Student(1,"Erika",19,"https://static1.cbrimages.com/wordpress/wp-content/uploads/2022/07/erika-annoyed-2.jpg"));
        students.add(new Student(2,"Yuzuriha",19,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2O5mUItiHCiEQNFpHsDVe_nfL26EpZA7W6hGDQw13Mw&s"));
        students.add(new Student(3,"",19,"https://staticg.sportskeeda.com/editor/2023/05/a7e5d-16834510937210-1920.jpg?w=840"));
    }
    public List<Student> getStudents(){
        return students;
    }
    public Student findById(int id){
        for(Student s: students){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public int findIndexById(int id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void editStudent(int id, Student student){
        int index = findIndexById(id);
        students.set(index,student);
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public List<Student> deleteStudent(int id){
        int index =findIndexById(id);
        students.remove(index);
        return students;
    }

}
