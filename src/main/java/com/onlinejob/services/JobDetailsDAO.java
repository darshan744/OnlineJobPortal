package com.onlinejob.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.onlinejob.Entities.JobDetails;
import com.onlinejob.Entities.JobSeeker;
import com.onlinejob.utils.HibernateUtil;

public class JobDetailsDAO {

    private static JobDetailsDAO jobDetailsDAO = null;

    public static JobDetailsDAO getJobDetailsDAO() {
        if (jobDetailsDAO == null) {
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
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        }

    }

    public List<JobDetails> getJobDetails() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<JobDetails> query = session.createQuery("from JobDetails", JobDetails.class);
        List<JobDetails> list = query.list();
        return list;
    }

    public JobDetails getJobWithId(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<JobDetails> query = session.createQuery(" from JobDetails where id = :id ", JobDetails.class);
        query.setParameter("id", id);
        JobDetails jobDetails = query.uniqueResult();
        System.out.println(jobDetails);
        return jobDetails;
    }

    public void applyToJob(long id, long jobSeekerId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            JobSeeker jobSeeker = session.get(JobSeeker.class, jobSeekerId);
            JobDetails details = getJobWithId(id);
            jobSeeker.getAppliedJobs().add(details);
            details.getAppliedSeekers().add(jobSeeker);
            session.beginTransaction();
            session.persist(jobSeeker);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("----------------------------------------------------");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------");
        }
    }
    public JobSeeker getJobSeekerWithJobDetails(long jobSeekerId) {
        var session = HibernateUtil.getSessionFactory().openSession();
        Query<JobSeeker> query = session.createQuery("SELECT js FROM JobSeeker js LEFT JOIN FETCH js.appliedJobs WHERE js.id = :id" , JobSeeker.class);
        query.setParameter("id", jobSeekerId);
        JobSeeker jobSeeker = query.uniqueResult();
        return jobSeeker;
    }
}
