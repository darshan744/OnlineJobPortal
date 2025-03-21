package com.onlinejob.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinejob.Entities.Employer;
import com.onlinejob.utils.HibernateUtil;

public class EmployerDAO {

    public static EmployerDAO employerDAO = null;

    public static EmployerDAO getEmployerDAO(){
        if(employerDAO != null){
            return employerDAO;
        }
        employerDAO = new EmployerDAO();
        return employerDAO;
    }


    public void updateUser(Employer employer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(employer);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
            System.out.println(e.getLocalizedMessage());
        }
        finally{
            session.close();
        }
        
    }

}
