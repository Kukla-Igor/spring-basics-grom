package com.lesson6.homework.service;

import com.lesson6.homework.DAO.FlightDAO;
import com.lesson6.homework.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class FlightService {
    FlightDAO flightDAO;

    @Autowired
    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public ResponseEntity<String> doPost(HttpServletRequest req) {
        return flightDAO.saveFlight(req);
    }

    public Flight doGet(HttpServletRequest req) {
        return flightDAO.findFlightById(req);
    }

    public ResponseEntity<String> doPut(HttpServletRequest req) {
        return flightDAO.updateFlight(req);
    }

    public ResponseEntity<String> doDelete(HttpServletRequest req) {
        return flightDAO.deleteFlight(req);
    }

    public List<Flight> flightsByDate(HttpServletRequest req){
        return flightDAO.flightsByDate(req);
    }

    public List<String> mostPopularTo(){return flightDAO.mostPopularTo();}

    public List<String> mostPopularFrom(){return flightDAO.mostPopularFrom();}
}
