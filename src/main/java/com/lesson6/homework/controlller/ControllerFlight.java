package com.lesson6.homework.controlller;

import com.lesson6.homework.model.Flight;
import com.lesson6.homework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ControllerFlight extends HttpServlet {
    FlightService flightService;

    @Autowired
    public ControllerFlight(FlightService flightService) {
        this.flightService = flightService;
    }



    @RequestMapping(method = RequestMethod.GET, value = "getFlight", produces = "text/plain")
    public @ResponseBody
    void doGet (HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(flightService.doGet(req));
    }

    @RequestMapping(method = RequestMethod.POST, value = "postFlight", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(flightService.doPost(req));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "putFlight", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(flightService.doPut(req));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFlight", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(flightService.doDelete(req));
    }

    @RequestMapping(method = RequestMethod.GET, value = "flightsByDate", produces = "text/plain")
    public @ResponseBody
    List<Flight> flightsByDate (HttpServletRequest req){
        return flightService.flightsByDate(req);
        }

    @RequestMapping(method = RequestMethod.GET, value = "mostPopularTo", produces = "text/plain")
    public @ResponseBody List<String> mostPopularTo(){return flightService.mostPopularTo();}

    @RequestMapping(method = RequestMethod.GET, value = "mostPopularFrom", produces = "text/plain")
    public @ResponseBody List<String> mostPopularFrom(){
        List<String> list = flightService.mostPopularFrom();
        System.out.println(list);
        return list;
    }
}
