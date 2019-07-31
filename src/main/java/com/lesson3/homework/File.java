package com.lesson3.homework;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table (name = "FILES")
public class File extends IdEntity{
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("format")
    private String format;
    @JsonProperty("size")
    private long size;
    @JsonIgnore
    private Storage storage;

    @Autowired
    public File(long id, String name, String format, long size) {
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
    }

    public File() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (id != file.id) return false;
        return name != null ? name.equals(file.name) : file.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                ", storage=" + storage +
                '}';
    }


    @Id
    @SequenceGenerator(name = "FILE_SEQ", sequenceName = "FILES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILE_SEQ")
    @Column (name = "ID")
    public long getId() {
        return id;
    }

    @Column (name = "NAME")
    public String getName() {
        return name;
    }

    @Column (name = "FORMAT")
    public String getFormat() {
        return format;
    }

    @Column (name = "SIZING")
    public long getSize() {
        return size;
    }

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn (name = "STORAGE_ID")
    public Storage getStorage() {
        return storage;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}