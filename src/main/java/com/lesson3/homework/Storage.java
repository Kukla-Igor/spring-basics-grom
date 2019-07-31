package com.lesson3.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table (name = "STORAGE")
public class Storage extends IdEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("formatsSupported")
    private String formatsSupported;
    @JsonProperty("storageCountry")
    private String storageCountry;
    @JsonProperty("storageMaxSize")
    private long storageMaxSize;


    public Storage(long id, String formatsSupported, String storageCountry, long storageMaxSize) {
        this.id = id;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageMaxSize = storageMaxSize;
    }

    public Storage() {
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", formatsSupported=" + formatsSupported +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageMaxSize=" + storageMaxSize +
                '}';
    }

    @Id
    @SequenceGenerator(name = "STORAGE_SEQ", sequenceName = "STORAGES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORAGE_SEQ")
    @Column (name = "ID")
    public long getId() {
        return id;
    }


    @Column (name = "STORAGEMAXSIZE")
    public long getStorageMaxSize() {
        return storageMaxSize;
    }

    @Column (name = "FORMATSSUPPORTED")
    public String getFormatsSupported() {
        return formatsSupported;
    }

    @Column (name = "STORAGECOUNTRY")
    public String getStorageCountry() {
        return storageCountry;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFormatsSupported(String formatsSupported) {
        this.formatsSupported = formatsSupported;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    public void setStorageMaxSize(long storageMaxSize) {
        this.storageMaxSize = storageMaxSize;
    }
}