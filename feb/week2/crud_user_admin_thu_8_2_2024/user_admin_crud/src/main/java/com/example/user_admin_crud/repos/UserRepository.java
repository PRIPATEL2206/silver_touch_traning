package com.example.user_admin_crud.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_admin_crud.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}