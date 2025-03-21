package com.onlinejob.services;
public class JobSeekerDAO {
    public static JobSeekerDAO jobSeekerDAO = null;

    public static JobSeekerDAO getJobSeekerDAO(){
        if (jobSeekerDAO != null) {
            return jobSeekerDAO;
        }
        jobSeekerDAO = new JobSeekerDAO();
        return jobSeekerDAO;
    }
}
