package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.BookingDetail;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookingDetailService {
    BookingDetail findbyId(Integer id);

    BookingDetail save(BookingDetail bookingDetail);

    List<BookingDetail> getAllByStatus(Integer stt);

    List<BookingDetail> findByCustomerAndStatus(Map map);

    List<BookingDetail> findByDateBookingAndStatus(Map map);
}
