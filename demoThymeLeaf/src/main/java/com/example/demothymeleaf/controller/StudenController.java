package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Student;
import com.example.demothymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudenController {
    @Autowired
    StudentService studentService;
    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("student",studentService.showHome());
        return "home";
    }
    @GetMapping("/create")
    public String createStudent(Model model){
        model.addAttribute("student",new Student());
        return "create";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student){
        studentService.insertStudent(student);
        return "redirect:home";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String editStudent(Student student ){
        studentService.editStudent(student);
        return "redirect:/home";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String deleteStudent(Student student){
        studentService.deleteStudent(student.getId());
        return"redirect:/home";
    }
}
