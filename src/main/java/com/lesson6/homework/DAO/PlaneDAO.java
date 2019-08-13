package com.lesson6.homework.DAO;

import com.lesson6.homework.model.Plane;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Repository
public class PlaneDAO extends GenDAO {
    @Transactional
    public ResponseEntity<String> savePlane(HttpServletRequest req){
        return save(req);
    }

    @Transactional
    public Plane findPlaneById(HttpServletRequest req){
        return (Plane) findById(req);
    }

    @Transactional
    public ResponseEntity<String> updatePlane(HttpServletRequest req){
        return update(req);
    }

    @Transactional
    public ResponseEntity<String> deletePlane(HttpServletRequest req){
        return delete(req);
    }


    @Override
    Class aClass() {
        return Plane.class;
    }
}
