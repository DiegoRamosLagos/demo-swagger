package com.randir.demo_swagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.randir.demo_swagger.dto.EmployeeDTO;
import com.randir.demo_swagger.dto.NewEmployeeDTO;
import com.randir.demo_swagger.entity.Employee;
import com.randir.demo_swagger.exception.NotFoundException;
import com.randir.demo_swagger.mapper.EmployeeMapper;
import com.randir.demo_swagger.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = employeeMapper;
    }

    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(mapper::mapToEmployeeDTO)
                .toList();
    }

    public EmployeeDTO findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new NotFoundException("Employee not found with id: " + id);
        }
        return mapper.mapToEmployeeDTO(employee.get());
    }

    public EmployeeDTO save(NewEmployeeDTO employeeDto) {
        Employee employee = mapper.mapToEmployee(employeeDto);
        return mapper.mapToEmployeeDTO(employeeRepository.save(employee));
    }

    public EmployeeDTO update(EmployeeDTO employeeDto) {
        Employee employee = mapper.mapToEmployee(employeeDto);
        return mapper.mapToEmployeeDTO(employeeRepository.save(employee));
    }

    public void deleteById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new NotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
