package com.example.car_rental_back_end.services;

import com.example.car_rental_back_end.models.Booking;
import com.example.car_rental_back_end.models.Car;
import com.example.car_rental_back_end.models.Customer;
import com.example.car_rental_back_end.repositories.BookingRepository;
import com.example.car_rental_back_end.repositories.CarRepository;
import com.example.car_rental_back_end.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    public final BookingRepository bookingRepo;
    public final CustomerRepository customerRepo;
    public final CarRepository carRepo;

    public BookingService(BookingRepository bookingRepo, CustomerRepository customerRepo, CarRepository carRepo) {
        this.bookingRepo = bookingRepo;
        this.customerRepo = customerRepo;
        this.carRepo = carRepo;
    }

    public Booking createBooking(String customerId, String carId, String startDate, String endDate) {
      Long customerIdLong = Long.parseLong(customerId);
      Long carIdLong = Long.parseLong(carId);

        Customer customer = customerRepo.findById(customerIdLong).orElseThrow();
        Car car = carRepo.findById(carIdLong).orElseThrow();
        int price = (int) getCarPrice(startDate, endDate, car.getDailyRate());

        boolean bookingStatus = true;

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setCar(car);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setTotalPrice(price);
        booking.setBookingStatus(bookingStatus);
        car.setAvailability(false);
        customer.setBookingStatus(true);
        return bookingRepo.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id).orElseThrow();
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public long getCarPrice(String startDate, String endDate, int dailyRate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        long diffInDays = ChronoUnit.DAYS.between(start, end) + 1;

        return diffInDays * dailyRate;
    }

    //    DELETE
    public void deleteBooking(Long id){
        bookingRepo.deleteById(id);
    }

    //      PATCH
    public Booking patchBooking(Long id){
        Booking booking = bookingRepo.findById(id).orElseThrow();
        Car car = carRepo.findById(booking.getCar().getId()).orElseThrow();
        Customer customer = customerRepo.findById(booking.getCustomer().getId()).orElseThrow();
        customer.setBookingStatus(false);
        car.setAvailability(true);
        booking.setBookingStatus(false);
        return  bookingRepo.save(booking);
    }

}
