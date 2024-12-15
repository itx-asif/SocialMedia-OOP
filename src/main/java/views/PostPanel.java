package views;

import Controller.ReadUserPost;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PostPanel extends JPanel {
    private ArrayList<Post> allPosts;
    private JPanel contentPanel;

    public PostPanel(User u, Database db, ActionListener commentListener) {
        // Initialize the ReadUserPost to fetch posts of the specific user
        ReadUserPost postReader = new ReadUserPost(u.getId(), db);
        allPosts = postReader.getUserPosts();

        // Set the layout for the main panel (BorderLayout)
        setLayout(new BorderLayout(0,0));
       
        // Create contentPanel with BoxLayout (Vertical)
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical stacking

        // Initial rendering of posts
        renderPosts(contentPanel, db, u, commentListener);

        // Wrap the contentPanel inside a JScrollPane to make it scrollable
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to the center of the panel using BorderLayout.CENTER
        add(scrollPane);
    }

    // Method to render posts into the content panel
    private void renderPosts(JPanel contentPanel, Database db, User u, ActionListener commentListener) {
        contentPanel.removeAll();  // Clear the existing posts before re-adding

        
        for (Post post : allPosts) {
            // Create a wrapper for the post
            JPanel postWrapper = new JPanel();
            postWrapper.setLayout(new BoxLayout(postWrapper, BoxLayout.X_AXIS));  // Horizontal layout for post content and delete button
postWrapper.setAlignmentX(Component.LEFT_ALIGNMENT);
            // Create and add the showPostPanel
            showPostPanel postPanel = new showPostPanel(db, post, u, commentListener); 
            postPanel.showDeleteButton(); // Show the delete button for each post

            // Add the post panel to the wrapper
            postWrapper.add(postPanel);


            // Add the post wrapper to the content panel
            contentPanel.add(postWrapper);
        }

        // Revalidate and repaint to ensure the panel is updated visually
      revalidate();
       repaint();
    }

   
}
