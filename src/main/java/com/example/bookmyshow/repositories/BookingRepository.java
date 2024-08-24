package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Override
    Booking save(Booking booking);
}
