package org.example.vraag1.dao;

import org.example.vraag1.hibernate.HibernateUtil;
import org.example.vraag1.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class MovieDao {
    private MovieDao(){}
    private static MovieDao instance;
    public static MovieDao getInstance(){
        if (instance == null) instance = new MovieDao();
        return instance;
    }
    public void createMovie(Movie movie){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(movie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Movie> getMovies(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT d FROM Movie d",Movie.class).list();
        }
    }
}
