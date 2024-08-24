package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    String seatNo;
    int row;
    int col;
    @ManyToOne
    SeatType seatType;
    int price;
}
