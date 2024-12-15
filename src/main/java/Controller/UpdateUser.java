package Controller;

import models.Database;
import models.User;
import java.sql.SQLException;
import views.Alert;

public class UpdateUser {

    private Database db;

    public UpdateUser(Database db) {
        this.db = db;
    }

    public boolean updateUser(User user, String name,String lname, String email, String password, String NewPassword) {
        // Step 1: Check if the old password matches
        if (!user.getPassword().equals(password)) {
            new Alert("pass dont mtch");
            return false;  // Password doesn't match, so we don't update
        }

        // Step 2: Check if the new password matches the confirmation
        else{

      
            // Prepare the SQL query to update the user information
            String sql = "UPDATE users SET `FirstName` = '"+name+"', `LastName` = '"+lname+"', `EMAIL` = '"+email+"', `password` = '"+NewPassword+"' WHERE `users`.`ID` = "+user.getId();
            try {
               int a =db.getStatement().executeUpdate(sql);
               
                 if(a>0){
               return  true;}
                 else{return false;}
              //  System.out.println("db runed");// Returns true if rows were updated successfully
            }

         catch (SQLException e) {
 new Alert(e.getMessage()); // Log the exception for debugging
            return false;  // Return false if there's an error during update
        }
        }}}

