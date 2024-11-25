
package models;




public class Comments {

    public Comments(int ID, int postID, int userID, String Content) {
        this.ID = ID;
        this.postID = postID;
        this.userID = userID;
        this.Content = Content;
    }
    public Comments(){
        
    }
    int ID;
    int postID;
    int userID;
    String Content;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

 
}
