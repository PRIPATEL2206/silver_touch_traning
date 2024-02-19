package com.example.user_admin_crud.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_admin_crud.models.EmployeeModel;

public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer> {
    Optional<EmployeeModel> findByUserName(String userName);
}
