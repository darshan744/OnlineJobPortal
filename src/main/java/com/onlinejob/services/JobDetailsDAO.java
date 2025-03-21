package com.onlinejob.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.onlinejob.Entities.JobDetails;
import com.onlinejob.utils.HibernateUtil;

public class JobDetailsDAO {


    private static JobDetailsDAO jobDetailsDAO = null;


    public static JobDetailsDAO getJobDetailsDAO(){
        if(jobDetailsDAO == null) {
            jobDetailsDAO = new JobDetailsDAO();
            return jobDetailsDAO;
        }
        return jobDetailsDAO;
    }
    public void putJobDetails(JobDetails jobDetails) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(jobDetails);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
            System.out.println("--------------------------------------------------");
            System.err.println(e.getLocalizedMessage());
            System.out.println("--------------------------------------------------");
        }

    }
    public List<JobDetails> getJobDetails(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<JobDetails> query = session.createQuery("from JobDetails" , JobDetails.class);
        List<JobDetails> list = query.list();
        return list;
    }
}
