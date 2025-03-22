package com.onlinejob.filters;

import java.io.IOException;


import com.onlinejob.Entities.User;
import com.onlinejob.Entities.Enums.Role;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/Employer/*")
public class EmployerAccessFilter extends HttpFilter{
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        Role role = user.getRole();
        if(role == Role.EMPLOYER) {
            chain.doFilter(req, res);
            return;
        }
        if(session != null) {
            session.invalidate();
        }
        res.sendRedirect("/");
    }
}
