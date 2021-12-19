package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.ServiceCustomer;
import com.example.businessapibooking.repository.ServiceCustumerRepo;
import com.example.businessapibooking.service.ServiceCustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCustumerSerImpl implements ServiceCustumerService {
    @Autowired
    ServiceCustumerRepo serviceCustumerRepo;
    @Override
    public List<ServiceCustomer> getAll() {
        return serviceCustumerRepo.findAll();
    }
}
