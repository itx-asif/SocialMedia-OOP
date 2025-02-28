package views;

import Controller.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class showPostPanel extends JPanel {
    private Post post;
    private JLabel titleLabel;
    private JLabel contentLabel;
    private JButton likeButton;
    private JButton commentButton;
    private JButton deleteButton; // Delete button
    private Database DB;

    public showPostPanel(Database DB, Post post, User currentUser , ActionListener commentListener) {
        this.DB = DB;
        this.post = post;

        // Layout settings
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(40, 30, 40, 30));

        // Create user from post's UserID
        User postUser  = new Readuserbyid(post.getUserID(),DB).getUser();

        // Title Label (User 's name)
        titleLabel = new JLabel(postUser.getFirstName() + " " + postUser.getLastName(), SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Content Label (Post content)
        contentLabel = new JLabel("<html>" + post.getContent() + "</html>");
        contentLabel.setSize(200,400);
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Like and Comment Buttons
        ReadLike like = new ReadLike(DB, post);
        likeButton = new JButton("Like " + getLikes(like));
        likeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        
      likeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        handleLikeButton(currentUser , like);
    }
});


        commentButton = new JButton("Comment");
        commentButton.setFont(new Font("Arial", Font.PLAIN, 14));
commentButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        commentListener.actionPerformed(new ActionEvent(post, ActionEvent.ACTION_PERFORMED, "Comment"));
    }
});

        // Delete Button (Initially invisible)
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 12));
        deleteButton.setVisible(false); // Initially hidden
        deleteButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       DeletePost d = new DeletePost(post.getID(),DB);
       d.delete();
      Container parent = showPostPanel.this.getParent();  // Get parent container of this panel
        if (parent != null) {
            parent.remove(showPostPanel.this); // Remove this post panel from its parent container
        }

        // Revalidate and repaint the parent container to update the display
        if (parent != null) {
            parent.revalidate();  // Recalculate layout
            parent.repaint();     // Redraw the container
        }
    
       
    }
});

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(likeButton);
        buttonPanel.add(commentButton);
        buttonPanel.add(deleteButton); // Add delete button to the panel

        // Add Components
        add(titleLabel, BorderLayout.NORTH);
        add(contentLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(200, 200)); // Set preferred size
    }


    private void handleLikeButton(User user, ReadLike like) {
        if (like.isLiked(user)) {
            like.dislikePost(user);
        } else {
            like.likePost(user);
        }
        post.setLikes(like.getLikes());
        likeButton.setText("Like " + getLikes(like));
    }

    private int getLikes(ReadLike like) {
        return like.getLikes().isEmpty() ? 0 : like.getLikes().size();
    }

    public void showDeleteButton() {
        deleteButton.setVisible(true);
    }
}