/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.sql.*;
import java.util.ArrayList;
import models.*;

/**
 *
 * @author itxas
 */
public class CreateUser {
	
	private User u;
	private Database database;
	
	public CreateUser(User u, Database database) {
		this.u = u;
		this.database = database;
	}
	
	public void create() {
		String insert = "INSERT INTO `users`(`FirstName`, `LastName`, `Email`, "
				+ "`Password`) VALUES ('"+u.getFirstName()+"','"+u.getLastName()
				+"','"+u.getEmail()+"','"+u.getPassword()+"');";
		try {
			database.getStatement().execute(insert);
		} catch (SQLException e) {
			                 System.out.println(e.getMessage());
		}
	}
	
	public boolean isEmailUsed() {
		String select = "SELECT * FROM `users` WHERE `Email` = '"+u.getEmail()+"';";
		boolean used = false;
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			used = rs.next();
		} catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		return used;
	}
	
	public User getUser() {
		
		String POST = "SELECT ID FROM `posts` WHERE `UserID` = "
						+u.getId()+" ;";
                try {
				ResultSet rs2 = database.getStatement().executeQuery(POST);
                                
				ArrayList<Integer> postID = new ArrayList<>();
				while (rs2.next()) {
					postID.add(rs2.getInt("ID"));                                                           
				}
                                u.setPost(postID);
                                } catch (SQLException e) {
                                    	 System.out.println(e.getMessage());
		}
                                
		return u;
	}

}
