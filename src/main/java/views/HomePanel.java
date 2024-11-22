package views;
import Controller.CreatePost;
import Controller.ReadPost;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import models.Database;
import models.Post;
import models.User;


public class HomePanel extends JPanel {
    ArrayList<Post> allPosts;

    public HomePanel(User user, Database db) {
        ReadPost postReader = new ReadPost(db);
        allPosts = postReader.getPosts();
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout(0, 40));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JLabel cPost = new JLabel("Create post");

        // Panel for search input and button at the top
        JPanel createPostPanel = new JPanel();
        createPostPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Align items to the left

        JTextField postfield = new JTextField();
        postfield.setPreferredSize(new Dimension(400, 30));
        createPostPanel.add(cPost);
        createPostPanel.add(postfield);

        JButton postbutton = new JButton("Post");
        postbutton.setBounds(420, 100, 100, 30);
JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        postbutton.setFont(new Font("Arial", Font.BOLD, 16));
        postbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (postfield.getText().isEmpty()) {
                    System.out.println("Post can't be empty");
                } else {
                    Post p1 = new Post();
                    p1.setContent(postfield.getText());
                    p1.setUserID(user.getId());
                    CreatePost p = new CreatePost(p1, db);
                    if (p.posted()) {
                        // After posting, update the post list
                        postReader.Updatepost(db);
                        allPosts = postReader.getPosts();
                        
                        // Re-render the posts
                        updatePostList(contentPanel,db);
                    }
                }
            }
        });
        createPostPanel.add(postbutton);

        add(createPostPanel, BorderLayout.NORTH);

        
        // Initial render of all posts
        renderPosts(contentPanel);

        // Wrap the contentPanel inside a JScrollPane to make it scrollable
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Enable vertical scrolling

        // Add the JScrollPane to the center of HomePanel
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to render posts into the content panel
    private void renderPosts(JPanel contentPanel) {
        // Clear the existing posts before re-adding
        contentPanel.removeAll();

        // Add each post to the contentPanel
        for (Post post : allPosts) {
            showPostPanel postPanel = new showPostPanel(post); // Using ShowPostPanel instead of showPostPanel
            postPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align post panel to the left
            contentPanel.add(postPanel);
        }

        // Revalidate and repaint to ensure the panel is updated visually
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // Method to update the post list (called after a new post is created)
    private void updatePostList(JPanel contentPanel,Database db) {
        ReadPost postReader = new ReadPost(db);
        allPosts = postReader.getPosts();
        renderPosts(contentPanel);
    }
}
