package com.example.businessapibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayOfWeekRequest implements Serializable {
    private String dayOfWeek;
    private Integer StaffId;

}
