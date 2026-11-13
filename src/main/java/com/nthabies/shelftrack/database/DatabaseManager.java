package com.nthabies.shelftrack.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc.sqlite:shelftrack.db";
    private Connection connection;

    public DatabaseManager() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL);
    }

    public Connection getConnection() {
        return connection;
    }

    public void shutdown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}