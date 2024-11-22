package views;

import Controller.ReadPost;
import models.Database;
import models.User;
import models.Post;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomePanel extends JPanel {

    public HomePanel(User user, Database db) {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout(0,40));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
       JLabel cPost = new JLabel("Create post");

        // Panel for search input and button at the top
        JPanel createPostPanel = new JPanel();
        createPostPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Align items to the left

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(400, 30));
        createPostPanel.add(cPost);
        createPostPanel.add(searchField);


        JButton searchButton = new JButton("Post");
        searchButton.setBounds(420, 100, 100, 30);

      

        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        createPostPanel.add(searchButton);

      add(createPostPanel, BorderLayout.NORTH);

        // Fetch the posts from the database
        ReadPost postReader = new ReadPost(db);
        ArrayList<Post> allPosts = postReader.getPosts();

        // Create a panel to hold all posts, which will be added to JScrollPane
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        

        // Add each post to the contentPanel
        for (Post post : allPosts) {
            showPostPanel postPanel = new showPostPanel(post); // Using ShowPostPanel instead of showPostPanel
            postPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align post panel to the left
            contentPanel.add(postPanel);
        }

        // Wrap the contentPanel inside a JScrollPane to make it scrollable
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Enable vertical scrolling

        // Add the JScrollPane to the center of HomePanel
        add(scrollPane, BorderLayout.WEST); // Change to CENTER for proper layout
    }
}