package com.onlinejob.servlet.AuthServlets;

import java.io.IOException;

import com.onlinejob.Entities.Employer;
import com.onlinejob.Entities.JobSeeker;
import com.onlinejob.Entities.SuperAdmin;
import com.onlinejob.Entities.User;
import com.onlinejob.Entities.Enums.Role;
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
        String enteredRole = req.getParameter("role");
        System.out.println(enteredRole);
        role = "EMPLOYEE".equals(enteredRole) ? Role.JOBSEEKER : Role.EMPLOYER;
        // role = Role.SUPERADMIN;
        pass = PasswordUtil.getPasswordUtil().hashPassword(pass);
        User user = null;
        if(role == Role.EMPLOYER){
            user = new Employer();
        }
        else if(role == Role.JOBSEEKER) {
            user = new JobSeeker();
        }
        else {
            user = new SuperAdmin();
            
        }
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(pass);

        try{
            System.out.println(user);
           boolean inserted = AuthHandler.getAuthHandler().putUser(user);
            
           if(inserted) {
            res.sendRedirect("login.jsp?status=success");
           }
           else{
            res.sendRedirect("login.jsp?status=error");
           }

        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
            res.sendRedirect("error.jsp");
        }
    }
}
