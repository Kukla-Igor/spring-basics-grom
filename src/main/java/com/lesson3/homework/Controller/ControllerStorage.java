package com.lesson3.homework.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson3.homework.Service.ServiceStorage;
import com.lesson3.homework.Storage;
import com.lesson3.homework.exception.InternalServerException;
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
//@WebServlet(urlPatterns = "/ControllerStorage")
@Controller
public class ControllerStorage extends HttpServlet {
    @Autowired
    ServiceStorage serviceStorage;
    @Autowired
    Storage storage;



    @RequestMapping(method = RequestMethod.GET, value = "ControllerStorage", produces = "text/plain")
    public @ResponseBody
    void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            storage = toJavaObject(br);
            System.out.println(serviceStorage.findById(storage.getId()));
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "ControllerStorage", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try (BufferedReader br = req.getReader()) {
            storage = toJavaObject(br);
            System.out.println(serviceStorage.save(storage));
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "ControllerStorage", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            storage = toJavaObject(br);
            System.out.println(serviceStorage.update(storage));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "ControllerStorage", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            storage = toJavaObject(br);
            serviceStorage.delete(storage.getId());
        }
    }


    private static Storage toJavaObject(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, Storage.class);
    }
}
