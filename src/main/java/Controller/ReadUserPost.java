package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Database;
import models.Post;
import views.Alert;

/**
 *
 * @author itxas
 */
public class ReadUserPost {

    private ArrayList<Post> userPosts;
    private int userId;
    private Database DB;

    // Constructor to initialize userId and Database
    public ReadUserPost(int userId, Database DB) {
        this.userId = userId;
        this.DB = DB;
        this.userPosts = new ArrayList<>();
        fetchUserPosts();
    }

    // Method to fetch posts for a specific user from the database
    public void fetchUserPosts() {
       
        userPosts = new ArrayList<>();
        // SQL query to fetch posts for a specific user
        String select = "SELECT * FROM `posts` WHERE UserID = "+userId+";";
        
        // Using PreparedStatement to prevent SQL injection and to pass userId safely
        try  {
            
            ResultSet rs = DB.getStatement().executeQuery(select);
            
            // Iterate over the result set and create Post objects
            while (rs.next()) {
                 Post post = new Post();
                post.setID(rs.getInt("id"));
                post.setUserID(rs.getInt("UserID"));
                post.setContent(rs.getString("Content"));
//  
         
                // Add the post to the list
                userPosts.add(post);
            }
        } catch (SQLException e) {
            new Alert(e.getMessage());  // Log the exception (you can replace with proper logging)
        }
         
    }

    // Method to load comments for a specific post
    

    // Method to return the list of posts for this user
    public ArrayList<Post> getUserPosts() {
        return userPosts;
    }

    // Method to update the list of posts for the user (if new posts have been added)
   
}
