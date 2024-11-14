package models;

import java.sql.*;

public class Database {
    private final String username = "root";    // camelCase for instance variables
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/";
    private Statement statement;

    public Database() {
        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(url, username, password); 
            System.out.println("Connected to the database server.");

            statement = connection.createStatement();
            createDatabaseIfNotExists();
      
            statement.execute("USE socialmedia"); // Use the 'socialmedia' database
            createUsersTable();
            createPostsTable();
            createCommentsTable();
            createLikesTable();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void createDatabaseIfNotExists() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS socialmedia;"; // Create database if not exists
        statement.execute(sql);
    }

    private void createUsersTable() throws SQLException {
        String table = "CREATE TABLE IF NOT EXISTS users (\n" +
                       "    ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                       "    FirstName VARCHAR(100) NOT NULL,\n" +
                       "    LastName VARCHAR(100) NOT NULL,\n" +
                       "    EMAIL VARCHAR(255) NOT NULL UNIQUE,\n" +
                       "    password VARCHAR(255) NOT NULL\n" +
                       ");";
        statement.execute(table);
        
    }

    private void createPostsTable() throws SQLException {
        String table = "CREATE TABLE IF NOT EXISTS posts (\n" +
                       "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                       "    UserID INT,\n" +
                       "    Content TEXT NOT NULL,\n" +
                       "    Likes INT DEFAULT 0,\n" +
                       "    CreatedAT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                       "    FOREIGN KEY (UserID) REFERENCES users(id) ON DELETE CASCADE\n" +
                       ");";
        statement.execute(table);
 
    }

    private void createCommentsTable() throws SQLException {
        String table = "CREATE TABLE IF NOT EXISTS comments (\n" +
                       "    ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                       "    PostID INT,\n" +
                       "    UserID INT,\n" +
                       "    Content TEXT NOT NULL,\n" +
                       "    Created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                       "    FOREIGN KEY (PostID) REFERENCES posts(id) ON DELETE CASCADE,\n" +
                       "    FOREIGN KEY (UserID) REFERENCES users(id) ON DELETE CASCADE\n" +
                       ");";
        statement.execute(table);

    }

    public void createLikesTable() throws SQLException {
        String table = "CREATE TABLE IF NOT EXISTS likes (\n" +
                       "    ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                       "    UserID INT,\n" +
                       "    POSTID INT,\n" +
                       "    FOREIGN KEY (UserID) REFERENCES users(id) ON DELETE CASCADE,\n" +
                       "    FOREIGN KEY (PostID) REFERENCES posts(id) ON DELETE CASCADE,\n" +
                       "    UNIQUE (UserID, PostID) -- Ensure a user can only like a post once\n" +
                       ");";
        statement.execute(table);
        
    }

    public Statement getStatement() {
        return statement;
    }
}
