package com.example.restorent_booking_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restorent_booking_app.models.ComplaintModel;

public interface ComplaintRepo extends JpaRepository<ComplaintModel, Long> {

}
