package com.springCourse.thymeleafdemo.controller;


import com.springCourse.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favLanguages}")
    private List<String> favLanguages;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // create a student object

        Student theStudent = new Student();

        // add a student object to the model

        theModel.addAttribute("student", theStudent);

        // add a country list to the model
        theModel.addAttribute("countries", countries);

        theModel.addAttribute("favLanguages", favLanguages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        return "student-confirmation";
    }
}
