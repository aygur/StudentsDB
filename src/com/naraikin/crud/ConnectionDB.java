package com.naraikin.crud;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by dmitrii on 16.02.17.
 */
public final class ConnectionDB {
        public Connection conn;
        public static ConnectionDB db;
        private ConnectionDB() {
            String url= "jdbc:postgresql://localhost:5432/";
            String dbName = "Students";
            String driver = "org.postgresql.Driver";
            String userName = "postgres";
            String password = "postgres";
            try {
                Class.forName(driver).newInstance();
                this.conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            }
            catch (Exception sqle) {
                sqle.printStackTrace();
            }
        }
        public static ConnectionDB getDbCon() {
            if ( db == null ) {
                db = new ConnectionDB();
            }
            return db;

        }
}
