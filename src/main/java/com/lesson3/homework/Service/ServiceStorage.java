package com.lesson3.homework.Service;

import com.lesson3.homework.DAO.StorageDAO;
import com.lesson3.homework.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceStorage {
    @Autowired
    StorageDAO storageDAO;


    public Storage save (Storage storage) {

        return storageDAO.save(storage);
    }

    public void delete (long id) {
        storageDAO.delete(id);
    }

    public Storage update (Storage storage) {

        return storageDAO.update(storage);
    }

    public Storage findById (Long id)  {
        return storageDAO.findById(id);
    }
}
