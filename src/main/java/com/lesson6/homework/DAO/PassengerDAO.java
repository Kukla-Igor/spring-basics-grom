package com.lesson6.homework.DAO;

import com.lesson6.homework.model.Passenger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Repository
public class PassengerDAO extends GenDAO {
    @Transactional
    public ResponseEntity<String> savePassenger(HttpServletRequest req){
        return save(req);
    }

    @Transactional
    public Passenger findPassengerById(HttpServletRequest req){
        return (Passenger) findById(req);
    }

    @Transactional
    public ResponseEntity<String> updatePassenger(HttpServletRequest req){
        return update(req);
    }

    @Transactional
    public ResponseEntity<String> deletePassenger(HttpServletRequest req){
        return delete(req);
    }



    @Override
    Class aClass() {
            return Passenger.class;
    }
}
