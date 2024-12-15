package views;

import Controller.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import models.*;

public class CommentPanel extends JPanel {
    private Database db;
    private Post post;
    private User user;

    public CommentPanel(Database DB, Post post, User u) {
        this.db = DB;
        this.post = post;
        this.user = u;

        // Set layout
        setLayout(null);
setPreferredSize(new Dimension(600,600));
        // Heading label for the comment section
        JLabel heading = new JLabel("You can Comment here!");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(100, 50, 300, 30);
        add(heading);

        // Get the user information of the post's author
        Readuserbyid read = new Readuserbyid(post.getUserID(), DB);
        User postUser = read.getUser();
        JLabel userLabel = new JLabel(postUser.getFirstName() + " " + postUser.getLastName());
        userLabel.setForeground(Color.BLACK);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setBounds(100, 80, 300, 30);
        add(userLabel);

        // Display the post content (e.g., post text)
        JLabel postContentLabel = new JLabel("<html><div style='width: 300px'>" + post.getContent() + "</div></html>");
       
        postContentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        postContentLabel.setBounds(100, 100, 400, 50);
        add(postContentLabel);

        // Create a text field to enter the comment
        JTextField commentField = new JTextField("Share You Thoughts");
        commentField.setBounds(100, 170, 300, 30);
        add(commentField);

        // Create a button to post the comment
        JButton commentButton = new JButton("Post Comment");
        commentButton.setBounds(420, 170, 120, 30);
        commentButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(commentButton);

        // Action listener for the comment button
        commentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commentText = commentField.getText();
                if (!commentText.isEmpty()) {
                    // Create a new comment
                    Comments comment = new Comments();
                    comment.setPostID(post.getID());  // Link comment to the current post
                    comment.setUserID(user.getId());  // Set the user who is commenting
                    comment.setContent(commentText);

                   

                    // Clear the text field
                    commentField.setText("");

                  CreateComment c = new CreateComment(DB,comment);
                  if(c.isPosted()){
                      revalidate();
                     repaint();  
                  }
                }
            }
        });

        // Load and display existing comments
        ReadPostComments commentReader = new ReadPostComments(post, db);
        ArrayList<Comments> comments = commentReader.getComments();

        // Start y-position below the comment input area
        int yPosition = 220;

        // Display each comment in the list
        for (Comments comment : comments) {
            JTextArea commentArea = new JTextArea();
            commentArea.setText(comment.getContent());
            commentArea.setFont(new Font("Arial", Font.PLAIN, 14));
            commentArea.setEditable(false);
            
            commentArea.setBounds(100, yPosition, 400, 40);
            add(commentArea);
            yPosition += 50;  // Move the next comment down by 50 pixels
        }

        // Revalidate and repaint to ensure the panel is updated visually
        revalidate();
        repaint();
        
        

    }
}
