package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao {

    private static EntityManagerFactory managerFactory;
    
    public Connection connect() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/resume?serverTimeZone=UTC&useUnicode=yes&characterEncoding=UTF-8";
            String user = "root";
            String pass = "527618349";
            connect = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connect;
    }
    
    public EntityManager em(){
        if(managerFactory==null){
            managerFactory=Persistence.createEntityManagerFactory("resumeAppPu");
        }
        EntityManager manager=managerFactory.createEntityManager();
        return manager;
    }
    public void closeEmf(){
        managerFactory.close();
    }
}
