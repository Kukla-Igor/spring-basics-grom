package com.lesson3.homework;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectsWrapper {
    @JsonProperty("storageFrom")
    private Storage storageFrom;
    @JsonProperty("storageTo")
    private Storage storageTo;
    @JsonProperty("file")
    private File file;
    @JsonProperty("id")
    private long id;

    public Storage getStorageFrom() {
        return storageFrom;
    }

    public Storage getStorageTo() {
        return storageTo;
    }

    public File getFile() {
        return file;
    }

    public long getId() {
        return id;
    }

    public void setStorageFrom(Storage storageFrom) {
        this.storageFrom = storageFrom;
    }

    public void setStorageTo(Storage storageTo) {
        this.storageTo = storageTo;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setId(long id) {
        this.id = id;
    }
}
