package com.nthabies.shelftrack.repository;

import com.nthabies.shelftrack.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class BookRepository {

    private final Connection connection;

    public BookRepository(Connection connection) {
        this.connection = connection;
    }

    public void addBook(Book book) throws SQLException {

        String sql = """
                INSERT INTO books
                (title, author, isbn, genre_id, publication_year)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setInt(4, book.getGenreId());
            statement.setInt(5, book.getPublicationYear());

            statement.executeUpdate();
        }
    }

    public List<Book> findAll() throws SQLException {

        List<Book> books = new ArrayList<>();

        String sql = """
            SELECT id, title, author, isbn, genre_id, publication_year
            FROM books
            ORDER BY title
            """;

        try (PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isbn = resultSet.getString("isbn");
                int genreId = resultSet.getInt("genre_id");
                int publicationYear =
                        resultSet.getInt("publication_year");

                Book book = new Book(
                        id, title, author, isbn, genreId, publicationYear
                );

                books.add(book);
            }
        }
        return books;
    }

    public Book findById(int id) throws SQLException {

        String sql = """
            SELECT id, title, author, isbn, genre_id, publication_year
            FROM books
            WHERE id = ?
            """;

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return new Book(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("isbn"),
                            resultSet.getInt("genre_id"),
                            resultSet.getInt("publication_year")
                    );
                }
            }
        }
        return null;
    }

    public List<Book> search(String searchTerm) throws SQLException {

        List<Book> books = new ArrayList<>();

        String sql = """
            SELECT id, title, author, isbn, genre_id, publication_year
            FROM books
            WHERE title LIKE ?
               OR author LIKE ?
               OR isbn LIKE ?
            ORDER BY title
            """;

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            String searchPattern = "%" + searchTerm + "%";

            statement.setString(1, searchPattern);
            statement.setString(2, searchPattern);
            statement.setString(3, searchPattern);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    Book book = new Book(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("isbn"),
                            resultSet.getInt("genre_id"),
                            resultSet.getInt("publication_year")
                    );

                    books.add(book);
                }
            }
        }
        return books;
    }

}