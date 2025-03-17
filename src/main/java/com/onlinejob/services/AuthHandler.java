package com.onlinejob.services;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.onlinejob.Entities.User;
import com.onlinejob.utils.HibernateUtil;

public class AuthHandler {
    
    private static AuthHandler authHandler = null;

    public static AuthHandler getAuthHandler() {
        if(authHandler != null) {
            return authHandler;
        }
        authHandler = new AuthHandler();
        return authHandler;
    }

    public User getUser(String logininput) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        try (Session session = sf.openSession()) {
            Query<User> query = session.createQuery("from User where username = :input OR email = :input" , User.class);
            query.setParameter("input", logininput);
            session.getTransaction().begin();;
            User user = query.uniqueResult();
            session.getTransaction().commit();
            return user;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public boolean putUser(User user) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.persist(user);
            tx.commit();

            return true;
        }
        catch(HibernateException he) {
            he.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
            return false;
        }


    }

}
