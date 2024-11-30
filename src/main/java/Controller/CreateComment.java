/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;
import models.Comments;

import models.Database;
import models.Post;
import models.User;

/**
 *
 * @author itxas
 */
public class CreateComment {
    boolean posted = false;

    public boolean isPosted() {
        return posted;
    }
   public CreateComment(Database DB, Comments comment) {
     String query =   "INSERT INTO comments (PostID, UserID, Content) VALUES ("+comment.getPostID()+","+comment.getUserID()+", '"+comment.getContent()+"')";
      System.out.println(comment.getContent());
     try{
         DB.getStatement().execute(query);
         System.out.println(comment.getContent());
         boolean posted = true;
     }catch(SQLException e){
         boolean posted = false;
         System.out.println(e.getMessage());
                 
     }
       
   }
    
    
    
}
