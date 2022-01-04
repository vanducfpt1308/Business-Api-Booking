package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ServiceCustomer")
public class ServiceCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String price;

    private String description;

    private String timeExamination;

    @Transient
    @JsonIgnore
    private MultipartFile photo;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceCustomer")
    private List<BookingDetail> bookingDetails;

}
