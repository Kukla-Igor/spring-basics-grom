package com.lesson2.homework;

import java.util.Map;

public class Step {
    private long id;
    private Service serviceFrom;
    private Service serviceTo;
    private Map<String,Service> paramsServiceFrom;
    private Map<String,Service> paramsServiceTo;

    public Step(long id, Service serviceFrom, Service serviceTo, Map<String, Service> paramsServiceFrom, Map<String, Service> paramsServiceTo) {
        this.id = id;
        this.serviceFrom = serviceFrom;
        this.serviceTo = serviceTo;
        this.paramsServiceFrom = paramsServiceFrom;
        this.paramsServiceTo = paramsServiceTo;
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
