package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    @ManyToOne
    User user;

    @ManyToMany
    List<ShowSeat> seats;

    @OneToMany
    List<Payment> payments;
    int total;
    @Enumerated(EnumType.ORDINAL)
    BookingStatus status;
}
