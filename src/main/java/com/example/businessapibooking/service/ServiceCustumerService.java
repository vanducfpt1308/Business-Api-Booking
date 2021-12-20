package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.ServiceCustomer;

import java.util.List;

public interface ServiceCustumerService {
    List<ServiceCustomer> getAll();
    ServiceCustomer save(ServiceCustomer serviceCustomer);
}
