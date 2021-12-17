package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.businessapibooking.config.Constants;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "day_schedules")
public class DaySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    private Date startTime;
    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    private Date endTime;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "week_schedule_id")
    private WeekSchedule weekSchedule;
}
