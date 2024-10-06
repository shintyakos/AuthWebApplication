package com.todo.authapplication.service;

import com.todo.authapplication.entity.User;
import com.todo.authapplication.model.UserDetail;
import com.todo.authapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user != null) {
            log.info("username: {}, password: {}", user.getUserName(), user.getPassword());
            return new UserDetail(user);
        } else {
            throw new UsernameNotFoundException("User not found for name: " + username);
        }

    }
}
