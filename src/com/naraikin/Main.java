package com.naraikin;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        //Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/Students";
        String login = "postgres";
        String password = "postgres";
        insertDb(url, login, password);
        selectDb(url, login, password);



    }

    public static void insertDb(String url, String login, String password) {
        try( Connection conn = DriverManager.getConnection(url, login, password)){
            String sqlQ = "INSERT INTO main.student (id, name, bithdate, sex, group_id) " +
                    "Values (?,?,?,?,?)";
            PreparedStatement preparedStatement
                    = conn.prepareStatement(sqlQ);
            preparedStatement.setInt(1, 5 );
            preparedStatement.setString(2, "Arnold");
            preparedStatement.setDate(3, new Date(1978, 8, 8 ));
            preparedStatement.setString(4, "m");
            preparedStatement.setInt(5, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void selectDb(String url, String login, String password) {
        try( Connection conn = DriverManager.getConnection(url, login, password)){
            Statement query = conn.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM main.student");

            while ( resultSet.next()){
                System.out.println(resultSet.getString("name"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
