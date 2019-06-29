package com.lesson2.homework.task1;

import java.util.Map;

public class Step {
    private long id;
    private Service serviceFrom;
    private Service serviceTo;
    private Map paramsServiceFrom;
    private Map paramsServiceTo;

    public Step() {

    }

    public long getId() {
        return id;
    }

    public Service getServiceFrom() {
        return serviceFrom;
    }

    public Service getServiceTo() {
        return serviceTo;
    }

    public Map getParamsServiceFrom() {
        return paramsServiceFrom;
    }

    public Map getParamsServiceTo() {
        return paramsServiceTo;
    }
}
