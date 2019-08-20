package com.lesson6.homework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table (name = "FLIGHT")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Flight extends IdEntity {
    @Id
    @SequenceGenerator(name = "FLA_SEQ", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLA_SEQ")
    @Column(name = "ID")
    @JsonProperty("id")
    private long id;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "PLANE_ID")
    @JsonProperty("plane")
    private Plane plane;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonProperty("passenger")
    private Collection<Passenger> passenger;

    @Column(name = "DATE_FLIGHT")
    @JsonProperty("dateFlight")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFlight;

    @Column(name = "CITY_FROM")
    @JsonProperty("cityFrom")
    private String cityFrom;

    @Column(name = "CITY_TO")
    @JsonProperty("cityTo")
    private String cityTo;
}
