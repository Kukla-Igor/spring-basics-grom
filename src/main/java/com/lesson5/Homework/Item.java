package com.lesson5.Homework;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

public class Item {
    @JsonProperty("id")
    private long id;
    @JsonProperty("description")
    private String description;

    @Id
    @SequenceGenerator(name = "ITEM_SEQ", sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
    public long getId() {
        return id;
    }

    @Column (name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
