package com.lesson3.homework.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lesson3.homework.File;
import com.lesson3.homework.Service.ServiceFile;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ControllerFile extends HttpServlet {
    @Autowired
    ServiceFile serviceFile;
    @Autowired
    File file;



    @RequestMapping(method = RequestMethod.GET, value = "ControllerFile", produces = "text/plain")
    public @ResponseBody
    void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {

            file = toJavaObject(br);
            System.out.println(serviceFile.findById(file.getId()));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "ControllerFile", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try (BufferedReader br = req.getReader()) {
            file = toJavaObject(br);
            System.out.println(serviceFile.save(file));
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "ControllerFile", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            file = toJavaObject(br);
            System.out.println(serviceFile.update(file));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "ControllerFile", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (BufferedReader br = req.getReader()) {
            file = toJavaObject(br);
            serviceFile.delete(file.getId());
        }
    }


    private static File toJavaObject(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, File.class);
    }


}
