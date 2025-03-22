package com.onlinejob.servlet.AuthServlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlinejob.Entities.User;
import com.onlinejob.Entities.Enums.Role;
import com.onlinejob.services.AuthHandler;
import com.onlinejob.utils.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = AuthHandler.getAuthHandler().getUser(username);
        
        if (user == null) {
            try {
                res.getWriter().println("No user found");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        boolean isPasswordValid = PasswordUtil.getPasswordUtil().comparePassword(password, user.getPassword());

        try {
            HttpSession session = req.getSession();
            if(isPasswordValid) {
                session.setAttribute("user", user);
                if(user.getRole() == Role.JOBSEEKER){
                    res.sendRedirect("JobSeekers/Home.jsp");
                }
                else if(user.getRole() == Role.EMPLOYER) {
                    res.sendRedirect("Employer/Home");
                }
                else if(user.getRole() == Role.SUPERADMIN) {
                    res.sendRedirect("SuperAdmin/Home.jsp");
                }
                else {
                    res.sendRedirect("login.jsp");
                }
            }
            else {
                req.getRequestDispatcher("login.jsp?status=false&message=InvalidPassword");
            }

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        
    }
}