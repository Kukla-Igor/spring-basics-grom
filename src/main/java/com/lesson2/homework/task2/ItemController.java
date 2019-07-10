package com.lesson2.homework.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@Controller
public class ItemController extends HttpServlet {
    @Autowired
    ItemService itemService;
    Item item;

    @RequestMapping(method = RequestMethod.GET, value = "test", produces = "text/plain")
    public @ResponseBody
    void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            item = toJavaObject(br);
            System.out.println(itemService.doGet(item.getId()));
        }
        }

    @RequestMapping(method = RequestMethod.POST, value = "test", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Item item;

        try (BufferedReader br = req.getReader()) {
            item = toJavaObject(br);
            System.out.println(itemService.doPost(item));
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "test", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            item = toJavaObject(br);
            System.out.println(itemService.doPut(item));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "test", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            item = toJavaObject(br);
            itemService.doDelete(item.getId());
        }
    }


    public static Item toJavaObject(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, Item.class);
    }
}