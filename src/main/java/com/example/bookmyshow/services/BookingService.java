package com.example.bookmyshow.services;

import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.BookingRepository;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    UserRepository userRepository;
    ShowSeatRepository showSeatRepository;
    ShowRepository showRepository;
    BookingRepository bookingRepository;
    PriceCalculationService priceCalculationService;

    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository,
                          ShowRepository showRepository, PriceCalculationService priceCalculationService) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculationService = priceCalculationService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, Long showId, List<Long> showSeatIds ){
        Optional<User> optionalUser= userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User not found");
        }
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new RuntimeException("Show not found");
        }

        List<ShowSeat> showSeats= showSeatRepository.findAllById(showSeatIds);

        if(showSeats.isEmpty()){
            throw new RuntimeException("ShowSeats not found");
        }
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("ShowSeat not available");
            }
        }
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }
        User user = optionalUser.get();
        Show show = optionalShow.get();
        int price= priceCalculationService.calculatePrice(showSeats);

        Booking booking= new Booking();
        booking.setUser(user);
        booking.setSeats(showSeats);
        booking.setTotal(price);
        booking.setStatus(BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }
}
