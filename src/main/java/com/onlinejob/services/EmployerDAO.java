package com.onlinejob.services;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
    public Employer getEmployerWithId(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            Query<Employer> query = session.createQuery("FROM Employer e JOIN FETCH e.postedJobs WHERE e.id = :id", Employer.class);
            tx = session.beginTransaction();
            query.setParameter("id", id);
            Employer emp = query.uniqueResult();
            return emp;
        }
        catch(Exception e) {
            System.err.println(e.getLocalizedMessage());
            if(tx!=null) {
                tx.rollback();
            }
        }
        return null;
    }
}
