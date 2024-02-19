package com.example.restorent_booking_app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restorent_booking_app.models.AreaModel;

public interface AreaRepo extends JpaRepository<AreaModel, Long> {
    List<AreaModel> findAllByCityId(Long cityId);

}
