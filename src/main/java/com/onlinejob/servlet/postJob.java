package com.onlinejob.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Employer/jobposting")
public class postJob extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jobRole = req.getParameter("jobRole");
        String jobDescription = req.getParameter("jobDescription");
        String salary = req.getParameter("salary");
        String date = req.getParameter("lastDateToApply");
        String skillString = req.getParameter("skills");
        String[] skills = skillString.split(",");
        String jobType = req.getParameter("jobType");
        String location = req.getParameter("location");

        

    }
}
