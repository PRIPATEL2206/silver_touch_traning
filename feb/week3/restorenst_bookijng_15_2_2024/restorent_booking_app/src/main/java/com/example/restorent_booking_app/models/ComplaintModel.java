package com.example.restorent_booking_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "complaint")
@Setter
@Getter
public class ComplaintModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String subject;
    String description;
    String reply;
    String replyDate;
    String complaintDate;
    String attachment;
    String status;
    Long doneByRestorent;

}
