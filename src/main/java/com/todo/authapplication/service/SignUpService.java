package com.todo.authapplication.service;

import com.todo.authapplication.entity.User;
import com.todo.authapplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(String userName, String password, String email) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password));
        user.setMailAddress(email);
        userRepository.save(user);
    }

    public boolean isExistUser(String userName) {
        User user = userRepository.findByUserName(userName);
        return user != null;
    }
}
