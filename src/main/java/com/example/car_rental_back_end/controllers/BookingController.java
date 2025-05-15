package com.example.car_rental_back_end.controllers;

import com.example.car_rental_back_end.dtos.BookingRequest;
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
    public Booking createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest.getCustomerId(), bookingRequest.getCarId(), bookingRequest.getStartDate(), bookingRequest.getEndDate());
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return this.bookingService.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    //     DELETE
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return String.format("Car with id %d has been deleted", id);
    }
    @PatchMapping("/{id}")
    public  Booking patchBooking(@PathVariable Long id){
        return bookingService.patchBooking(id);
    }


}
