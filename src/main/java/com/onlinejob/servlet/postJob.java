package com.onlinejob.servlet;

import java.io.IOException;

import com.onlinejob.Entities.Skill;

import com.onlinejob.Entities.Employer;
import com.onlinejob.Entities.JobDetails;
import com.onlinejob.Entities.User;
import com.onlinejob.Entities.Enums.JobType;

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
        Employer user = (Employer) req.getAttribute("user");
        JobDetails jobDetails = new JobDetails();
        jobDetails.setCompanyName(user.getCompanyName());
        jobDetails.setJobRole(jobRole);
        jobDetails.setJobDescription(jobDescription);
        jobDetails.setSalary(Long.parseLong(salary));
        jobDetails.setJobType(jobType == "FULL_TIME" ? JobType.FULL_TIME : jobType == "PART_TIME" ? JobType.PART_TIME : JobType.INTERNSHIP );
        jobDetails.setLocation(location);
        for(String skill : skills) {
            Skill skillObj = new Skill(); 
            skillObj.setSkillName(skill);
            jobDetails.getSkills().add(skillObj)
        }
    }
}
