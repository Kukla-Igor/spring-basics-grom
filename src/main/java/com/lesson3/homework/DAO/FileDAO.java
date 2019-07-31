package com.lesson3.homework.DAO;

import com.lesson3.homework.File;
import com.lesson3.homework.exception.InternalServerException;


public class FileDAO extends DAO {



    public File save (File file) {

        return (File) gSave(file);
    }

    public void delete (long id){
        gDelete(id);
    }

    public File update (File file){

        return (File) gUpdate(file);
    }

    public File findById (Long id) {
        return (File) gFindById(id);
        }



    @Override
    Class aClass() {
        return File.class;
    }
}


