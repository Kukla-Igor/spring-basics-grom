package com.lesson6.homework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PASSENGER")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Passenger extends IdEntity {
    @Id
    @SequenceGenerator(name = "PASS_SEQ", sequenceName = "PASSENGER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASS_SEQ")
    @Column(name = "ID")
    @JsonProperty("id")
    private long id;

    @Column(name = "LAST_NAME")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "NATIONALITY")
    @JsonProperty("nationality")
    private String nationality;

    @Column(name = "DATE_OF_BIRTH")
    @JsonProperty("dateOfBirth")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateOfBirth;

    @Column(name = "PASSPORT_CODE")
    @JsonProperty("passportCode")
    private String passportCode;

    @ManyToOne
    @JoinColumn(name="FLIGHT_ID", nullable=false)
    @JsonProperty("flight")
    private Flight flight;
}
