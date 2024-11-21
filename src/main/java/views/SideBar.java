package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SideBar extends JPanel {
    public SideBar(ActionListener listener) {
        // Set up the sidebar panel
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(200, 625)); // Set a fixed size for the sidebar panel
        setLayout(null);  // Absolute positioning (you could use a LayoutManager for more flexibility)

        // Logo
        JLabel logo = new JLabel("LINKUP");
        logo.setForeground(Color.BLUE);
        logo.setFont(new Font("Arial", Font.BOLD, 40));
        logo.setBounds(20, 50, 150, 50);  // Adjust the logo position as needed
        add(logo);

        // Home Button
        JButton home = new JButton("Home");
        home.setBounds(20, 150, 150, 60);
        home.setActionCommand("Home");
        home.addActionListener(listener);  // Add the listener to the button
        add(home);

        // Post Button
        JButton post = new JButton("Post");
        post.setBounds(20, 220, 150, 60);
        post.setActionCommand("Post");
        post.addActionListener(listener);  // Add the listener to the button
        add(post);

        // Comment Button
        JButton comment = new JButton("Comment");
        comment.setBounds(20, 290, 150, 60);
        comment.setActionCommand("Comment");
        comment.addActionListener(listener);  // Add the listener to the button
        add(comment);

      

        // Setting Button
        JButton setting = new JButton("Setting");
        setting.setBounds(20, 360, 150, 60);
        setting.setActionCommand("Setting");
        setting.addActionListener(listener);  // Add the listener to the button
        add(setting);

        // Logout Button
        JButton logout = new JButton("Logout");
        logout.setBounds(20, 500, 150, 60);
        logout.setActionCommand("Logout");
        logout.addActionListener(listener);  // Add the listener to the button
        add(logout);
    }
}
