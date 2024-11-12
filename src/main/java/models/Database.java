package models;

import java.sql.*;

public class Database {
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private Statement statement;
    

    public Database() {
        try {
          
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // establish xampp databse connection
            System.out.println("Connected to the database server.");

            statement = connection.createStatement();
            createDatabase();
      
            statement.execute("USE socialmedia"); // use database
            createUserTable();
            createPostTable();
            createCommentTable();
            createlikeTable();



        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
    }
public void createDatabase() throws SQLException{
    
    String sql = "CREATE DATABASE IF NOT EXISTS socialmedia;"; // database if not exsist
    statement.execute(sql);
    System.out.println("Database created successfully...");
}
private void createUserTable() throws SQLException{
        String table = "CREATE TABLE IF NOT EXISTS users (\n" +
"    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
"    first_name VARCHAR(100) NOT NULL,\n" +
"    last_name VARCHAR(100) NOT NULL,\n" +
"    email VARCHAR(255) NOT NULL UNIQUE,\n" +
"    password VARCHAR(255) NOT NULL\n" +
");"; 
        statement.execute(table);
        System.out.println("user table created successfully...");
  
        
    
}
private void createPostTable() throws SQLException{
        String table = "CREATE TABLE IF NOT EXISTS posts (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    user_id INT,\n" +
                "    content TEXT NOT NULL,\n" +
                "    likes INT DEFAULT 0,\n" +
                "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                "    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE\n" +
                ");";

        statement.execute(table);
        System.out.println("post table created successfully...");

}
private void createCommentTable() throws SQLException{
        String table = "CREATE TABLE IF NOT EXISTS comments (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    post_id INT,\n" +
                "    user_id INT,\n" +
                "    content TEXT NOT NULL,\n" +
                "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                "    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE,\n" +
                "    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE\n" +
                ");";
        statement.execute(table);
        System.out.println("comment table created successfully...");
}
public void createlikeTable() throws SQLException{
        String table ="CREATE TABLE IF NOT EXISTS likes (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    user_id INT,\n" +
                "    post_id INT,\n" +
                "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                "    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,\n" +
                "    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE,\n" +
                "    UNIQUE (user_id, post_id) -- Ensure a user can only like a post once\n" +
                ");";
        statement.execute(table);
        System.out.println("like table created successfully...");
}

    public Statement getStatement() {
        return statement;
    }
}
