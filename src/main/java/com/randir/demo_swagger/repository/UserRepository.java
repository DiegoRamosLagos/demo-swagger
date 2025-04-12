package com.randir.demo_swagger.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.randir.demo_swagger.entity.User;

public interface UserRepository extends CrudRepository {
    Optional<User> findByEmail(String email);

}
