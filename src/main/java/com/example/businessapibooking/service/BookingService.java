package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.Booking;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Page;

import javax.persistence.OrderBy;
import java.util.List;

public interface BookingService {
    List<Booking> findByCustomer(Integer key);

    Booking findById(Integer id);

    List<Booking> findAll(List<Integer> ids);

    Booking save(Booking obj);

    List<Booking> saveAll(List<Booking> lst) throws Exception;

    void delete(Integer key);

    void deleteAll(List<Booking> lst);

    boolean existsById(Integer key);

    List<Booking> findByExample(Booking e);

    List<Booking> findLimit(int numberSkip, int limit);

    Page<Booking> findPage(int numberSkip, int limit, List<OrderBy> orderBys);

    List<Booking> findAll();

    Booking create(JsonNode bookingdata);
}
