package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    Long userId;
    Long showId;
    List<Long> showSeatIds;
}
