package com.lesson6.homework.DAO;

import com.lesson6.homework.model.Flight;
import org.hibernate.annotations.Proxy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FlightDAO extends GenDAO {

    public ResponseEntity<String> saveFlight(HttpServletRequest req){
        return save(req);
    }

    @Transactional
    public Flight findFlightById(HttpServletRequest req){
        return (Flight) findById(req);
    }

    public ResponseEntity<String> updateFlight(HttpServletRequest req){
        return update(req);
    }

    public ResponseEntity<String> deleteFlight(HttpServletRequest req){
        return delete(req);
    }

    @Override
    Class aClass() {
            return Flight.class;
    }
}
