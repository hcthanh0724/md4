package com.codegym.crud.controller;

import com.codegym.crud.model.Student;
import com.codegym.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    public String showStudent(Model model){
        //attributeName là tên đối tượng sẽ được lặp lại bên trang jsp (trong phần ${})
        model.addAttribute("students",studentService.getStudents());
        return "showStudent";
    }
    @GetMapping("/editStudent")
    //phương thức get nhận req từ client, trả ra trang form edit
    //lấy para từ thẻ input có name "id" bên jsp
    //Sau khi lấy được id từ request, đi vào phương thức fineById,
    //phương thức trả về đối tượng student và chuyển sang trang editStudent
    public String showEditStudent(@RequestParam int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "editStudent";
    }
    @PostMapping("/editStudent")
    //phương thức getID ở đây lấy id của sinh viên ở trên phương thức get
    //Annotation @ModelAttribute sẽ tạo đối tượng student mới, truyền tham số
    //được lấy từ form, so sánh và khớp nó với model student

    public String showEditStudent(@ModelAttribute Student student){
        studentService.editStudent(student.getId(),student);
        return "redirect:/students";
    }
    @GetMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/DeleteStudent")
    public String deleteStudent(@RequestParam int id,Model model){
        model.addAttribute("students",studentService.deleteStudent(id));
        return "showStudent";
    }
}
