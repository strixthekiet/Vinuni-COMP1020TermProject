package com.sportsinventory.DAO;

import com.sportsinventory.DTO.ItemDTO;
import Database.JavaJDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class BookingDAO {

    Connection conn = null;
    PreparedStatement prepStatement = null;
    PreparedStatement prepStatement2 = null;
    Statement statement = null;
    Statement statement2 = null;
    ResultSet resultSet = null;

    public BookingDAO() {
        try {
            conn = new JavaJDBC().getConn();
            statement = conn.createStatement();
            statement2 = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addBookingDAO(int BookingID, int userID, int itemID, String borrowDate, String borrowReturn, String status, int quantity) {
        try {
            String query = "INSERT INTO bookings VALUES(?,?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, BookingID);
            prepStatement.setInt(2, userID);
            prepStatement.setInt(3, itemID);
            prepStatement.setInt(4, quantity);
            prepStatement.setString(5, borrowDate);
            prepStatement.setString(6, borrowReturn);
            prepStatement.setString(7, status);

            prepStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteBookingDAO(int id){
        try {
            String query = "DELETE FROM bookings WHERE bookingid=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateQuantity(int quantity, int itemID){
        try {
            String query = "Update bookings set quantity=" + quantity + " Where itemID=" + itemID;
            prepStatement = conn.prepareStatement(query);
            prepStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    // Book table data set retrieval
    public ResultSet getBookings() {
        try {
            String query = "SELECT bookingid, bookings.itemid,name,quantity " +
                    "FROM bookings INNER JOIN items " +
                    "ON items.itemid=bookings.itemid ORDER BY borrowDate;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getBookingsInfo() {
        try {
            String query = """
                    SELECT bookingid,bookings.itemid,name,bookings.borrowDate,bookings.borrowReturn,
                    bookings.quantity, users.userName
                    FROM bookings
                    INNER JOIN items
                        ON bookings.itemid=items.itemid
                    INNER JOIN users
                        ON bookings.userid=users.userID;
                    """;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getBookingsTable() {
        try {
            String query = "Select * from bookings";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getBookingsRowInfo(int requireID) {
        try {
            String query = "Select * from bookings where bookingID=" + requireID;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getBookingsRowItemID(int requireID) {
        try {
            String query = "Select * from bookings where itemID=" + requireID;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getLastRow() {
        try {
            String query = "Select * from bookings order by bookingID DESC LIMIT 1";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return resultSet;
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
