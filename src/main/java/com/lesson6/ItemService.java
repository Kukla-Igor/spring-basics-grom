package com.lesson6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

@Service
public class ItemService {
    ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public ResponseEntity<String> doPost(HttpServletRequest req) {
        return itemDAO.save(req);
    }

    public Item doGet(HttpServletRequest req) {
        return itemDAO.findById(req);
    }

    public ResponseEntity<String> doPut(HttpServletRequest req) {
        return itemDAO.update(req);
    }

    public ResponseEntity<String> doDelete(HttpServletRequest req) {
        return itemDAO.delete(req);
    }

    public ResponseEntity<String> deleteByName(HttpServletRequest req) {
        return itemDAO.deleteByName(req);
    }
}
