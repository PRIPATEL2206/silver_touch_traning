package com.example.restorent_booking_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restorent_booking_app.models.AreaModel;
import com.example.restorent_booking_app.repos.AreaRepo;

@Service
public class CityServices {
    @Autowired
    AreaRepo areaRepo;

    public List<AreaModel> getAreaOFCity(Long cityId) {
        return areaRepo.findAllByCityId(cityId);
    }
}
