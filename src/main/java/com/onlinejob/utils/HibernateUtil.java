package com.onlinejob.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.onlinejob.Entities.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory != null) {
            return sessionFactory;
        }
        Properties props = new Properties();
        //sql driver
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        // sql db link
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/onlinejobportal");
        // sql user name
        props.put(Environment.USER , "user");
        //sql user pass
        props.put(Environment.PASS, "Darshan@123");
        //dialect
        props.put(Environment.DIALECT , "org.hibernate.dialect.MySQL5Dialect");
        //whether to show query or not
        props.put(Environment.SHOW_SQL, "true");
        //if set to create then every restart the data will be deleted
        props.put(Environment.HBM2DDL_AUTO , "update");

        //configuration object
        Configuration con = new Configuration();
        //adding the props to configuration object of hibernate
        con.setProperties(props);
        //add the entity class;
        con.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                    .applySettings(con.getProperties()).build();

        sessionFactory = con.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
