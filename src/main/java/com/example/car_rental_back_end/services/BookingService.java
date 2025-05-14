package com.example.car_rental_back_end.services;

import com.example.car_rental_back_end.models.Booking;
import com.example.car_rental_back_end.models.Car;
import com.example.car_rental_back_end.models.Customer;
import com.example.car_rental_back_end.repositories.BookingRepository;
import com.example.car_rental_back_end.repositories.CarRepository;
import com.example.car_rental_back_end.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

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

    public Booking createBooking(Long customerId, Long carId, String startDate, String endDate) {
        Customer customer = customerRepo.findById(customerId).orElseThrow();
        Car car = carRepo.findById(carId).orElseThrow();
//        Date startDate = new Date();
//        Date endDate = new Date();
        int price = (int) getCarPrice(startDate, endDate, 100);

        boolean bookingStatus = false;

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setCar(car);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setTotalPrice(price);
        booking.setBookingStatus(bookingStatus);
        return bookingRepo.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id).orElseThrow();
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public long getCarPrice(String startDate, String endDate, int dailyRate){
//        String[] startDateSplit = startDate.split("-");
//        String[] endDateSplit = endDate.split("-");
//
//        int yearDifference = Integer.parseInt(endDateSplit[0]) - Integer.parseInt(startDateSplit[0]);
//        int monthDifference = Integer.parseInt(endDateSplit[0]) - Integer.parseInt(startDateSplit[0]);

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        long diffInDays = ChronoUnit.DAYS.between(start, end) + 1;

        return diffInDays * dailyRate;
    }
}
