package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Database;
import models.Likes;
import models.Post;
import models.User;

public class ReadLike {
    private Database Db;
    private Post p;
    private ArrayList<Likes> likes;

    // Constructor to load likes for a specific post
    public ReadLike(Database Db, Post p) {
        this.Db = Db;
        this.p = p;
        this.likes = new ArrayList<>();
        loadLikes();
    }

    // Method to load likes for the post
    private void loadLikes() {
        String query = "SELECT * FROM `likes` WHERE POSTID = " + p.getID() + ";";
        likes = new ArrayList<>();
        try {
            ResultSet rs = Db.getStatement().executeQuery(query);
            while (rs.next()) {
                Likes l = new Likes();
                l.setUserID(rs.getInt("UserID"));
                l.setPostID(p.getID());
                l.setID(rs.getInt("ID"));
                likes.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadLike.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to check if a user has already liked the post
    public boolean isLiked(User u) {
        String query = "SELECT * FROM `likes` WHERE UserID = " + u.getId() + " AND POSTID = " + p.getID() + " LIMIT 1;";
        try {
            ResultSet rs = Db.getStatement().executeQuery(query);
            return rs.next();  // Returns true if user has liked the post
        } catch (SQLException ex) {
            Logger.getLogger(ReadLike.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Method to like a post
    public void likePost(User u) {
        if (!isLiked(u)) {
            String query = "INSERT INTO `likes` (UserID, POSTID) VALUES (" + u.getId() + ", " + p.getID() + ");";
            try {
                Db.getStatement().executeUpdate(query);
                loadLikes();  // Re-load the likes list after adding the new like
            } catch (SQLException ex) {
                Logger.getLogger(ReadLike.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("You already liked this post.");
        }
    }

    // Method to dislike (remove like from) a post
    public void dislikePost(User u) {
        if (isLiked(u)) {
            String query = "DELETE FROM `likes` WHERE UserID = " + u.getId() + " AND POSTID = " + p.getID() + ";";
            try {
                Db.getStatement().executeUpdate(query);
                likes.removeIf(like -> like.getUserID() == u.getId() && like.getPostID() == p.getID());
            } catch (SQLException ex) {
                Logger.getLogger(ReadLike.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("You haven't liked this post yet.");
        }
    }

    // Getter for the likes list (optional)
    public ArrayList<Likes> getLikes() {
        return likes;
    }
}
