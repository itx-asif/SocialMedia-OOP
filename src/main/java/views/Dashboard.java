package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Database;
import models.Post;
import models.User;

public class Dashboard {
    public Dashboard(User U, Database DB) {
        // Create the main frame
        JFrame frame = new JFrame();

        // Create the card layout panel for switching content
        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create commentActionListener for handling comment panel navigation
        ActionListener commentActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Post postToCommentOn = (Post) e.getSource(); // The source of the event is the post object
                CommentPanel commentPanel = new CommentPanel(DB, postToCommentOn, U);
                commentPanel.revalidate();
                commentPanel.repaint();
                cardPanel.add(commentPanel, "Comment");
                cardLayout.show(cardPanel, "Comment");
            }
        };

       
       HomePanel homePanel = new HomePanel(U, DB, commentActionListener);
       cardPanel.add(homePanel, "Home");
                
        SettingPanel settingPanel = new SettingPanel(U, DB);
        cardPanel.add(settingPanel, "Setting");

        // Create the sidebar (left side) and add it to the frame with its actionListener
        SideBar sideBar = new SideBar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                // Show the appropriate panel based on button clicked
                switch (command) {
                    case "Home":
                        HomePanel homePanel = new HomePanel(U, DB, commentActionListener);
                        homePanel.revalidate();
                homePanel.repaint();
                cardPanel.add(homePanel, "Home");
                
                        cardLayout.show(cardPanel, "Home");
                        break;
                    case "Post":
                        PostPanel postPanel = new PostPanel(U, DB, commentActionListener);
                          postPanel.revalidate();
                postPanel.repaint();
                cardPanel.add(postPanel, "Post");
                        cardLayout.show(cardPanel, "Post");
                        break;
                    case "Setting":
                        cardLayout.show(cardPanel, "Setting");
                        break;
                    case "Logout":
                        System.exit(0);
                        break;
                }
                 cardPanel.revalidate();
                cardPanel.repaint();
            }
        });

        // Set the layout for the frame
        frame.setLayout(new BorderLayout(5, 0));
        frame.add(sideBar, BorderLayout.WEST);  // Add sidebar to the left
        frame.add(cardPanel, BorderLayout.CENTER);  // Add card panel to the center

        // Finalize frame settings
        frame.setVisible(true);
    
    }
}
