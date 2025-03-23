package com.onlinejob.servlet.JobSeekerServlets;

import java.io.IOException;

import com.onlinejob.Entities.JobDetails;
import com.onlinejob.services.JobDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/JobSeekers/JobInfo")
public class JobInfo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobId = req.getParameter("jobId");
        JobDetailsDAO dao = JobDetailsDAO.getJobDetailsDAO();
       JobDetails jobDetails = dao.getJobWithId(Long.parseLong(jobId));
       req.setAttribute("jobDetails", jobDetails);
       req.getRequestDispatcher("JobInfo.jsp").forward(req, resp);
    }
}
