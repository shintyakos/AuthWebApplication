package com.todo.authapplication.model;

import com.todo.authapplication.util.PasswordMatches;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString(exclude = {"password", "confirmPassword"})
@EqualsAndHashCode
@PasswordMatches
public class UserDto {
    @NotNull
    @Size(min=3, max=50)
    private String username;

    @NotNull
    @Size(min=8, max=100)
    @ToString.Exclude
    private String password;

    @NotNull
    @Size(min=8, max=100)
    @ToString.Exclude
    private String confirmPassword;

    @NotNull
    @Email
    private String email;
}
