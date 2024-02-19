package com.example.restorent_booking_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restorent_booking_app.models.CategoryModel;

public interface CategoryRepo extends JpaRepository<CategoryModel, Long> {

}
