package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.businessapibooking.config.Constants;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", columnDefinition = "nvarchar(100)")
    private String name;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "IMAGE")
    private String image;

    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    @Column(name = "CREATEDATE")
    private Date CreateDate = new Date();

    @Column(name = "QUANTITY")
    private int Quantity;

    @ManyToOne
    @JoinColumn(name = "CATEGORYID")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

}
