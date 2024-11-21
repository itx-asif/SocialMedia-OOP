/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingPanel extends JPanel {

    public SettingPanel() {
        JLabel head = new JLabel("Update Profile");
        head.setForeground(Color.BLUE);
        head.setFont(new Font("Arial", Font.BOLD, 22));
        head.setBounds(250, 0, 150, 50);
        add(head);

        setBackground(Color.WHITE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 100, 150, 30);
        nameLabel.setForeground(Color.RED);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(300, 100, 200, 30);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 150, 150, 30);
        emailLabel.setForeground(Color.RED);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(300, 150, 200, 30);
        add(emailField);

        JLabel passwordLabel = new JLabel("Old Password:");
        passwordLabel.setBounds(100, 200, 150, 30);
        passwordLabel.setForeground(Color.RED);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(300, 200, 200, 30);
        add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("New Password:");
        confirmPasswordLabel.setBounds(100, 250, 200, 30);
        confirmPasswordLabel.setForeground(Color.RED);
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(confirmPasswordLabel);

        JTextField confirmPasswordField = new JTextField();
        confirmPasswordField.setBounds(300, 250, 200, 30);
        add(confirmPasswordField);

        JButton updateProfileButton = new JButton("Update Profile");
        updateProfileButton.setBounds(200, 350, 200, 40);
        updateProfileButton.setFont(new Font("Arial", Font.BOLD, 18));
        add(updateProfileButton);
    }
}
