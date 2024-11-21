
package models;

import java.util.ArrayList;


public class Post {
   int id;
    int userID;
    String content;
    ArrayList<Comments> commets;
  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Comments> getCommets() {
        return commets;
    }

    public void setCommets(ArrayList<Comments> commets) {
        this.commets = commets;
    }

  
 
    
    
}
