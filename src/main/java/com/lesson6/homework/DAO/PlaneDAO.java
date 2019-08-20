package com.lesson6.homework.DAO;

import com.lesson6.homework.model.Flight;
import com.lesson6.homework.model.Plane;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class PlaneDAO extends GenDAO {
    @Transactional
    public ResponseEntity<String> savePlane(HttpServletRequest req) {
        return save(req);
    }

    @Transactional
    public Plane findPlaneById(HttpServletRequest req) {
        return (Plane) findById(req);
    }

    @Transactional
    public ResponseEntity<String> updatePlane(HttpServletRequest req) {
        return update(req);
    }

    @Transactional
    public ResponseEntity<String> deletePlane(HttpServletRequest req) {
        return delete(req);
    }

    @Transactional
    public List<Plane> oldPlanes() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Plane> personCriteria = cb.createQuery(Plane.class);
        Root<Plane> planeRoot = personCriteria.from(Plane.class);

        Calendar date = Calendar.getInstance();
        date.add(Calendar.YEAR, -20);
        Date myDate = date.getTime();
        Predicate predicate = cb.lessThanOrEqualTo(planeRoot.<Date>get("yearProduced"), myDate);
        personCriteria.where(predicate);
        TypedQuery<Plane> query = entityManager.createQuery(personCriteria);

        return query.getResultList();
    }

    @Transactional
    public List<Plane> regularPlanes(HttpServletRequest req) {
        try (BufferedReader br = req.getReader()) {
            int year = Integer.parseInt(br.readLine());
            Calendar firstDate = Calendar.getInstance();
            Calendar lustDate = Calendar.getInstance();
            firstDate.set(year, Calendar.JANUARY, 1);
            lustDate.set(year, Calendar.DECEMBER, 31);
            Date myFirstDate = firstDate.getTime();
            Date myLustDate = lustDate.getTime();

            Query query = entityManager.createNativeQuery("SELECT * FROM FLIGHT where DATE_FLIGHT between ? AND ?", Flight.class);
            query.setParameter(1, myFirstDate);
            query.setParameter(2, myLustDate);
            List<Flight> flights = query.getResultList();

            List<Plane> result = new ArrayList<>();

            for (Flight flight : flights) {
                if (result.contains(flight.getPlane())) {
                    continue;
                }
                query = entityManager.createNativeQuery("SELECT * FROM FLIGHT where (DATE_FLIGHT between ? AND ?) AND PLANE_ID = ?", Flight.class);
                query.setParameter(1, myFirstDate);
                query.setParameter(2, myLustDate);
                query.setParameter(3, flight.getPlane().getId());
                List<Flight> list = query.getResultList();
                if (list.size() >= 300) {
                    result.add(flight.getPlane());
                }
            }
            System.out.println(result);
            return result;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    Class aClass() {
        return Plane.class;
    }
}
