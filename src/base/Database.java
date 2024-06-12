/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author francisca isabella
 */
public class Database {
    static final String url = "jdbc:mysql://localhost:3306/tubes";
    static final String user = "root";
    static final String pass = "";
    static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;
    
    public void connect() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } 
    }
    
    public void query(String sql){
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }   
    }
    
    public ResultSet view(String sql){
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return rs;
    }
    
    public void disconnect(){
        try{
            conn.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        if (conn == null || conn.isClosed()) {
            throw new SQLException("Connection is not established or is closed.");
        }
        return conn.prepareStatement(sql);
    }
}
