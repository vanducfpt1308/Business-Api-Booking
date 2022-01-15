package com.example.businessapibooking.dto;

import com.example.businessapibooking.entity.BookingDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionReceive {
    private BookingDetail bookingDetail;
    private Integer status;
}
