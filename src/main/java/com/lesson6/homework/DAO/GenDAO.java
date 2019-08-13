package com.lesson6.homework.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson6.homework.model.IdEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;


@Repository
public abstract class GenDAO<T extends IdEntity> {

    @PersistenceContext
    private EntityManager entityManager;
    abstract Class aClass();



    public ResponseEntity<String> save(HttpServletRequest req){

        try (BufferedReader br = req.getReader()) {
            System.out.println(br);
            T t = toJavaObject(br);
            System.out.println(t);
            entityManager.persist(t);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    }

    @Transactional
    public  T findById(HttpServletRequest req) {
        try (BufferedReader br = req.getReader()){
            T t = toJavaObject(br);
            return (T) entityManager.find(aClass(),t.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ResponseEntity<String> update(HttpServletRequest req){
        try (BufferedReader br = req.getReader()) {
            T t = toJavaObject(br);
            entityManager.merge(t);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> delete(HttpServletRequest req){

        try {
            T t = findById(req);
            entityManager.remove(t);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    private <T> T toJavaObject(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (T)  mapper.readValue(br, aClass());
    }
}
