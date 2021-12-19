package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.BookingDetail;

import java.util.List;

public interface BookingDetailService {
    BookingDetail findbyId(Integer id);
    BookingDetail save(BookingDetail bookingDetail);
    List<BookingDetail> getAllByStatus(Integer stt);

}
