package com.example.bookmyshow.controllers;



import com.example.bookmyshow.dtos.CreateBookingRequestDto;
import com.example.bookmyshow.dtos.CreateBookingResponseDto;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;
import java.util.*;


@Controller
public class BookingController {
    BookingService bookingService;

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto createBookingRequestDto) {
        CreateBookingResponseDto createBookingResponseDto = new CreateBookingResponseDto();
        try{
            Booking booking=bookingService.createBooking(
                    createBookingRequestDto.getUserId(),
                    createBookingRequestDto.getShowId(),
                    createBookingRequestDto.getShowSeatIds()
            );
            createBookingResponseDto.setBooking(booking);
            createBookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            createBookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return createBookingResponseDto;
    }
}
