package com.example.restorent_booking_app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restorent_booking_app.models.SubCategoryModel;

public interface SubCategoryRepo extends JpaRepository<SubCategoryModel, Long> {
    List<SubCategoryModel> findAllByCategoryId(Long categoryId);

}
