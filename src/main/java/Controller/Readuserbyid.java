/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.Database;
import models.User;

/**
 *
 * @author itxas
 */
public class Readuserbyid {
 private User user;
	
	public Readuserbyid(int ID, Database database) {
		String select = "SELECT * FROM `users` WHERE `ID` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			user = new User();
			user.setId(ID);
			user.setFirstName(rs.getString("FirstName"));
			user.setLastName(rs.getString("LastName"));
			user.setEmail(rs.getString("Email"));
		} catch (SQLException e) {
			
		}
	}
	
	public User getUser() {
		return user;
	}
    
}
