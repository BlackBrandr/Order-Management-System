package core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Database {
    // singleton design pattern

    private static Database instance = null;
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

    public static Connection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Database();
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
        return instance.getConnection();
    }



}
