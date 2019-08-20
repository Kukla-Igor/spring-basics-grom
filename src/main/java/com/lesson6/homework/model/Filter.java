package com.lesson6.homework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter @Setter @ToString @NoArgsConstructor
public class Filter {

    @JsonProperty("dateFrom")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateFrom;

    @JsonProperty("dateTo")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateTo;

    @JsonProperty("cityFrom")
    private String cityFrom;

    @JsonProperty("cityTo")
    private String cityTo;

    @JsonProperty("model")
    private String model;
}
