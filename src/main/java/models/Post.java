
package models;


import Controller.ReadPostComments;
import java.util.*;


public class Post {
private int ID;
  private  int userID;
   private String content;
   private ArrayList<Comments> comments;
   private ArrayList<Likes> likes;

    public ArrayList<Likes> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Likes> likes) {
        this.likes = likes;
    }
  
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void setComments(Post p,Database DB) {
        ReadPostComments c= new ReadPostComments(p,DB);
        comments = new ArrayList<>();
        comments = c.getComments();
    }
   
  
    
   

  
 
    
    
}
