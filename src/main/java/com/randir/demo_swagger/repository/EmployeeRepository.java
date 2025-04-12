package com.randir.demo_swagger.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.randir.demo_swagger.entity.Employee;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {

}
