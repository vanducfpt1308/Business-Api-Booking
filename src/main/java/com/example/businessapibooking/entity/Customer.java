package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String photo;

    private String fullName;

    private String address;

    private Integer phone;

    private Integer gender;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "username")
    private Users user;

    @JsonIgnore
    @OneToMany(mappedBy ="customer")
    private List<Booking> bookings;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
}
