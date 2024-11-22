package views;

import Controller.Readuserbyid;
import models.Post;

import javax.swing.*;
import java.awt.*;
import models.Database;
import models.User;

public class showPostPanel extends JPanel {
    private Post post; // The post object
    private JLabel titleLabel;
    private JLabel contentLabel;
    private JButton likeButton;
    private JButton commentButton;

    public showPostPanel(Post post) {
        this.post = post;
        
        // Set the layout and preferred size of the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Using BoxLayout to stack components vertically
     //   setMaximumSize(new Dimension(650, Integer.MAX_VALUE)); // Set max width to 500 and allow dynamic height

        Readuserbyid U = new Readuserbyid(post.getUserID(), new Database());
        User user = U.getUser();

        // Title Label (can be used for the post's title, user name, etc.)
        titleLabel = new JLabel(user.getFirstName() + " " + user.getLastName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Align left
        add(titleLabel);

        // Content Label (the actual content of the post)
        contentLabel = new JLabel("<html><div style='width: 400px; margin-left:-10px;'>" + post.getContent() + "</div></html>");
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        contentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Align left
          // Set preferred size for content
        
        add(contentLabel);

        // Panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Like Button (currently no functionality)
        likeButton = new JButton("Like");
        likeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonPanel.add(likeButton);

        // Comment Button (currently no functionality)
        commentButton = new JButton("Comment");
        commentButton.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonPanel.add(commentButton);

        // Add button panel to the post panel
        add(buttonPanel);

        // Set the preferred height dynamically based on content
        int height = getHeightForContent();
        setPreferredSize(new Dimension(665, height));
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
}
