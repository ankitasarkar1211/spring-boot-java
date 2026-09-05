package org.example.studentmanagement.controller;

import org.example.studentmanagement.model.Student;
import org.example.studentmanagement.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute(
                "students",
                studentService.getAllStudents()
        );

        return "students";
    }

    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute Student student) {

        studentService.addStudent(student);

        return "redirect:/";
    }

    @GetMapping("/students/search")
    public String searchStudent(
            @RequestParam Long id,
            Model model) {

        Student student = studentService
                .getStudentById(id)
                .orElse(null);

        model.addAttribute("student", student);

        return "students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(
            @PathVariable Long id,
            Model model) {

        Student student = studentService
                .getStudentById(id)
                .orElse(null);

        model.addAttribute("editStudent", student);

        return "students";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(
            @PathVariable Long id,
            @ModelAttribute Student student) {

        studentService.updateStudent(id, student);

        return "redirect:/";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return "redirect:/";
    }
}