package com.todo.authapplication.controller;

import com.todo.authapplication.model.SignUpForm;
import com.todo.authapplication.service.SignUpService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class SignUpController {
    private final SignUpService signUpService;

    @GetMapping("/register")
    public String view(SignUpForm signUpForm) {
        return "signup";
    }

    @PostMapping("/register")
    public String register(@Validated SignUpForm signUpForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";
        }

        if (signUpService.isExistUser(signUpForm.getUsername())) {
            model.addAttribute("signupError", "ユーザー名が既に存在します。");
            return "signup";
        }

        try {
            signUpService.register(signUpForm.getUsername(), signUpForm.getPassword(), signUpForm.getEmail());
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("signupError", "登録に失敗しました。");
            return "signup";
        }

        return "redirect:/completed";
    }
}
