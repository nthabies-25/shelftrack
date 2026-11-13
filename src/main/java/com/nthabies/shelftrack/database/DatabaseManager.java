package com.nthabies.shelftrack.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager implements AutoCloseable {

    private static final String DATABASE_URL = "jdbc:sqlite:shelftrack.db";

    private Connection connection;

    public DatabaseManager() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL);

        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void shutdown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public void close() throws SQLException {
        shutdown();
    }
}