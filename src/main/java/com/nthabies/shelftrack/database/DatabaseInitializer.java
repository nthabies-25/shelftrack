
package com.nthabies.shelftrack.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private final Connection connection;

    public DatabaseInitializer(Connection connection) {
        this.connection = connection;
    }

    public void initialize() throws SQLException, IOException {

        InputStream inputStream =
                getClass().getResourceAsStream("/sql/schema.sql");

        if (inputStream == null) {
            throw new FileNotFoundException(
                    "Could not find sql/schema.sql"
            );
        }

        try (inputStream) {

            String schema = new String(
                    inputStream.readAllBytes(),
                    StandardCharsets.UTF_8
            );

            try (Statement statement = connection.createStatement()) {

                String[] sqlStatements = schema.split(";");

                for (String sql : sqlStatements) {

                    if (!sql.isBlank()) {
                        statement.execute(sql);
                    }
                }
            }
        }
    }
}
