package com.springCourse.thymeleafdemo.controller;


import com.springCourse.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {


    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // create a student object

        Student theStudent = new Student();

        // add a student object to the model

        theModel.addAttribute("student", theStudent);

        return "student-form";
    }
}
