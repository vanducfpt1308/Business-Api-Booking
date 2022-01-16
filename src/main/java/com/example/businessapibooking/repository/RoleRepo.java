package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
