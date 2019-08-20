package com.lesson6.homework.service;

import com.lesson6.homework.DAO.PassengerDAO;
import com.lesson6.homework.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PassengerService {
    PassengerDAO passengerDAO;

    @Autowired
    public PassengerService(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    public ResponseEntity<String> doPost(HttpServletRequest req) {
        return passengerDAO.savePassenger(req);
    }

    public Passenger doGet(HttpServletRequest req) {
        return passengerDAO.findPassengerById(req);
    }

    public ResponseEntity<String> doPut(HttpServletRequest req) {
        return passengerDAO.updatePassenger(req);
    }

    public ResponseEntity<String> doDelete(HttpServletRequest req) {
        return passengerDAO.deletePassenger(req);
    }
}
