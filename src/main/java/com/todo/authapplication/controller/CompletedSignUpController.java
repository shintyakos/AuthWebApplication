package com.todo.authapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompletedSignUpController {
    @GetMapping("/completed")
    public String view() {
        return "completed";
    }
}
