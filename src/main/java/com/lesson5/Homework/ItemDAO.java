package com.lesson5.Homework;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


//@Repository
//@Transactional
public class ItemDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public ResponseEntity<String> save(Item item){
        try {
            entityManager.persist(item);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    }

    public Item findById(long id) {
        try {
            return entityManager.find(Item.class, id);
        } catch (Exception e) {
            new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return null;
        }
    }


    public ResponseEntity<String> delete(long id){
        try {
            Item item = findById(id);
            System.out.println(item);
            entityManager.remove(item);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> update(Item item){
        try {
            entityManager.merge(item);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
