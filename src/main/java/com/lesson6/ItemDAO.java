package com.lesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson3.homework.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@Repository

public class ItemDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ResponseEntity<String> save(HttpServletRequest req){

        try (BufferedReader br = req.getReader()) {
            Item item = toJavaObject(br);
            entityManager.persist(item);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
    }

    @Transactional
    public Item findById(HttpServletRequest req) {
        try (BufferedReader br = req.getReader()){
            Item item = toJavaObject(br);
            return entityManager.find(Item.class, item.getId());
        } catch (Exception e) {
            new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return null;
        }
    }

    @Transactional
    public ResponseEntity<String> update(HttpServletRequest req){
        try (BufferedReader br = req.getReader()) {
            Item item = toJavaObject(br);
            entityManager.merge(item);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<String> delete(HttpServletRequest req){

        try {
            Item item = findById(req);
            entityManager.remove(item);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<String> deleteByName(HttpServletRequest req){


        try(BufferedReader br = req.getReader()) {
            String name = br.readLine();
            Query query = entityManager.createNativeQuery("SELECT * FROM ITEM WHERE NAME LIKE ?", Item.class);
            query.setParameter(1, "%" + name + "%");

            List<Item> list = query.getResultList();

            for(Item item : list){
                entityManager.remove(item);
            }

            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    private Item toJavaObject(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, Item.class);
    }
}
