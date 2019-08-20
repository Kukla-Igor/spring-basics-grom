package com.lesson6.homework.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson6.homework.model.Filter;
import com.lesson6.homework.model.Flight;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class FlightDAO extends GenDAO {

    public ResponseEntity<String> saveFlight(HttpServletRequest req){
        return save(req);
    }

    @Transactional
    public Flight findFlightById(HttpServletRequest req){
        Flight flight = (Flight) findById(req);
        flight.toString();
        return flight;
    }

    public ResponseEntity<String> updateFlight(HttpServletRequest req){
        return update(req);
    }

    public ResponseEntity<String> deleteFlight(HttpServletRequest req){
        return delete(req);
    }

    public List<Flight> flightsByDate(HttpServletRequest req){
        try (BufferedReader br = req.getReader()) {
            Filter filter = toJavaObject(br);
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Flight> personCriteria = cb.createQuery(Flight.class);
            Root<Flight> flightRoot = personCriteria.from(Flight.class);

            List<Predicate> predicates = new ArrayList<>();
            if (filter.getDateTo() != null && filter.getDateFrom() != null) {
                predicates.add(cb.between(flightRoot.<Date>get("dateFlight"), filter.getDateFrom(), filter.getDateTo()));
            } else if (filter.getDateFrom() != null) {
                predicates.add(cb.equal(flightRoot.get("dateFlight"), filter.getDateFrom()));
            }


            if (filter.getCityFrom() != null)
                predicates.add(cb.equal(flightRoot.get("cityFrom"), filter.getCityFrom()));
            if (filter.getCityTo() != null)
                predicates.add(cb.equal(flightRoot.get("cityTo"), filter.getCityTo()));
            if (filter.getModel() != null)
                predicates.add(cb.equal(flightRoot.get("plane").get("model"), filter.getModel()));

            personCriteria.where(predicates.toArray(new Predicate[predicates.size()]));

            TypedQuery<Flight> query = entityManager.createQuery(personCriteria);
            return query.getResultList();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<String> mostPopularTo(){
        return mostPop("CITY_TO");
    }

    public List<String> mostPopularFrom(){
        return mostPop("CITY_FROM");
    }

    private Filter toJavaObject(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.readValue(br, Filter.class);
    }

    @Override
    Class aClass() {
            return Flight.class;
    }
}
