package com.sportsinventory.DAO;

import com.sportsinventory.DTO.AdminDTO;
import Database.JavaJDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class AdminDAO {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    // Constructor method
    public AdminDAO() {
        try {
            conn = new JavaJDBC().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addAdminDAO(AdminDTO adminDTO, String adminType) {
        try {
            String query = "SELECT * FROM admins WHERE username='" + adminDTO.getUsername() + "'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
                JOptionPane.showMessageDialog(null, "Admin already exists");
            else
                addFunction(adminDTO, adminType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void addFunction(AdminDTO adminDTO, String adminType) {
        try {
            String query = "INSERT INTO admins (adminID,username,name,email,password,regDate) " +
                    "VALUES(?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, adminDTO.getAdminID());
            prepStatement.setString(2, adminDTO.getUsername());
            prepStatement.setString(3, adminDTO.getFullName());
            prepStatement.setString(4, adminDTO.getEmail());
            prepStatement.setString(5, adminDTO.getPassword());
            prepStatement.setString(6, adminDTO.getRegDate());
            prepStatement.executeUpdate();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void editAdminDAO(AdminDTO adminDTO) {

        try {
            String query = "UPDATE admins SET name=?, email=?, password=? WHERE username=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, adminDTO.getFullName());
            prepStatement.setString(2, adminDTO.getEmail());
            prepStatement.setString(3, adminDTO.getPassword());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated Successfully.");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void deleteAdminDAO(String adminid) {
        try {
            String query = "DELETE FROM admins WHERE username=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, adminid);
            prepStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet getQueryResult() {
        try {
            String query = "SELECT * FROM admins";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAdminDAO(String username) {
        try {
            String query = "SELECT * FROM admins WHERE username='" +username+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getPassDAO(String username, String password){
        try {
            String query = "SELECT password FROM admins WHERE username='"
                    +username
                    + "' AND password='"
                    +password
                    +"'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public void changePass(String username, String password) {
        try {
            String query = "UPDATE admins SET password=? WHERE username='" +username+ "'";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, password);
            prepStatement.setString(2, username);
            prepStatement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<>();
        int colCount = metaData.getColumnCount();

        for (int col=1; col <= colCount; col++)
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));

        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<>();
            for (int col=1; col<=colCount; col++) vector.add(resultSet.getObject(col));
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

}
