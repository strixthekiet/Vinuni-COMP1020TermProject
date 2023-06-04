package com.sportsinventory.DAO;

import com.sportsinventory.DTO.UserDTO;
import Database.JavaJDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class UserDAO {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    // Constructor method
    public UserDAO() {
        try {
            conn = new JavaJDBC().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addUserDAO(UserDTO userDTO) {
        try {
            String query = "SELECT * FROM users WHERE userName='" + userDTO.getUsername() + "'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
                JOptionPane.showMessageDialog(null, "User already exists");
            else
                addFunction(userDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void addFunction(UserDTO userDTO) {
        try {
            String userid = null;
            String password = null;
            String oldUsername = null;
            String resQuery = "SELECT * FROM users";
            resultSet = statement.executeQuery(resQuery);

            String query = "INSERT INTO users (userID,userName,fullname,email,password,regDate,cohort,major) " +
                    "VALUES(?,?,?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, userDTO.getUserID());
            prepStatement.setString(2, userDTO.getUsername());
            prepStatement.setString(3, userDTO.getFullName());
            prepStatement.setString(4, userDTO.getEmail());
            prepStatement.setString(5, userDTO.getPassword());
            prepStatement.setString(6, userDTO.getRegDate());
            prepStatement.setString(7, userDTO.getCohort());
            prepStatement.setString(8, userDTO.getMajor());
            prepStatement.executeUpdate();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void editUserDAO(UserDTO userDTO) {

        try {
            String query = "UPDATE users SET name=?, email=?, password=? WHERE userName=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, userDTO.getFullName());
            prepStatement.setString(2, userDTO.getEmail());
            prepStatement.setString(3, userDTO.getPassword());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated Successfully.");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void deleteUserDAO(String userid) {
        try {
            String query = "DELETE FROM users WHERE userName=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, userid);
            prepStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet getQueryResult() {
        try {
            String query = "SELECT * FROM users";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getUserDAO(String userName) {
        try {
            String query = "SELECT * FROM users WHERE userName='" +userName+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getUserInfo(int ID) {
        try {
            String query = "SELECT * FROM users WHERE userID=" +ID;
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getPassDAO(String userName, String password){
        try {
            String query = "SELECT password FROM users WHERE userName='"
                    +userName
                    + "' AND password='"
                    +password
                    +"'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public void changePass(String userName, String password) {
        try {
            String query = "UPDATE users SET password=? WHERE userName='" +userName+ "'";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, password);
            prepStatement.setString(2, userName);
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
