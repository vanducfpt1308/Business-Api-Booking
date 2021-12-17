package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.businessapibooking.config.Constants;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    private Date create_date;

    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails;
}
