package com.example.restorent_booking_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restorent_booking_app.models.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, Long> {

}
