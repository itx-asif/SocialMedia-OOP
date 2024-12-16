package views;
import Controller.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import models.*;

public class HomePanel extends JPanel {
    ArrayList<Post> allPosts;

    public HomePanel(User user, Database db, ActionListener commentListener) {
        // Initialize the post reader and fetch the posts
        ReadPost postReader = new ReadPost(db);
        allPosts = postReader.getPosts();

        // Set the layout and border for the panel
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Create a label and input field for creating a post
        JLabel cPost = new JLabel("Create post");
        JPanel createPostPanel = new JPanel();
        createPostPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Align items to the center

        JTextField postfield = new JTextField("share your Idea.......");
        postfield.setPreferredSize(new Dimension(400, 30));
        createPostPanel.add(cPost);
        createPostPanel.add(postfield);
        
    JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Create post button
        JButton postbutton = new JButton("Post");
        postbutton.setFont(new Font("Arial", Font.BOLD, 16));
        postbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (postfield.getText().isEmpty()) {
                    System.out.println("Post can't be empty");
                } else {
                    // Create a new post and save it to the database
                    Post p1 = new Post();
                    p1.setContent(postfield.getText());
                    p1.setUserID(user.getId());
                    CreatePost createPostController = new CreatePost(p1, db);
                    if (createPostController.posted()) {
                        // After posting, update the post list
                        postReader.Updatepost(db);
                        allPosts = postReader.getPosts();

                        // Immediately re-render the posts
                        contentPanel.removeAll();  // Clear the existing posts
                        // Add each post to the contentPanel
                        for (Post post : allPosts) {
                            showPostPanel postPanel = new showPostPanel(db, post, user, commentListener);
                            postPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align post panel to the left
                            contentPanel.add(postPanel);
                        }
                        // Revalidate and repaint the content panel to reflect changes
//                        contentPanel.revalidate();
//                        contentPanel.repaint();
                    }
                }
            }
        });
        createPostPanel.add(postbutton);
        add(createPostPanel, BorderLayout.NORTH);

        for (Post post : allPosts) {
            showPostPanel postPanel = new showPostPanel(db, post, user, commentListener);
            postPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align post panel to the left
            contentPanel.add(postPanel);
        }

        // Wrap the content panel in a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Always show vertical scrollbar
        add(scrollPane, BorderLayout.CENTER);
    } 
}
