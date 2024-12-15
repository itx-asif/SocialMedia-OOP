/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

/**
 *
 * @author itxas
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Database;

public class Welcome {
    public Welcome() {
        JFrame frame = new JFrame();
        frame.setTitle("Welcome Page");
        frame.setLayout(new BorderLayout());
Database DB = new Database();
        // Left Panel ka kaam hai idhar
        JPanel p1 = new JPanel();
        p1.setBackground(Color.decode("#f5f5f5"));
        p1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Logo idhar lgain
        JLabel logoLabel = new JLabel("LINKUP");
        logoLabel.setForeground(Color.decode("#f2aa4c"));
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 48));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        p1.add(logoLabel, gbc);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("<html>Welcome to LinkUP – your go-to social media platform for connecting, sharing, and discovering! Create meaningful connections, explore vibrant communities, and share your moments with friends. Whether you're catching up with loved ones or finding new passions, LinkUP makes it easy and fun. Join today and start linking up!</html>", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.black);
        welcomeLabel.setPreferredSize(new Dimension(400,160));
        welcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // Increased font size
        gbc.gridy = 1;
        p1.add(welcomeLabel, gbc);

        // Button Panel for Login and Register
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(null);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10, 10));

        // Login Button
        Button loginButton = new Button(Color.decode("#f5f5f5"),Color.black ,Color.black,10);
        loginButton.setText("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonPanel.add(loginButton);
        
        // Register Button
        Button registrationButton = new Button(Color.white,Color.decode("#f2aa4c"),Color.decode("#f2aa4c"),10);
        registrationButton.setHoverColor(Color.black);
        registrationButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registrationButton.setText("Registration");
        buttonPanel.add(registrationButton);

        gbc.gridy = 2;
        p1.add(buttonPanel, gbc);

        // Right Panel ka kaam hai idhar
        JPanel p2 = new JPanel();
        p2.setBackground(Color.decode("#f2aa4c"));
        p2.setLayout(new BorderLayout());

        //  image
ImageIcon imageIcon = new ImageIcon("./src/main/java/pics/logo.png");
 // Replace with the path to your image
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(450, 450, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(imageIcon);
     
        p2.add(imageLabel, BorderLayout.CENTER);

        //pannel sizes
        p1.setPreferredSize(new Dimension(450, 625));
        p2.setPreferredSize(new Dimension(450, 625));

        // Added panels to frame
        frame.add(p1, BorderLayout.WEST);
        frame.add(p2, BorderLayout.EAST);

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
          registrationButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                // Code to execute when button is clicked 
                frame.dispose();
                new Registration(DB);
            } 
        });
             loginButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                // Code to execute when button is clicked 
                frame.dispose();
                new Login(DB);
            } 
        });
    }
}
         

