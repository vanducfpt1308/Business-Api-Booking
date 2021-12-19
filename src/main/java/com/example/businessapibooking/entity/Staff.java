package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.businessapibooking.config.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String workExperience;

    private String description;

    private String academicLevel;

    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    private Date dateStartWork;

    private boolean gender;

    private String fullName;

    private String email;

    private Integer phoneNumber;

    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<WeekSchedule> weekSchedule;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "username")
    private Users user;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<BookingDetail> bookingDetails;
}
