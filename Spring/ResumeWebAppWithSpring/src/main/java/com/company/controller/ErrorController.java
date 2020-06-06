package com.company.controller;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 20/05/2020
 * Time: 15:45
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String page(@ModelAttribute("msg") Exception ex , Model model) {
        model.addAttribute("msg",ex.getMessage());
        return "error";
    }
}