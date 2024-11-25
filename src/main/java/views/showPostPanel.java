package views;

import Controller.ReadLike;
import Controller.Readuserbyid;
import models.Post;
import models.User;
import models.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showPostPanel extends JPanel {
    private Post post; // The post object
    private JLabel titleLabel;
    private JLabel contentLabel;
    private JButton likeButton;
    private JButton commentButton;
    private JButton deleteButton; // Delete button
    private Database DB;

    public showPostPanel(Database DB, Post post, User u, ActionListener commentListener) {
        this.DB = DB;
        this.post = post;

        // Set the layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Vertical stacking layout

        // Create user from post userID
        Readuserbyid U = new Readuserbyid(post.getUserID(), DB);
        User user = U.getUser();

        // Title Label (User's name)
        titleLabel = new JLabel(user.getFirstName() + " " + user.getLastName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(titleLabel);

        // Content Label (Post content)
        contentLabel = new JLabel("<html><div style='width: 300px; margin-left:-10px;'>" + post.getContent() + "</div></html>");
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        contentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(contentLabel);

        // Panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centered flow layout

        ReadLike like = new ReadLike(DB, post);

        likeButton = new JButton("Like " + getlikes(like));
        likeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonPanel.add(likeButton);

        // Comment Button
        commentButton = new JButton("Comment");
        commentButton.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonPanel.add(commentButton);

        // Like Button ActionListener
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the user has already liked the post
                if (like.isLiked(u)) {
                    // User already liked the post, so we will remove the like (dislike)
                    like.dislikePost(u);
                    post.setLikes(like.getLikes());  // Update the post's likes list
                    // Update the like button text to "Like"
                    likeButton.setText("Like " + getlikes(like));
                } else {
                    // User has not liked the post yet, so we will add a like
                    like.likePost(u);
                    post.setLikes(like.getLikes());  // Update the post's likes list
                    // Update the like button text to "Liked"
                    likeButton.setText("Liked " + getlikes(like));
                }
            }
        });

        // Comment button action listener
        commentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use the passed commentListener to switch to the CommentPanel
                commentListener.actionPerformed(new ActionEvent(post, ActionEvent.ACTION_PERFORMED, "Comment"));
            }
        });

        // Add button panel to the main post panel
        add(buttonPanel);

        // Create and add the delete button but keep it invisible initially
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 12));
        deleteButton.setVisible(false);  // Initially set to be invisible

        // Add action listener to handle post deletion
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // You need to implement the delete logic, likely using a controller method
                // deletePost(post, DB); // Example delete logic
            }
        });

        // Add delete button to the panel
        buttonPanel.add(deleteButton);

        // Set preferred size for the panel based on content size
        setWidth(665);
    }

    // Dynamically calculate height for the panel based on content
    private int getHeightForContent() {
        int contentHeight = contentLabel.getPreferredSize().height;  // Get height of contentLabel
        int buttonPanelHeight = 40; // Approximate height of the button panel
        return 115 + contentHeight + buttonPanelHeight; // Add height for title, content, and buttons
    }

    // Set a fixed width and dynamic height for the content
    public void setWidth(int width) {
        int height = getHeightForContent();  // Recalculate height dynamically
        setPreferredSize(new Dimension(width, height));  // Set preferred size
    }

    // Method to show the delete button
    public void showDeleteButton() {
        deleteButton.setVisible(true);  // Make the delete button visible
        revalidate();  // Revalidate the panel to reflect changes
        repaint();  // Repaint the panel to apply visibility changes
    }

    // Method to hide the delete button (if needed)
    public void hideDeleteButton() {
        deleteButton.setVisible(false);  // Make the delete button invisible
        revalidate();  // Revalidate the panel to reflect changes
        repaint();  // Repaint the panel to apply visibility changes
    }

    public int getlikes(ReadLike like){
        if(like.getLikes().isEmpty()){
           return  0;
        }else{
           return like.getLikes().size();
        }
    }
}
