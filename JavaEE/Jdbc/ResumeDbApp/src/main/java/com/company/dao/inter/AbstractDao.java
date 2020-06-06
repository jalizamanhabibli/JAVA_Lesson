package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/resume?serverTimeZone=UTC&useUnicode=yes&characterEncoding=UTF-8";
            String user = "root";
            String pass = "527618349";
            Connection connect = DriverManager.getConnection(url, user, pass);
            return connect;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
