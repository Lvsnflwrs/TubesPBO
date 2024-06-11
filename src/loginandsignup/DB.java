package loginandsignup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    static final String url = "jdbc:MySQL://localhost:3306/java_users_database";
    static final String user = "root";
    static final String pass = "";
    static Connection conn;
    public static Statement stmt;
    public ResultSet rs;
    
    public void connect(){
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void query (String sql){
        try {
            stmt.executeUpdate(sql);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet view (String sql){
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    } 
}
