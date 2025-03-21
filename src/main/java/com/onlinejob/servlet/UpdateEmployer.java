package com.onlinejob.servlet;

import java.io.IOException;

import com.onlinejob.Entities.Employer;
import com.onlinejob.services.EmployerDAO;
import com.onlinejob.utils.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Employer/updateEmployer")
public class UpdateEmployer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Employer emp = (Employer) session.getAttribute("user");

        if(emp != null){ 
            String companyName = req.getParameter("companyName");
            String name = req.getParameter("name");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String phonenumber = req.getParameter("phonenumber");
            String password = req.getParameter("password");
            
            if(password != null && !password.isBlank()){
                password = PasswordUtil.getPasswordUtil().hashPassword(password);
                emp.setPassword(password);
            }
            if(companyName != null && emp.getCompanyName() != companyName){
                emp.setCompanyName(companyName);
            }
            if(name != null && emp.getName() != name) {
                emp.setName(name);
            }
            if(username != null && emp.getUsername() != username){
                emp.setUsername(username);
            }
            if(email != null && emp.getEmail() != email){
                emp.setEmail(email);
            }
            if(phonenumber != null && emp.getPhoneNumber() != phonenumber) {
                emp.setPhoneNumber(phonenumber);
            }

            EmployerDAO employerDAO = EmployerDAO.getEmployerDAO();
            try{
                employerDAO.updateUser(emp);
            }
            catch(Exception e){
                System.out.println(e.getLocalizedMessage());
                resp.sendRedirect("employer-dashboard.jsp?success=false&&message=Error Occured in updating");
            }
            resp.sendRedirect("employer-dashboard.jsp?success=true");
        }
        else {
            resp.sendRedirect("login.jsp");
        }
    }

}
