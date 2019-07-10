package com.lesson2.homework.task2;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemDAO {
    private static SessionFactory sessionFactory;
    private Transaction tr = null;


    public Item save(Item item){
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.save(item);

            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
        }
        return item;
    }

    public Item findById(Long id) {
        Item item = null;

        try  {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            item = session.get(Item.class, id);

            tr.commit();

        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        }
        return item;
    }

    public Item update(Item item){
        try (Session session = createSessionFactory().openSession())  {
            tr = session.getTransaction();
            tr.begin();

            session.update(item);

            tr.commit();

            System.out.println("Update is done");
        } catch (HibernateError e){
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
        }
        return item;
    }

    public void delete(Long id){
        try (Session session = createSessionFactory().openSession())  {

            tr = session.getTransaction();
            tr.begin();

            Item item;

            item = session.get(Item.class, id);

            session.delete(item);

            tr.commit();

            System.out.println("Delete is done");
        } catch (HibernateError e){
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
        }
    }

    static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
