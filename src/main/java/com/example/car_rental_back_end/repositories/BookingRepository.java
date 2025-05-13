package com.example.car_rental_back_end.repositories;

import com.example.car_rental_back_end.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {



}
