package com.example.accounting;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "accountingApp";
        String databaseUser = "root";
        String databasePassword = "123456Bn.";
        String url = "jdbc:mysql://localhost:3306/accountingapp" ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
