package com.lesson2.homework;

import java.util.List;

public class Route {
    private long id;
    private List<Step> steps;

    public Route(long id, List<Step> steps) {
        this.id = id;
        this.steps = steps;
    }

    public long getId() {
        return id;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
