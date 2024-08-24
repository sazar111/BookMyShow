package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    Show show;
    @ManyToOne
    Seat seat;
    @Enumerated(EnumType.ORDINAL)
    ShowSeatStatus showSeatStatus;
}
