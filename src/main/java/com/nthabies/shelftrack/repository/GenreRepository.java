
package com.nthabies.shelftrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nthabies.shelftrack.model.Genre;

public class GenreRepository {

    private final Connection connection;

    public GenreRepository(Connection connection) {
        this.connection = connection;
    }

    public void addGenre(Genre genre) throws SQLException {

        String sql = """
                INSERT INTO genres (name, description)
                VALUES (?, ?)
                """;

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, genre.getName());
            statement.setString(2, genre.getDescription());

            statement.executeUpdate();
        }
    }
    public List<Genre> findAll() throws SQLException {

        List<Genre> genres = new ArrayList<>();

        String sql = """
            SELECT id, name, description
            FROM genres
            ORDER BY name
            """;

        try (PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                Genre genre = new Genre(id, name, description);

                genres.add(genre);
            }
        }

        return genres;
    }
}
