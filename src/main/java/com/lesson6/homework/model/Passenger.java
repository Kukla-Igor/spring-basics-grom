package com.lesson6.homework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PASSENGER")
public class Passenger extends IdEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("dateOfBirth")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    @JsonProperty("passportCode")
    private String passportCode;
    @JsonProperty("flight")
    private Flight flight;

    public Passenger() {
    }

    public Passenger(long id, String lastName, String nationality, Date dateOfBirth, String passportCode, Flight flight) {
        this.id = id;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passportCode = passportCode;
        this.flight = flight;
    }

    @Id
    @SequenceGenerator(name = "PASS_SEQ", sequenceName = "PASSENGER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASS_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }
    @Column(name = "NATIONALITY")
    public String getNationality() {
        return nationality;
    }

    @Column(name = "DATE_OF_BIRTH")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "PASSPORT_CODE")
    public String getPassportCode() {
        return passportCode;
    }

    @ManyToOne
    @JoinColumn(name="FLIGHT_ID", nullable=false)
    public Flight getFlight() {
        return flight;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportCode='" + passportCode + '\'' +
                '}';
    }
}
