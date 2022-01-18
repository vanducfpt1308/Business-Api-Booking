package com.example.businessapibooking.dto;

import com.example.businessapibooking.config.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO {

    @JsonFormat(pattern = Constants.DATE_FORMAT.DATE_TIME)
    private Date date;
    private Integer status;
}
