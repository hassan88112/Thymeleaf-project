package com.example.thymeleaf.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/v1")
public class CustomerController {


    @GetMapping("/test")
    public String Home(Model model){

        model.addAttribute("date" , new java.util.Date());

        return "index";
    }

}
