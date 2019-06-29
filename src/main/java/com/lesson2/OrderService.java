package com.lesson2;

import org.springframework.beans.factory.annotation.Autowired;


public class OrderService {
    @Autowired
    OrderDAO orderDAO;
    public Order save(Order order){
        return null;
    }
}
