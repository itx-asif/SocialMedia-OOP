/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Database;
import models.Post;

/**
 *
 * @author itxas
 */
public class ReadPost {

    public ArrayList<Post> getPosts() {
        return posts;
    }
    private ArrayList<Post> posts;
    public ReadPost(Database DB){
        posts = new ArrayList<>();
		String select = "SELECT * FROM `posts` ";
		try {
			ResultSet rs = DB.getStatement().executeQuery(select);
			while (rs.next()) {
				Post p = new Post();
				p.setID(rs.getInt("id"));
                                p.setUserID(rs.getInt("UserID"));
				p.setContent(rs.getString("Content"));
				posts.add(p);
                                System.out.println(rs.getInt("id"));
                          // ReadPostComments r=new ReadPostComments(p,DB);
                          // p.setComments(r.getComments());
                            
			}
		} catch (SQLException e) {
			
		}
	
    }
    
    
}
