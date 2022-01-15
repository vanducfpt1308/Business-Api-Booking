package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,String> {
    @Query("SELECT e FROM Users e WHERE e.username = ?1")
    Users findByUsername(String username);

    @Query("SELECT e FROM Users e WHERE e.username =:id")
    public Users finById(@Param("id") String id);
}
