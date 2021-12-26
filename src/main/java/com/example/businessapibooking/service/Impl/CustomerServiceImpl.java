package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.Customer;
import com.example.businessapibooking.repository.CustomerRepo;
import com.example.businessapibooking.service.CustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustumerService {

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
