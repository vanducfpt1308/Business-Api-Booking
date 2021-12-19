package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.ServiceCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCustumerRepo extends JpaRepository<ServiceCustomer,Integer> {
}
