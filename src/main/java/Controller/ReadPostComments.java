/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Comments;
import models.Database;
import models.Post;

/**
 *
 * @author itxas
 */
public class ReadPostComments {

    public ArrayList<Comments> getComments() {
        return comments;
    }
    ArrayList<Comments> comments;
 public  ReadPostComments(Post p,Database DB){
         comments = new ArrayList<>();
		String select = "SELECT * FROM `Comments` WHERE `PostID` = "+p.getID()+" ;";
		try {
			ResultSet rs = DB.getStatement().executeQuery(select);
			while (rs.next()) {
				Comments c = new Comments();
				c.setID(rs.getInt("ID"));
                                c.setPostID(rs.getInt("PostID"));
                                c.setUserID(rs.getInt("UserID"));
				c.setContent(rs.getString("Content"));
				comments.add(c);
			}
		} catch (SQLException e) {
			
		}
    }
    
}
