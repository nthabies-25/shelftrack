CREATE TABLE IF NOT EXISTS genres (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      name TEXT NOT NULL UNIQUE,
      description TEXT
);

CREATE TABLE IF NOT EXISTS books (
     id INTEGER PRIMARY KEY AUTOINCREMENT,
     title TEXT NOT NULL,
     author TEXT NOT NULL,
     isbn TEXT NOT NULL UNIQUE,
     genre_id INTEGER NOT NULL,
     publication_year INTEGER NOT NULL,

    FOREIGN KEY (genre_id)
        REFERENCES genres(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
    );