package com.todo.authapplication.controller;

import com.todo.authapplication.model.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@Slf4j
public class LoginController {
    @GetMapping("/login")
    public String view(Model model, LoginForm form) {
        return "login";
    }

    @GetMapping("/login/error")
    public String getLoginError(Model model, LoginForm form) {
        model.addAttribute("errorMsg", "ユーザー名またはパスワードが違います。");
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model, LoginForm form) {
        return "redirect:/register";
    }
}
