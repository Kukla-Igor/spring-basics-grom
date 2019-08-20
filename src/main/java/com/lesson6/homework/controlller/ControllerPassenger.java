package com.lesson6.homework.controlller;

import com.lesson6.homework.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ControllerPassenger extends HttpServlet {
    PassengerService passengerService;

    @Autowired
    public ControllerPassenger(PassengerService passengerService) {
        this.passengerService = passengerService;
    }



    @RequestMapping(method = RequestMethod.GET, value = "getPassenger", produces = "text/plain")
    public @ResponseBody
    void doGet (HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(passengerService.doGet(req));
    }

    @RequestMapping(method = RequestMethod.POST, value = "postPassenger", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(passengerService.doPost(req));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "putPassenger", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(passengerService.doPut(req));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePassenger", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(passengerService.doDelete(req));
    }


}
