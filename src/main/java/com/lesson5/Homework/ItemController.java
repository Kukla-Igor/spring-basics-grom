package com.lesson5.Homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson3.homework.File;
import com.lesson5.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Controller
public class ItemController extends HttpServlet {
    ItemDAO itemDAO;

    @Autowired
    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item/save", produces = "text/plain")
    public @ResponseBody
    ResponseEntity<String> save(HttpServletRequest req) throws IOException{
        try (BufferedReader br = req.getReader()) {
            Item item = toJavaObject(br);
            return itemDAO.save(item);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/item/delete", produces = "text/plain")
    public @ResponseBody
    ResponseEntity<String> delete(HttpServletRequest req) throws IOException{
        try (BufferedReader br = req.getReader()) {
            Item item = toJavaObject(br);
            return itemDAO.delete(item.getId());
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/item/update", produces = "text/plain")
    public @ResponseBody
    ResponseEntity<String> update(HttpServletRequest req) throws IOException{
        try (BufferedReader br = req.getReader()) {
            Item item = toJavaObject(br);
            return itemDAO.update(item);
        }
    }

    private static Item toJavaObject(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, Item.class);
    }
}
