# Car Rental Back End

The back end aspect of a web application designed for managing a car rental service. A RESTful API built with Java and Spring Boot to support the front end aspect of the web application. It manages the customer data, the car inventory, and the car rental bookings.

## Table of Contents

- Host
- Installation
- Features
- API Endpoints
- Technologies
- Link
- Authors

## Host

- https://ash-digit.github.io/car_rental_fe/

## Installation

- git clone https://github.com/ash-digit/car_rental_be

## Features

- CRUD operations for managing the car rental service:

    - Customers
    - Cars
    - Bookings

- The total car rental price is calculated using the start date and end date inclusively, and multiplied by the daily rate of the car.

- RESTful API with clear endpoints.

- Separation of concerns using Spring Boot controller, service and repository layers.

- The Entity Relationship Diagram, illustrates the one-to-many relationships between the customers and the bookings, and the cars and the bookings.

    - Customers can have many bookings.
    - Cars can have many bookings.
    - Bookings only have one customer and one car.

## API Endpoints

- Customers

    - Create a customer: POST ("/api/customers")
    - Read all customers: GET ("/api/customers")
    - Read customer by ID: GET ("/api/customers/{id}")
    - Delete customer by ID: DELETE ("/api/customers/{id}")

- Cars

    - Create a car: POST ("/api/cars")
    - Read all cars: GET ("/api/cars/)
    - Read car by ID: GET ("/api/cars/{id}")
    - Delete car by ID: DELETE ("/api/cars/{id}")

- Bookings

    - Create a booking: POST ("/api/bookings")
    - Read all bookings: GET ("/api/bookings")
    - Read booking by ID: GET ("/api/bookings/{id}")
    - Update a booking by ID: PATCH ("/api/bookings/{id}")
    - Delete booking by ID: DELETE ("/api/bookings/{id}")

## Technologies

- Java
- Spring Boot
- MySQL

## Link

Car Rental Front End repository: https://github.com/ash-digit/car_rental_fe

## Authors

- Edward Pau: https://github.com/edpau
- Ashkan Alikhanzadeh: https://github.com/ash-digit
- Nicole Samuels: https://github.com/nma-s
- Indigo Moorcroft: https://github.com/indymoorcroft
- Jonny Ellis: https://github.com/jonnyell89
