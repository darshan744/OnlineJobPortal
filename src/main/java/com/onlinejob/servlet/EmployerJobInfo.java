package com.onlinejob.servlet;

import java.io.IOException;

import com.onlinejob.Entities.JobDetails;
import com.onlinejob.services.JobDetailsDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Employer/JobInfo")
public class EmployerJobInfo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobId = req.getParameter("jobId");
        JobDetailsDAO jobDao = JobDetailsDAO.getJobDetailsDAO();
        JobDetails job = jobDao.getJobWithId(Long.parseLong(jobId));
        if(job == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("employer-joblists.jsp");
        req.setAttribute("jobDetails", job);
        rd.forward(req, resp);
    }
}
