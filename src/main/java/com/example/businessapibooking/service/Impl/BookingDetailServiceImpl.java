package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.BookingDetail;
import com.example.businessapibooking.repository.BookingDetailRepo;
import com.example.businessapibooking.service.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {
    @Autowired
    BookingDetailRepo bookingDetailRepo;


    @Override
    public BookingDetail findbyId(Integer id) {
        return bookingDetailRepo.findById(id).get();
    }

    @Override
    public BookingDetail save(BookingDetail bookingDetail) {
        return bookingDetailRepo.save(bookingDetail);
    }

    @Override
    public List<BookingDetail> getAllByStatus(Integer stt) {
        return bookingDetailRepo.findByStatus(stt);
    }
}
