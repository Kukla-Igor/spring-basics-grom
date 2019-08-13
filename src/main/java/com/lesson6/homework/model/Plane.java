package com.lesson6.homework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "PLANE")
public class Plane extends IdEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("model")
    private String model;
    @JsonProperty("code")
    private String code;
    @JsonProperty("yearProduced")
    @DateTimeFormat(pattern = "yyyy")
    private Date yearProduced;
    @JsonProperty("avgFuelConsumption")
    private double avgFuelConsumption;

    public Plane() {
    }

    public Plane(long id, String model, String code, Date yearProduced, double avgFuelConsumption) {
        this.id = id;
        this.model = model;
        this.code = code;
        this.yearProduced = yearProduced;
        this.avgFuelConsumption = avgFuelConsumption;
    }

    @Id
    @SequenceGenerator(name = "PLA_SEQ", sequenceName = "PLANE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLA_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @JoinColumn(name = "MODEL")
    public String getModel() {
        return model;
    }

    @JoinColumn(name = "CODE")
    public String getCode() {
        return code;
    }

    @JoinColumn(name = "YEARPRODUCED")
    public Date getYearProduced() {
        return yearProduced;
    }

    @JoinColumn(name = "AVGFUELCONSUMPTION")
    public double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy")
    public void setYearProduced(Date yearProduced) {
        this.yearProduced = yearProduced;
    }

    public void setAvgFuelConsumption(double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", code='" + code + '\'' +
                ", yearProduced=" + yearProduced +
                ", avgFuelConsumption=" + avgFuelConsumption +
                '}';
    }
}
