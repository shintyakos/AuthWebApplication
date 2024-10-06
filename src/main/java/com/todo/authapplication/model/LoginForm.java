package com.todo.authapplication.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {
    @NotBlank(message="ユーザー名は必須です")
    private String username;
    @NotBlank(message="パスワードは必須です")
    private String password;
}
