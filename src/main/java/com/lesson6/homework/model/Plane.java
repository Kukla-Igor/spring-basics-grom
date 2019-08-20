package com.lesson6.homework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "PLANE")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Plane extends IdEntity {
    @Id
    @SequenceGenerator(name = "PLA_SEQ", sequenceName = "PLANE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLA_SEQ")
    @Column(name = "ID")
    @JsonProperty("id")
    private long id;

    @JoinColumn(name = "MODEL")
    @JsonProperty("model")
    private String model;

    @JoinColumn(name = "CODE")
    @JsonProperty("code")
    private String code;

    @JoinColumn(name = "YEARPRODUCED")
    @JsonProperty("yearProduced")
    @DateTimeFormat(pattern = "yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy")
    private Date yearProduced;

    @JoinColumn(name = "AVGFUELCONSUMPTION")
    @JsonProperty("avgFuelConsumption")
    private double avgFuelConsumption;
}
