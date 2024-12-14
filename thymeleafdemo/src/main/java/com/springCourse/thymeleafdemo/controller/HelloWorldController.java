package com.springCourse.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld-process";
    }

    // need a controller method to read form data and add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        // convert that data to uppercase and create message
        String msg = "Yo " + theName.toUpperCase();
        // add message to the model
        model.addAttribute("message", msg);

        return "helloworld-process";
    }

    // need a controller method to read form data and add data to the model using @Requestparam binding
    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String theName, Model model) {

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String msg = "Hey, my friend V3!" + theName;

        //add message to the model
        model.addAttribute("message", msg);

        return "helloworld-process";
    }
}
