package com.example.SC.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SC.User;
import com.example.SC.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public boolean save_user_data(User user) {

		user.setPassword(passwordEncoder().encode(user.getPassword()));
		System.out.print(user);
		User user_data = repo.save(user);

		if (user_data.getId() != null) {
			return true;
		}
		return false;
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public void update(Long id) {
	}

	public ArrayList<User> display() {

		ArrayList<User> arr = (ArrayList<User>) repo.findAll();

		return arr;

	}
}
