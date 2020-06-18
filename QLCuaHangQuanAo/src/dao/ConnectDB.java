/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ĐỨC DUY
 */
public class ConnectDB {
    private final static String classForname="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String url="jdbc:sqlserver://localhost:1433;databaseName=QLCuaHang";
    private final static String username="duy";
    private final static String pass="12345";
     public Connection getConnection() {
        
        try {
            Class.forName(classForname);
            Connection conn=DriverManager.getConnection(url,username,pass);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }
    public static void main(String[] args) {
        ConnectDB connectToSQL=new ConnectDB();
        connectToSQL.getConnection();
               
    }
}
