package com.randir.demo_swagger.dto;

import lombok.Builder;

@Builder
public record NewEmployeeDTO(String firstName,
        String lastName) {
}