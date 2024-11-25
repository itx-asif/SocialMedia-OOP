package views;

import Controller.CreatePost;
import Controller.ReadUserPost;
import models.Database;
import models.Post;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PostPanel extends JPanel {
    private ArrayList<Post> allPosts;
    private JPanel contentPanel;

    public PostPanel(User u, Database db, ActionListener commentListener) {
        // Initialize the ReadUserPost to fetch posts of the specific user
        ReadUserPost postReader = new ReadUserPost(u.getId(), db);
        allPosts = postReader.getUserPosts();

        // Panel to display the posts (using BorderLayout)
        setLayout(new BorderLayout());
       

        // Create contentPanel with BoxLayout (Vertical)
        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(400, 600));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Initial rendering of posts
        renderPosts(contentPanel, db, u,commentListener);

        // Wrap the contentPanel inside a JScrollPane to make it scrollable
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        // Add the JScrollPane to the center of the panel using BorderLayout.CENTER
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to render posts into the content panel
    private void renderPosts(JPanel contentPanel, Database db, User u,ActionListener commentListener) {
        contentPanel.removeAll();  // Clear the existing posts before re-adding

        // Add each post to the contentPanel with a delete button
        for (Post post : allPosts) {
            // Create a panel for each post
            ActionListener action =   new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //deletePost(post, db, u,commentListener);  // Call the delete method with the specific post
                }
            };
            JPanel postWrapper = new JPanel();
            postWrapper.setLayout(new BoxLayout(postWrapper, BoxLayout.X_AXIS));  // Layout: Horizontal alignment for post content + delete button

            // Create panel for post content
            showPostPanel postPanel = new showPostPanel(db, post, u, commentListener); 
            postPanel.showDeleteButton();// Assuming showPostPanel is a custom JPanel
            postWrapper.add(postPanel);

        

            // Add postWrapper to contentPanel
            contentPanel.add(postWrapper);
        }

        // Revalidate and repaint to ensure the panel is updated visually
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // Method to delete a specific post
 

 
}
