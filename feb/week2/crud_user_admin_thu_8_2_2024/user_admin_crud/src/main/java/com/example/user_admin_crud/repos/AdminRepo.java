package com.example.user_admin_crud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_admin_crud.models.AdminModel;

public interface AdminRepo extends JpaRepository<AdminModel, Integer> {

}
