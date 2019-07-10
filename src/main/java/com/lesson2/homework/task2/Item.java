package com.lesson2.homework.task2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM")
public class Item {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dateCreated")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateCreated;
    @JsonProperty("lastUpdateDate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date lastUpdatedDate;
    @JsonProperty("description")
    private String description;

    public Item() {
    }


    public Item(String name, Date dateCreated, Date lastUpdatedDate, String description) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.lastUpdatedDate = lastUpdatedDate;
        this.description = description;
    }

    @Id
    @SequenceGenerator(name = "IT_SEQ", sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IT_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    @Column(name = "LAST_UPDATED_DATE")
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", description='" + description + '\'' +
                '}';
    }
}
