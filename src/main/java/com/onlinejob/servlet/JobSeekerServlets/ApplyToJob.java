package com.onlinejob.servlet.JobSeekerServlets;

import java.io.IOException;

import com.onlinejob.Entities.JobSeeker;
import com.onlinejob.services.JobDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/JobSeekers/applyToJob")
public class ApplyToJob extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobId = req.getParameter("jobId");

        JobDetailsDAO jobDao = JobDetailsDAO.getJobDetailsDAO();
        HttpSession session = req.getSession();
        JobSeeker jobSeeker = (JobSeeker) session.getAttribute("user");
        if(jobSeeker == null){
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        try{
            jobDao.applyToJob(Long.parseLong(jobId), jobSeeker.getId());
            resp.sendRedirect("JobInfo.jsp?status=success&&message=Successfully Applied");
        }
        catch(Exception e){ 
            System.out.println(e.getMessage());
            resp.sendRedirect("JobInfo.jsp?status=false&&message=Successfully Applied");
        }

    }
}
