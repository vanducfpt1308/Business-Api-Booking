package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.BookingDetail;

public interface BookingDetailService {
    BookingDetail findbyId(Integer id);
    BookingDetail save( BookingDetail bookingDetail);

}
