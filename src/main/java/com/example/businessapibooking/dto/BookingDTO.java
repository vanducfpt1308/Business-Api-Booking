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
public class BookingDTO {
    private Customer customer;
    private Staff staff;
    private ServiceCustomer serviceCustomer;

    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    private Date dateBooking;
    private Date timeEnd;
    private Date timeStart;
    private String note;
}
