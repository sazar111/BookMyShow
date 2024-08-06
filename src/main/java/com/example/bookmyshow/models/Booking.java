package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    User user;
    Show show;
    List<ShowSeat> seats;
    List<Payment> payments;
    int total;
}
