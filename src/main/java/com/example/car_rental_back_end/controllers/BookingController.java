package com.example.car_rental_back_end.controllers;

import com.example.car_rental_back_end.models.Booking;
import com.example.car_rental_back_end.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    public final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestParam Long customerId, @RequestParam Long carId, @RequestParam String startDate, @RequestParam String endDate) {
        return bookingService.createBooking(customerId, carId, startDate, endDate);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return this.bookingService.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
