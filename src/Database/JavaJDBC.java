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
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String url="jdbc:mysql://localhost:3306/inventoryforsports";
        String UserName="root";
        String password="Hbtchou123";
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
}
