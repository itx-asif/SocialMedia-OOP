    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author itxas
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Database;
import models.User;

public class ReadUser {
 

	private boolean loggedIn;
	private User user;
	
	public ReadUser(String email, String password, Database database) {
		String select = "SELECT * FROM `users` WHERE `Email` = '"+email+
				"' AND `Password` = '"+password+"';";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			loggedIn = rs.next();
                        System.out.println(loggedIn);
			if (loggedIn) {
				user = new User();
				user.setId(rs.getInt("ID"));
				user.setFirstName(rs.getString("FirstNAme"));
				user.setLastName(rs.getString("LastName"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("Password"));
                                             				
				String POST = "SELECT ID FROM `posts` WHERE `UserID` = "
						+user.getId()+" ;";
				ResultSet rs2 = database.getStatement().executeQuery(POST);
                                
				ArrayList<Integer> postID = new ArrayList<>();
				while (rs2.next()) {
					postID.add(rs2.getInt("ID"));                                                           
				}
                                user.setPost(postID);
				
			}
		} catch (SQLException e) {
			                 System.out.println("e.massage");
		}
	}
	
	public boolean loggedIn() {
		return loggedIn;
	}
	
	public User getUser() {
		return user;
	}

}
 

