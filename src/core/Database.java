package core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Database {
    // singleton design pattern

    private Connection connection = null;
    private final String DB_URL = "jdbc:mysql://@localhost:3306";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "deneme123";


    private Database() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }



}
