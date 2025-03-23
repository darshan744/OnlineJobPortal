package com.onlinejob.servlet.JobSeekerServlets;

import java.io.IOException;

import com.onlinejob.Entities.JobSeeker;
import com.onlinejob.services.JobDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/JobSeekers/Profile")
public class JobSeekerProfile  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobSeeker jobSeeker = (JobSeeker) req.getSession().getAttribute("user");

       JobDetailsDAO jDao = JobDetailsDAO.getJobDetailsDAO();
       jobSeeker = jDao.getJobSeekerWithJobDetails(jobSeeker.getId());
       if(jobSeeker == null){ 
            resp.sendRedirect( req.getContextPath() + "/");
       }
       req.setAttribute("appliedJobs", jobSeeker.getAppliedJobs());
       req.getRequestDispatcher("job-seeker-dashboard.jsp").forward(req, resp);
    }
}
