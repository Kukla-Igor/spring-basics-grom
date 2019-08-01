package com.lesson2.homework.task1;

import java.util.List;

public class Service {
    private long id;
    private String name;
    private List paramsToCall;

    public Service(long id, String name, List paramsToCall) {
        this.id = id;
        this.name = name;
        this.paramsToCall = paramsToCall;
    }

    public Service() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List getParamsToCall() {
        return paramsToCall;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParamsToCall(List paramsToCall) {
        this.paramsToCall = paramsToCall;
    }
}
