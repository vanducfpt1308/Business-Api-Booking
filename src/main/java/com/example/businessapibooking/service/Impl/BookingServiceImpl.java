package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.Booking;
import com.example.businessapibooking.repository.BookingRepository;
import com.example.businessapibooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository repository;

    @Override
    public List<Booking> findByCustomer(Integer key) {
        return repository.findByCustomer(key);
    }

    @Override
    public Booking findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Booking> findAll(List<Integer> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Booking save(Booking obj) {
        return null;
    }

    @Override
    public List<Booking> saveAll(List<Booking> lst) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void deleteAll(List<Booking> lst) {

    }

    @Override
    public boolean existsById(Integer key) {
        return false;
    }

    @Override
    public List<Booking> findByExample(Booking e) {
        return null;
    }

    @Override
    public List<Booking> findLimit(int numberSkip, int limit) {
        return null;
    }

    @Override
    public Page<Booking> findPage(int numberSkip, int limit, List<OrderBy> orderBys) {
        return null;
    }

    @Override
    public List<Booking> findAll() {
        return null;
    }
}
