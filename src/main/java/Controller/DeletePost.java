package Controller;

import models.Database;
import java.sql.*;
import views.Alert;

public class DeletePost {

    private int postID;
    private Database database;

    // Constructor accepting postID to be deleted and the database instance
    public DeletePost(int postID, Database database) {
        this.postID = postID;
        this.database = database;
    }

    // Method to delete the post
    public void delete() {
        // Start a transaction to ensure data integrity (optional but recommended)
        String deletePostQuery = "DELETE FROM `posts` WHERE `ID` = "+postID;
        try {
          
                database.getStatement().execute(deletePostQuery);
    
        } catch (SQLException e) {
             new Alert(e.getMessage());
            
        } 
        
    }
}
