package com.onlinejob.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.onlinejob.Entities.Employer;
import com.onlinejob.Entities.JobDetails;
import com.onlinejob.Entities.Enums.JobType;
import com.onlinejob.services.JobDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Employer/jobposting")
public class postJob extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //parameteres
        String jobRole = req.getParameter("jobRole");
        String jobDescription = req.getParameter("jobDescription");
        String salary = req.getParameter("salary");
        String date = req.getParameter("lastDateToApply");
        String skillString = req.getParameter("skills");
        String[] skills = skillString.split(",");
        String jobType = req.getParameter("jobType");
        String location = req.getParameter("location");
        //setting the values
        JobDetails jobDetails = new JobDetails();
        jobDetails.setJobRole(jobRole);
        jobDetails.setJobDescription(jobDescription);
        jobDetails.setSalary(Long.parseLong(salary));
        //job type
        jobDetails.setJobType(jobType.equals("FULL_TIME") ? JobType.FULL_TIME : jobType.equals("PART_TIME") ? JobType.PART_TIME : JobType.INTERNSHIP );
        jobDetails.setLocation(location);
        
        List<String> skillList = Arrays.asList(skills);
        LocalDate ld = LocalDate.parse(date);
        jobDetails.setLastDateToApply(ld);
        jobDetails.setSkills(skillList);

        HttpSession session = req.getSession();
        Employer emp = (Employer) session.getAttribute("user");
        jobDetails.setCompanyName(emp.getCompanyName());
        jobDetails.setEmployer(emp);
        JobDetailsDAO jobDetailsDAO = JobDetailsDAO.getJobDetailsDAO();
        try {
            jobDetailsDAO.putJobDetails(jobDetails);
            res.sendRedirect("postjob.jsp?status=true&&message=Job Details Posted Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            res.sendRedirect("postjob.jsp?status=false&&message=Server Error");    
        }

    }   
}
