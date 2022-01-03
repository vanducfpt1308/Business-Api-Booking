package com.example.businessapibooking.dto;

import com.example.businessapibooking.config.Constants;
import com.example.businessapibooking.entity.Customer;
import com.example.businessapibooking.entity.ServiceCustomer;
import com.example.businessapibooking.entity.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private Customer customer;
    private Staff staff;
    private ServiceCustomer serviceCustomer;
    private String dateBooking;
    private String timeEnd;
    private String timeStart;
    private String note;
}
