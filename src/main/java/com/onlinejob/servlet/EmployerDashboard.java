package com.onlinejob.servlet;

import java.io.IOException;

import com.onlinejob.Entities.Employer;
import com.onlinejob.services.EmployerDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Employer/EmployerDashboard")
public class EmployerDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployerDAO empDao = EmployerDAO.getEmployerDAO();
        HttpSession session = req.getSession();
        Employer emp = (Employer) session.getAttribute("user");
        System.out.println("------------------------------------------");
        System.out.println(emp);
        System.out.println(emp.getId());
        emp = empDao.getEmployerWithId(emp.getId());
        System.out.println(emp);
        System.out.println("------------------------------------------");
        RequestDispatcher rd = req.getRequestDispatcher("employer-dashboard.jsp");
        req.setAttribute("employer", emp);
        req.setAttribute("postedJobs", emp.getPostedJobs());
        rd.forward(req, resp);
    }
}
