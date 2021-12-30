package com.example.businessapibooking.entity;


import com.example.businessapibooking.config.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Booking_Details")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String time_start;

    private String time_end;

    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    private Date datebooking;

    private String note;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceCustomer serviceCustomer;

    @ManyToOne
    @JoinColumn(name = "id_staff")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;
}
