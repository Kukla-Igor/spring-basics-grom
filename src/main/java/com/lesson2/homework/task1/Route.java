package com.lesson2.homework.task1;

import java.util.List;

public class Route {
    String id;
    List steps;


    public Route(String id, List steps) {
        this.id = id;
        this.steps = steps;
    }

    public String getId() {
        return id;
    }

    public List getSteps() {
        return steps;
    }
}



