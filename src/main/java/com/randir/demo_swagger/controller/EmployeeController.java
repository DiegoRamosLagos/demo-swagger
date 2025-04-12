package com.randir.demo_swagger.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.randir.demo_swagger.dto.EmployeeDTO;
import com.randir.demo_swagger.dto.NewEmployeeDTO;
import com.randir.demo_swagger.entity.Employee;
import com.randir.demo_swagger.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @Tag(name = "get", description = "GET methods of Employee APIs")
    @GetMapping("/employees")
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAll();
    }

    @Tag(name = "get", description = "Retrieve one employee")
    @GetMapping("/employees/{employeeId}")
    public EmployeeDTO getEmployee(
            @Parameter(description = "ID of employee to be retrieved", required = true) @PathVariable int employeeId) {

        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public EmployeeDTO addEmployee(@RequestBody NewEmployeeDTO employee) {
        return employeeService.save(employee);
    }

    @Operation(summary = "Update an employee", description = "Update an existing employee. The response is updated Employee object with id, first name, and last name.")
    @PutMapping("/employees")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.update(employee);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = @Content) })
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
        return "Deleted employee with id: " + employeeId;
    }

}
