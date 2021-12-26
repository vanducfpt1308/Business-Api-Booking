package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.Role;
import com.example.businessapibooking.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query("from Staff s where s.user.role.id = :role")
    List<Staff> findByUserRole(Integer role);
}
