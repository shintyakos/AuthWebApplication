package com.todo.authapplication.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SignUpForm {
    @NotBlank
    @Size(min=3, max=50, message="ユーザー名は3文字以上50文字以下で入力してください。")
    private String username;

    @NotBlank
    @Size(min=8, max=100, message="パスワードは8文字以上100文字以下で入力してください。")
    @ToString.Exclude
    private String password;

    @NotNull
    @Email
    private String email;
}
