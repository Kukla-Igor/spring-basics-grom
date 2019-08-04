package com.lesson3.homework.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson3.homework.ObjectsWrapper;
import com.lesson3.homework.Service.ServicePtoject;
import com.lesson3.homework.Storage;
import com.lesson3.homework.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

//@Controller
public class ControllerProject extends HttpServlet {
    @Autowired
    ServicePtoject service;
    Storage storage;
    File file;
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.PUT, value = "put", produces = "text/plain")
    public @ResponseBody
    void doPut (HttpServletRequest req, HttpServletResponse resp){

             try (BufferedReader br = req.getReader()) {
                 ObjectsWrapper wrapper = mapper.readValue(br,ObjectsWrapper.class);
                 file = wrapper.getFile();
                 storage = wrapper.getStorageTo();

                System.out.println(service.put(storage, file));

            } catch (Exception e){
                 System.out.println(e.getMessage());
             }
        }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete", produces = "text/plain")
    public @ResponseBody
    void doDelete (HttpServletRequest req, HttpServletResponse resp){

        try (BufferedReader br = req.getReader()) {
            ObjectsWrapper wrapper = mapper.readValue(br,ObjectsWrapper.class);
            file = wrapper.getFile();
            storage = wrapper.getStorageTo();


            System.out.println(service.delete(storage, file));

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "transferAll", produces = "text/plain")
    public @ResponseBody
    void doGet(HttpServletRequest req, HttpServletResponse resp){
        Storage storageTo;
        Storage storageFrom;

            try (BufferedReader br = req.getReader()) {
                ObjectsWrapper wrapper = mapper.readValue(br,ObjectsWrapper.class);
                storageTo = wrapper.getStorageTo();
                storageFrom = wrapper.getStorageFrom();

                service.transferAll(storageFrom, storageTo);

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    @RequestMapping(method = RequestMethod.POST, value = "transferFile", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp){
        Storage storageTo;
        Storage storageFrom;

        try (BufferedReader br = req.getReader()) {
            ObjectsWrapper wrapper = mapper.readValue(br,ObjectsWrapper.class);
            storageTo = wrapper.getStorageTo();
            storageFrom = wrapper.getStorageFrom();
            file = wrapper.getFile();
            service.transferFile(storageFrom, storageTo, file.getId());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}




