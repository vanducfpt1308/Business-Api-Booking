package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.businessapibooking.config.Constants;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;


@Entity
@Data
@Table(name = "day_schedules")
public class DaySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Time startTime;

    private Time endTime;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "week_schedule_id")
    private WeekSchedule weekSchedule;
}
