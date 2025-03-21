package com.onlinejob.services;


public class EmployerDAO {

    public static EmployerDAO employerDAO = null;

    public static EmployerDAO getEmployerDAO(){
        if(employerDAO != null){
            return employerDAO;
        }
        employerDAO = new EmployerDAO();
        return employerDAO;
    }

    


}
