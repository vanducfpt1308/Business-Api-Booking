package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.dto.StatisticalDTO;
import com.example.businessapibooking.repository.BookingDetailRepo;
import com.example.businessapibooking.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticalServiceImpl implements StatisticalService {
    @Autowired
    BookingDetailRepo bookingDetailRepo;


    @Override
    public StatisticalDTO countBooking() {
        StatisticalDTO dto = new StatisticalDTO();
        dto.setThang1(bookingDetailRepo.countBookingMonth(1));
        dto.setThang2(bookingDetailRepo.countBookingMonth(2));
        dto.setThang3(bookingDetailRepo.countBookingMonth(3));
        dto.setThang4(bookingDetailRepo.countBookingMonth(4));
        dto.setThang5(bookingDetailRepo.countBookingMonth(5));
        dto.setThang6(bookingDetailRepo.countBookingMonth(6));
        dto.setThang7(bookingDetailRepo.countBookingMonth(7));
        dto.setThang8(bookingDetailRepo.countBookingMonth(8));
        dto.setThang9(bookingDetailRepo.countBookingMonth(9));
        dto.setThang10(bookingDetailRepo.countBookingMonth(10));
        dto.setThang11(bookingDetailRepo.countBookingMonth(11));
        dto.setThang12(bookingDetailRepo.countBookingMonth(12));
        return dto;
    }
}
