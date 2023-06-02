package com.sportsinventory.DAO;

import com.sportsinventory.DTO.ItemDTO;
import Database.JavaJDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class ItemDAO {

    Connection conn = null;
    PreparedStatement prepStatement = null;
    PreparedStatement prepStatement2 = null;
    Statement statement = null;
    Statement statement2 = null;
    ResultSet resultSet = null;

    public ItemDAO() {
        try {
            conn = new JavaJDBC().getConn();
            statement = conn.createStatement();
            statement2 = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getItems() {
        try {
            String query = "SELECT * FROM items";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Methods to add a new item
    public void addItemDAO(ItemDTO itemDTO) {
        try {
            String query = "SELECT * FROM items WHERE name='"
                    + itemDTO.getItemName()
                    + "' AND `condition`='"
                    + itemDTO.getCondition()
                    + "' AND `quantity`='"
                    + itemDTO.getQuantity()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                JOptionPane.showMessageDialog(null, "Item has already been added.");
            else
                addFunction(itemDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addFunction(ItemDTO itemDTO) {
        try {
            String query = "INSERT INTO items VALUES(null,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, itemDTO.getItemName());
            prepStatement.setString(2, itemDTO.getCondition());
            prepStatement.setInt(3, itemDTO.getQuantity());

            prepStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editItemDAO(ItemDTO itemDTO) {
        try {
            String query = "UPDATE items SET name=?,`condition`=?,quantity=? WHERE itemID=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, itemDTO.getItemName());
            prepStatement.setString(2, itemDTO.getCondition());
            prepStatement.setInt(3, itemDTO.getQuantity());

            prepStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void deleteItemDAO(String code) {
        try {
            String query = "DELETE FROM items WHERE itemID=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, code);

            prepStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Item has been removed.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet getQueryResult() {
        try {
            String query = "SELECT itemID,name,`condition`,quantity FROM items ORDER BY name";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getItemSearch(String text) {
        try {
            String query = "SELECT itemID,name,`condition` FROM items " +
                            "WHERE itemID LIKE '%"+text+"%' OR name LIKE '%"+text+
                            "%' OR `condition` LIKE '%"+text+"%'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getItemName(String itemId) {
        try {
            String query = "SELECT name FROM items WHERE itemID='" +itemId+ "'";
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
