package com.onlinejob.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    public void doPost(HttpServletRequest req , HttpServletResponse res)  {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            res.getWriter().println(username + " : " + password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
} 