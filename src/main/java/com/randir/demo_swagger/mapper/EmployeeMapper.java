package com.randir.demo_swagger.mapper;

import org.mapstruct.Mapper;

import com.randir.demo_swagger.dto.EmployeeDTO;
import com.randir.demo_swagger.dto.NewEmployeeDTO;
import com.randir.demo_swagger.entity.Employee;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {
        public EmployeeDTO mapToEmployeeDTO(Employee employee);

        public Employee mapToEmployee(EmployeeDTO employeeDto);

        public Employee mapToEmployee(NewEmployeeDTO employeeDto);
}
