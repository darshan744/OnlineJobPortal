package com.onlinejob.servlet;

import java.io.IOException;

import com.onlinejob.Entities.Role;
import com.onlinejob.Entities.User;
import com.onlinejob.services.AuthHandler;
import com.onlinejob.utils.PasswordUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
        String name;
        String email;
        Role role;
        String username;
        String pass;
        name = req.getParameter("name");
        username = req.getParameter("username");
        pass = req.getParameter("password");
        email = req.getParameter("email");
        role = Role.SUPERADMIN;
        pass = PasswordUtil.getPasswordUtil().hashPassword(pass);
        
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(pass);
        user.setRole(role);

        try{
           boolean inserted = AuthHandler.getAuthHandler().putUser(user);

           if(inserted) {
            res.sendRedirect("login.jsp?status=success");
           }
           else{
            res.sendRedirect("login.jsp?status=error");
           }

        }
        catch(Exception e) {
            res.sendRedirect("error.jsp");
        }
    }
}
