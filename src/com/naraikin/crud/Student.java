package com.naraikin.crud;

import java.sql.*;

/**
 * Created by dmitrii on 16.02.17.
 */
public class Student {

    public static void create(String name, String birthday, String sex, int group_id) {

         try{
            String sqlQ = "INSERT INTO main.student ( name, birthday, sex, group_id) " +
                    "Values (?,?,?,?)";
            PreparedStatement preparedStatement
                    =  ConnectionDB.getDbCon().conn.prepareStatement(sqlQ);
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, java.sql.Date.valueOf(birthday));
            preparedStatement.setString(3, sex);
            preparedStatement.setInt(4, group_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void delete(String name, String birthday, String sex, int group_id) {

        try{
            String sqlQ = "DELETE FROM main.student WHERE " +
                    "name=? AND birthday=? AND sex=? AND group_id=?";
            PreparedStatement preparedStatement
                    =  ConnectionDB.getDbCon().conn.prepareStatement(sqlQ);
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, java.sql.Date.valueOf(birthday));
            preparedStatement.setString(3, sex);
            preparedStatement.setInt(4, group_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateName(String newName, String oldName) {
        try{
            String sqlQ = "UPDATE main.student " +
                    "SET name =?" +
                    "WHERE name=?" ;
            PreparedStatement preparedStatement
                    =  ConnectionDB.getDbCon().conn.prepareStatement(sqlQ);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, oldName);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void getAll() {
        try{
            Statement query = ConnectionDB.getDbCon().conn.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM main.student");

            while ( resultSet.next()){
                System.out.println(resultSet.getString("name")
                        + " " +resultSet.getString("birthday"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }




}
