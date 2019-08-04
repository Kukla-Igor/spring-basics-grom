package com.lesson3.homework.Service;

import com.lesson3.homework.DAO.DAO;
import com.lesson3.homework.DAO.FileDAO;
import com.lesson3.homework.File;
import com.lesson3.homework.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePtoject {

    @Autowired
    FileDAO fileDAO;



    public File put (Storage storage, File file) throws  Exception{

        return fileDAO.put(storage, file);
    }

    public File delete (Storage storage, File file) throws Exception {
        return fileDAO.delete(storage, file);
    }

    public void transferAll (Storage storageFrom, Storage storageTo) throws Exception {

        fileDAO.transferAll(storageFrom, storageTo);
    }

    public File transferFile (Storage storageFrom, Storage storageTo, long id) throws Exception {

        return fileDAO.transferFile(storageFrom, storageTo, id);
    }

}
