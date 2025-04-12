package com.randir.demo_swagger.dto;

public record RegisterUserDto(
        String email,
        String password,
        String fullName) {

}
