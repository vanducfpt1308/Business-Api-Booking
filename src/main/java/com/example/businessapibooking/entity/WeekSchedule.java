package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "week_schedules")
public class WeekSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private Integer status;

    @ManyToOne
    @JoinColumn(name="STAFFID")
    private Staff staff;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "weekSchedule")
    @OrderBy("weekSchedule")
    private Set<DaySchedule> daySchedules;
}
