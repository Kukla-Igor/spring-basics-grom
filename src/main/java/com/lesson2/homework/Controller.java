package com.lesson2.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Route route;
    @Autowired
    private Service service;
    @Autowired
    private Step step;

    @RequestMapping(method = RequestMethod.GET, value = "/route", produces = "text/plain")
    public @ResponseBody
    String callToBean(){
        System.out.println(service.getId());
        System.out.println(service.getName());
        System.out.println(service.getParamsToCall());
        System.out.println(step.getId());
        System.out.println(step.getServiceFrom());
        System.out.println(step.getServiceTo());
        System.out.println(step.getParamsServiceFrom());
        System.out.println(step.getParamsServiceTo());
        System.out.println(route.getId());
        System.out.println(route.getSteps());

        return "end";
        }
}
