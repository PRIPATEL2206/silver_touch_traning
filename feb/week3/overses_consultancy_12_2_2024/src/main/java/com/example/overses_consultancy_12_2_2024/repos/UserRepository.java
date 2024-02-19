package com.example.overses_consultancy_12_2_2024.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.overses_consultancy_12_2_2024.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}