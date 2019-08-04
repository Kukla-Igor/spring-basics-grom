package com.lesson3.homework.Service;

import com.lesson3.homework.DAO.FileDAO;
import com.lesson3.homework.File;
import com.lesson3.homework.exception.InternalServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFile {
    @Autowired
    FileDAO fileDAO;



    public File save (File file) {

        return fileDAO.save(file);
    }

    public void delete (long id) {
        fileDAO.delete(id);
    }

    public File update (File file) {

        return fileDAO.update(file);
    }

    public File findById (Long id)  {
        return fileDAO.findById(id);
    }
}
