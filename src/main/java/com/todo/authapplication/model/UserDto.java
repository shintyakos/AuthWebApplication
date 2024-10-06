package com.todo.authapplication.model;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
