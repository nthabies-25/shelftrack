
package com.nthabies.shelftrack;

import com.nthabies.shelftrack.database.DatabaseInitializer;
import com.nthabies.shelftrack.database.DatabaseManager;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try (DatabaseManager databaseManager = new DatabaseManager()) {

            DatabaseInitializer initializer =
                    new DatabaseInitializer(databaseManager.getConnection());

            initializer.initialize();

            System.out.println("ShelfTrack database initialised successfully.");

        } catch (SQLException | IOException e) {
            System.err.println("Failed to initialise ShelfTrack database.");
            e.printStackTrace();
        }
    }
}

