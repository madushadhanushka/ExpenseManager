/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.db;

import com.epicsoft.expensemanager.model.Install;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author hp
 */
public class DBConnection {
    
    private static DBConnection dBConnection;
    private Connection connection;
    

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost/ExpenseManager";
    Install install;
    /**
     * @param JDBC_URL
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private DBConnection() throws ClassNotFoundException, SQLException{
        
        try{
 
            FileInputStream fin = new FileInputStream("data.o");
            ObjectInputStream ois = new ObjectInputStream(fin);
            install = (Install) ois.readObject();
            ois.close();
 
	}catch(Exception ex){
		   ex.printStackTrace();
	}
        DB_URL="jdbc:mysql://".concat(install.getMysqlHost()).concat("/").concat(install.getMysqlDB());
        Class.forName(DRIVER);
        
        connection = DriverManager.getConnection(DB_URL, install.getMysqlUsername(), install.getMysqlPassword());
    }
    
    /**
     * 
     * @param JDBC_URL
     * @param user
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
    
    /**
     * 
     * @return 
     */
    public Connection getConnection(){
        return connection;
    }
}
