package com.lesson6.homework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table (name = "FLIGHT")

public class Flight extends IdEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("plane")
    private Plane plane;
    @JsonProperty("passenger")
    private Collection<Passenger> passenger;
    @JsonProperty("dateFlight")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFlight;
    @JsonProperty("cityFrom")
    private String cityFrom;
    @JsonProperty("cityTo")
    private String cityTo;

    public Flight() {
    }

    public Flight(long id, Plane plane, Collection<Passenger> passenger, Date dateFlight, String cityFrom, String cityTo) {
        this.id = id;
        this.plane = plane;
        this.passenger = passenger;
        this.dateFlight = dateFlight;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    @Id
    @SequenceGenerator(name = "FLA_SEQ", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLA_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }


    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "PLANE_ID")
    public Plane getPlane() {
        return plane;
    }
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<Passenger> getPassenger() {
        return passenger;
    }

    @Column(name = "DATE_FLIGHT")
    public Date getDateFlight() {
        return dateFlight;
    }

    @Column(name = "CITY_FROM")
    public String getCityFrom() {
        return cityFrom;
    }

    @Column(name = "CITY_TO")
    public String getCityTo() {
        return cityTo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setPassenger(Collection<Passenger> passenger) {
        this.passenger = passenger;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", dateFlight=" + dateFlight +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                '}';
    }
}
