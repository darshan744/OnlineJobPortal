package com.onlinejob.servlet;

import java.io.IOException;
import java.util.List;

import com.onlinejob.Entities.JobDetails;
import com.onlinejob.services.JobDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Employer/Home")
public class EmployerHome extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobDetailsDAO jobDetailsDAO = JobDetailsDAO.getJobDetailsDAO();
        List<JobDetails> list = jobDetailsDAO.getJobDetails();
        req.setAttribute("jobs", list);
        resp.sendRedirect("Home.jsp");
    }

}
