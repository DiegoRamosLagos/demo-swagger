package com.randir.demo_swagger.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.randir.demo_swagger.dto.LoginUserDto;
import com.randir.demo_swagger.dto.RegisterUserDto;
import com.randir.demo_swagger.entity.User;
import com.randir.demo_swagger.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public User signup(RegisterUserDto input) {
        User user = User.builder()
                .fullName(input.fullName())
                .email(input.email())
                .password(passwordEncoder.encode(input.password()))
                .build();

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.email(), input.password()));

        return userRepository.findByEmail(input.email()).orElseThrow();

    }

}
