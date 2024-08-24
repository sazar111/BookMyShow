package com.example.bookmyshow.services;

import com.example.bookmyshow.models.SeatType;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class PriceCalculationService {
    ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> seats) {
        int price = 0;
        List<ShowSeatType> showSeatTypes= showSeatTypeRepository.findAllByShow(seats.get(0).getShow());

        for (ShowSeat seat : seats) {
            for(ShowSeatType showSeatType: showSeatTypes) {
                if(showSeatType.getShow().equals(seat.getShow())) {
                    price+=showSeatType.getPrice();
                    break;
                }
            }
        }
        return price;
    }
}
