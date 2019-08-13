package com.lesson6.homework.service;

import com.lesson6.homework.DAO.PlaneDAO;
import com.lesson6.homework.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PlaneService {
    PlaneDAO planeDAO;

    @Autowired
    public PlaneService(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    public ResponseEntity<String> doPost(HttpServletRequest req) {
        return planeDAO.savePlane(req);
    }

    public Plane doGet(HttpServletRequest req) {
        return  planeDAO.findPlaneById(req);
    }

    public ResponseEntity<String> doPut(HttpServletRequest req) {
        return planeDAO.updatePlane(req);
    }

    public ResponseEntity<String> doDelete(HttpServletRequest req) {
        return planeDAO.deletePlane(req);
    }
}
