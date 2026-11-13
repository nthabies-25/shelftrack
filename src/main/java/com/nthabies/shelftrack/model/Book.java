package com.nthabies.shelftrack.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int genreId;
    private int publicationYear;

    public Book(int id, String title, String author, String isbn,
                int genreId, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genreId = genreId;
        this.publicationYear = publicationYear;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;

    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getGenreId() {
        return genreId;
    }
    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genreId=" + genreId +
                ", publicationYear=" + publicationYear +
                '}';
    }
}