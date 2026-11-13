# ShelfTrack

**ShelfTrack** is a Java-based library management system designed to help administrators manage a library's book catalogue and organise books by genre.

The project is being developed as a portfolio project to demonstrate Java programming, object-oriented design, relational database management and backend development.

## Technology Stack

- **Java 17** – application development
- **Maven** – dependency and build management
- **Javalin 4.6.4** – lightweight Java web framework
- **SQLite** – relational database
- **JDBC** – database connectivity
- **JUnit 5** – automated testing

## Current Features

### Database
- SQLite database connection and management
- Automatic database schema initialization
- Books and genres tables
- Primary keys and foreign key constraints
- Unique ISBN and genre name constraints

### Book Management
- Add books
- Retrieve all books
- Retrieve a book by ID
- Search books by title, author or ISBN
- Update existing books
- Delete books

### Genre Management
- Genre model and database repository foundation
- Add genres

## Project Structure

```text
shelftrack/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/nthabies/shelftrack/
│   │   │       ├── database/
│   │   │       │   ├── DatabaseManager.java
│   │   │       │   └── DatabaseInitializer.java
│   │   │       ├── model/
│   │   │       │   ├── Book.java
│   │   │       │   └── Genre.java
│   │   │       ├── repository/
│   │   │       │   ├── BookRepository.java
│   │   │       │   └── GenreRepository.java
│   │   │       └── Main.java
│   │   └── resources/
│   │       └── sql/
│   │           └── schema.sql
│   └── test/
├── .gitignore
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK) 17
- Apache Maven
- Git

### Clone the Repository

```bash
git clone https://github.com/nthabies-25/shelftrack.git
cd shelftrack
```

### Build the Project

```bash
mvn clean compile
```

### Initialise the Database

```bash
mvn exec:java -Dexec.mainClass="com.nthabies.shelftrack.Main"
```

The application creates the SQLite database file and initializes the required tables.

A successful initialization displays:

```text
ShelfTrack database initialised successfully.
```

The database file, `shelftrack.db`, is generated locally and is excluded from version control.

## Database Design

ShelfTrack currently uses two relational tables:

**genres**
- `id` – primary key
- `name` – unique genre name
- `description` – optional description

**books**
- `id` – primary key
- `title` – book title
- `author` – author's name
- `isbn` – unique ISBN
- `genre_id` – foreign key referencing `genres.id`
- `publication_year` – year of publication

The database enforces referential integrity between books and genres.

## Development Roadmap

- [x] Maven project setup
- [x] Java domain models
- [x] SQLite database connection
- [x] Database schema initialization
- [x] Book repository CRUD operations
- [x] Book search by title, author and ISBN
- [x] Genre repository foundation
- [ ] Automated repository tests
- [ ] Service layer and business logic
- [ ] REST API endpoints
- [ ] Library member management
- [ ] Book loans and returns
- [ ] User interface
- [ ] Documentation and final project testing

## Author

**Nthabi**

GitHub: [nthabies-25](https://github.com/nthabies-25)

---

*ShelfTrack is an ongoing software development project. Features and documentation will be updated as development progresses.*