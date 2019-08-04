package com.lesson3.homework.DAO;

import com.lesson3.homework.Storage;
import com.lesson3.homework.exception.InternalServerException;
import org.springframework.stereotype.Repository;

@Repository
public class StorageDAO extends DAO {

    public Storage save (Storage storage) {

        return (Storage) gSave(storage);
    }

    public void delete (long id){
        gDelete(id);
    }

    public Storage update (Storage storage) {

        return (Storage) gUpdate(storage);
    }

    public Storage findById (Long id)  {
        return (Storage) gFindById(id);
        }

    @Override
    Class aClass() {
        return Storage.class;
    }
}
