package com.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.annotation.WebServlet;

//@WebServlet(urlPatterns = "/")
//@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "orderSave", produces = "text/plain")
    public @ResponseBody
    String saveOrder(){
        orderService.save(null);
        return "ok";
    }

}
