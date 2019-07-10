package com.lesson2.homework.task2;

import org.springframework.beans.factory.annotation.Autowired;

public class ItemService {
    @Autowired
    ItemDAO itemDAO;

    public Item doPost(Item item) {
        return itemDAO.save(item);
    }

    public Item doGet(Long id) {
        return itemDAO.findById(id);
    }

    public Item doPut(Item item) {
        return itemDAO.update(item);
    }

    public void doDelete(Long id) {
        itemDAO.delete(id);
    }
}
