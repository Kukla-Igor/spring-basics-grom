package com.lesson3.homework.DAO;
import com.lesson3.homework.*;
import com.lesson3.homework.exception.BadRequestException;
import com.lesson3.homework.exception.InternalServerException;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public abstract class DAO <T extends IdEntity> {

    abstract Class aClass();
    private static SessionFactory sessionFactory;
        public Transaction tr = null;
        Session session = null;


    public T gFindById(long id) {
        T t = null;

        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();


            t = (T) session.get(aClass(), id);

            tr.commit();

            System.out.println("Find");
        } catch (HibernateError e) {
                System.err.println(e.getMessage());
        }finally
        {
            if (session != null)
                session.close();
        }
        return t;
    }

    public T gSave(T t) {

        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.save(t);

            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        }finally
        {
            if (session != null)
                session.close();
        }
        return t;
    }

    public void gDelete(Long id) {
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.delete(session.get(aClass(), id));

            tr.commit();

            System.out.println("Delete is done");
        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        }finally
        {
            if (session != null)
                session.close();
        }
    }

    public T gUpdate(T t) {
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            session.update(t);

            tr.commit();

            System.out.println("Update is done");
        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        }finally
        {
            if (session != null)
                session.close();
        }
        return t;
    }



    public File put(Storage storage, File file) throws Exception {
            nullCheck(storage, file);
            formatCheck(storage, file);
            idCheckToPut(storage, file);



            try (Session session = createSessionFactory().openSession()) {

                tr = session.getTransaction();
                tr.begin();

                sizeCheck(storage, file.getSize(), session);
                file.setStorage(storage);
                session.update(file);

                tr.commit();

                System.out.println("Save is done");
            } catch (HibernateError e) {
                throw new InternalServerException("Save is failed");
            }finally
            {
                if (session != null)
                    session.close();
            }
            return file;

        }


        public File delete(Storage storage, File file) throws Exception {
            nullCheck(storage, file);
            idCheckToDelete(storage, (File) gFindById(file.getId()));
            try (Session session = createSessionFactory().openSession()) {

                tr = session.getTransaction();
                tr.begin();


                session.update(file);

                tr.commit();
                System.out.println("Delete is done");
            } catch (HibernateError e) {
                throw new InternalServerException("Delete is failed");
            }finally
            {
                if (session != null)
                    session.close();
            }
            return file;
        }


        public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{

            List<File> files = null;
            nullCheck(storageFrom, storageTo);


            try (Session session = createSessionFactory().openSession()) {
                tr = session.getTransaction();
                tr.begin();

                Query query = session.createNativeQuery("SELECT * FROM Files where STORAGE_ID  = ?", File.class);
                query.setParameter(1, storageFrom.getId());

                files =  query.list();
                long size = 0;

                for (File file : files){
                    formatCheck(storageTo, file);
                   size += file.getSize();
                }

                sizeCheck(storageTo, size, session);


                for (File file : files) {
                    query = session.createNativeQuery("UPDATE files SET STORAGE_ID = ? where id = ?");
                    query.setParameter(1, storageTo.getId());
                    query.setParameter(2, file.getId());
                    query.executeUpdate();
                }

                tr.commit();

                System.out.println("Update!");
            } catch (HibernateError e){
                System.err.println("Error");
                System.err.println(e.getMessage());

            }finally {
                if (session != null)
                    session.close();

            }
        }

        public File transferFile (Storage storageFrom, Storage storageTo, long id) throws Exception{
            File file = (File) gFindById(id);
            idCheckToDelete(storageFrom, file);
            nullCheck(storageFrom, storageTo);

            return put(storageTo, file);
        }


        private void nullCheck(IdEntity object1, IdEntity object2) throws BadRequestException {
            if (object1 == null)
                throw new BadRequestException("Your`s object is null");
            if (object2 == null)
                throw new BadRequestException("Your`s object1 is null");
        }

        private void idCheckToPut(Storage storage, File file) throws BadRequestException {
            if (file.getStorage() != null && file.getStorage().getId() == storage.getId())
                throw new BadRequestException(file.getId() + " file is already in " + storage.getId() + " storage");
        }

        private void idCheckToDelete(Storage storage, File file) throws BadRequestException {
            if (file.getStorage() == null || file.getStorage().getId() != storage.getId())
                throw new BadRequestException(file.getId() + " file is not in " + storage.getId() + " storage");
        }


        private void formatCheck(Storage storage, File file) throws BadRequestException {
            String[] arr = storage.getFormatsSupported().split(", ");
            for (String format : arr) {
                if (format.equals(file.getFormat()))
                    return;
            }
            throw new BadRequestException(file.getId() + " file format is not supported by " + storage.getId() + " storage");

        }

        private void sizeCheck(Storage storage, long size, Session session) throws InternalServerException {
            Query query = session.createNativeQuery("SELECT sizing FROM FILES WHERE STORAGE_ID = ?", File.class);
            query.setParameter(1, storage.getId());


            List<Long> list  =  query.list();


            for (Long sizeFile : list){
                size += sizeFile;
            }


            if (storage.getStorageMaxSize() < size)
                throw new InternalServerException("There is not enough space in " + storage.getId() + " storage for file");
        }


        static SessionFactory createSessionFactory() {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
            return sessionFactory;
        }
    }

