package com.example.businessapibooking.controller;

import com.example.businessapibooking.entity.Booking;
import com.example.businessapibooking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/booking")
public class BookingController {
    public static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    BookingService service;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        long startTime = System.currentTimeMillis();
        List<Booking> listBooking = new ArrayList<>();
        try {
            listBooking = service.findAll();
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(listBooking, HttpStatus.OK);
    }
    @RequestMapping(value = {"/findByCustomer"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByCustomer() {
        long startTime = System.currentTimeMillis();
        List<Booking> listBooking = new ArrayList<>();
        try {
            listBooking = service.findAll();
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(listBooking, HttpStatus.OK);
    }

}
