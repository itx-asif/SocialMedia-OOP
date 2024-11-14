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

public class Welcome {
    public Welcome() {
        JFrame frame = new JFrame();
        frame.setTitle("Welcome Page");
        frame.setLayout(new BorderLayout());

        // Left Panel ka kaam hai idhar
        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLACK);
        p1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Logo idhar lgain
        JLabel logoLabel = new JLabel("Logo");
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 48));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        p1.add(logoLabel, gbc);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome!", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Increased font size
        gbc.gridy = 1;
        p1.add(welcomeLabel, gbc);

        // Button Panel for Login and Register
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        buttonPanel.add(loginButton);

        // Register Button
        JButton registrationButton = new JButton("Register");
        registrationButton.setBackground(Color.BLUE);
        registrationButton.setForeground(Color.WHITE);
        buttonPanel.add(registrationButton);

        gbc.gridy = 2;
        p1.add(buttonPanel, gbc);

        // Right Panel ka kaam hai idhar
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(255, 218, 185));
        p2.setLayout(new BorderLayout());

        //  image
        ImageIcon imageIcon = new ImageIcon("C:/Users/Admin/OneDrive/Desktop/New folder (2)/WhatsApp Image 2024-11-14 at 17.56.43_c6e2d759.jpg"); // Replace with the path to your image
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(450, 625, Image.SCALE_SMOOTH);
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
    }
}
