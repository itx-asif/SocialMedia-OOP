/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;
import models.Database;
import models.Post;

/**
 *
 * @author itxas
 */
public class CreatePost {
    private Post post;
	private Database database;
	
	public CreatePost(Post post, Database database) {
		this.post = post;
		this.database = database;
	}
	
	public boolean posted() {
		boolean posted = false;
		String insert = "INSERT INTO `posts`(`Content`, `UserID`) VALUES"
				+ " ('"+post.getContent()+"','"+post.getUserID()+"');";
		try {
			database.getStatement().execute(insert);
			posted = true;
		} catch (SQLException e) {
			posted = false;
		}
		return posted;
	}

}