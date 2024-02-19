package com.example.restorent_booking_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products")
@Setter
@Getter
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String productName;
    String productPrice;
    String description;
    String produtImage;
    Long doneByRestorent;

    Long categoryId;
    Long subCategoryId;

}
