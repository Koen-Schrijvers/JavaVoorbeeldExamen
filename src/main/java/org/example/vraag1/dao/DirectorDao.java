package org.example.vraag1.dao;

import org.example.vraag1.hibernate.HibernateUtil;
import org.example.vraag1.model.Director;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DirectorDao {

    private DirectorDao(){}
    private static DirectorDao instance;
    public static DirectorDao getInstance(){
        if (instance == null) instance = new DirectorDao();
        return instance;
    }
    public void createDirector(Director director){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(director);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Director> getDirectors(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT d FROM Director d",Director.class).list();
        }
    }

}
