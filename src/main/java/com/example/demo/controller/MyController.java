package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan({ "com.exmaple" })
public class MyController {

    @GetMapping("/")
    public String page(HttpServletRequest request, final Model model) {
        model.addAttribute("pageName", "main");
        return "page";
    }

}
