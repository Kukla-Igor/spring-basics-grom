package com.lesson2.homework.task1;

import org.springframework.beans.factory.annotation.Autowired;


public class Controller {
    @Autowired
    Route route;
    @Autowired
    Service service;
    @Autowired
    Step step;


    public String callByBean(){
        return route.getId();
//        System.out.println(route.getSteps());
//        System.out.println(service.getId());
//        System.out.println(service.getName());
//        System.out.println(service.getParamsToCall());
//        System.out.println(step.getId());
//        System.out.println(step.getParamsServiceFrom());
//        System.out.println(step.getParamsServiceTo());
//        System.out.println(step.getServiceFrom());
//        System.out.println(step.getServiceTo());

    }

}
