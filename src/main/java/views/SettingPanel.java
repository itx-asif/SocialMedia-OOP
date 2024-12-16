package views;

import Controller.UpdateUser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  // Use JPasswordField for password input
import models.*;


public class SettingPanel extends JPanel {

    public SettingPanel(User U, Database DB) {
        // Set up the title
        JLabel head = new JLabel("Update Profile");
        head.setForeground(Color.BLUE);
        head.setFont(new Font("Arial", Font.BOLD, 22));
        head.setBounds(250, 0, 200, 50);
        add(head);

        setLayout(null);

        // Name Label and TextField
        JLabel nameLabel = new JLabel("First Name:");
        nameLabel.setBounds(100, 100, 150, 30);
        nameLabel.setForeground(Color.RED);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(nameLabel);

        JTextField nameField = new JTextField(U.getFirstName()); // Set initial name from User object
        nameField.setBounds(300, 100, 200, 40);
        add(nameField);

        // Last Name Label and TextField
        JLabel lnameLabel = new JLabel("Last Name:");
        lnameLabel.setBounds(100, 150, 150, 30);
        lnameLabel.setForeground(Color.RED);
        lnameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(lnameLabel);

        JTextField lnameField = new JTextField(U.getLastName()); // Set initial last name from User object
        lnameField.setBounds(300, 150, 200, 40);
        add(lnameField);

        // Email Label and TextField
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 200, 150, 30);
        emailLabel.setForeground(Color.RED);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(emailLabel);

        JTextField emailField = new JTextField(U.getEmail()); // Set initial email from User object
        emailField.setBounds(300, 200, 200, 40);
        add(emailField);

        // Old Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Old Password:");
        passwordLabel.setBounds(100, 250, 150, 30);
        passwordLabel.setForeground(Color.RED);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(passwordLabel);

        JTextField passwordField = new JTextField("Enter Old Password");  // Use JPasswordField for password input
        passwordField.setBounds(300, 250, 200, 40);
        add(passwordField);

        // New Password Label and PasswordField
        JLabel confirmPasswordLabel = new JLabel("New Password:");
        confirmPasswordLabel.setBounds(100, 300, 200, 30);
        confirmPasswordLabel.setForeground(Color.RED);
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(confirmPasswordLabel);

        JTextField confirmPasswordField = new JTextField("Enter New Password");  // Use JPasswordField for password input
        confirmPasswordField.setBounds(300, 300, 200, 40);
        add(confirmPasswordField);

        // Update Profile Button
        JButton updateProfileButton = new JButton("Update Profile");
        updateProfileButton.setBounds(200, 350, 200, 40);
        updateProfileButton.setFont(new Font("Arial", Font.BOLD, 18));
        add(updateProfileButton);

        // Add action listener for button click event
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve values from the text fields
                String firstName = nameField.getText();
                String lastName = lnameField.getText();
                String email = emailField.getText();
                String oldPassword = passwordField.getText();  // Convert char[] to String
                String newPassword = confirmPasswordField.getText();  // Convert char[] to String

                // Update User in the database using UpdateUser class
                UpdateUser updateUserController = new UpdateUser(DB);

                boolean updated = updateUserController.updateUser(U, firstName, lastName, email, oldPassword, newPassword);

                if (updated) {
                 
                    U.setPassword(newPassword);
                    new Alert("Profile updated successfully.");
                } else {
                
                    new Alert("Profile update failed. Please check your inputs.");
                }
            }
        });
    }
}
