/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.main;

import com.epicsoft.expensemanager.controller.DBController;
import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.view.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

/**
 *
 * @author hp
 */
public class Main {
    
    public static void main(String args[]) {
        /*
        DBController dbCon = new DBController();
        try {
            dbCon.createTables();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                System.out.println("No database found");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
                */
        File f = new File("data.o");
        if(f.exists() && !f.isDirectory()) { /* do something */ 
            LoginFrame loginframe = new LoginFrame();
            loginframe.setVisible(true);
        }else{
            Welcome welcome=new Welcome();
            welcome.setVisible(true);
        }

    }
    
}
