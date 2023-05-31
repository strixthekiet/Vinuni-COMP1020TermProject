/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author tbhung
 */
public class JavaJDBC {
    /**
     * $param args the comand line arguments
     */
    
    static Connection connection = null;
    static PreparedStatement pst=null;
    static ResultSet rs=null;
    
    static String url="jdbc:mysql://localhost:3306/inventoryforsports";
    static String UserName="root";
    static String password="Hbtchou123";
    
    public static void main(String[] args) { 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,UserName, password);
            //System.out.println(connection);
            pst=connection.prepareStatement("select * from user");
            rs=pst.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " +
                                   rs.getString(2) + " " +
                                   rs.getString(3));
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JavaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, UserName, password);
            System.out.println("Connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public boolean userLogin(String username, String password) {
        String query = "SELECT * FROM user WHERE userName="
                + "'" + username + "'"
                + " AND password="
                + "'" + password + "'" + ";";
        System.out.println(query);
        try {
            pst=getConn().prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()) return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean adminLogin(String username, String password) {
        String query = "SELECT * FROM admin WHERE adminName="
                + '"' + username + '"'
                + " AND password="
                + '"' + password + '"' + ";";
        
        try {
            pst=getConn().prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()) return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}
