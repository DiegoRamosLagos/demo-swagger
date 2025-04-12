package com.randir.demo_swagger.dto;

import lombok.Builder;

@Builder
public record EmployeeDTO(int id,
        String firstName,
        String lastName) {
}