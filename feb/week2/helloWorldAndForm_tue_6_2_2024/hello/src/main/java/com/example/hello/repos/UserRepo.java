package com.example.hello.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hello.models.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
