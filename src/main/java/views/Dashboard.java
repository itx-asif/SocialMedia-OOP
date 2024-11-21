package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    public Dashboard() {
        // Create the main frame
        JFrame frame = new JFrame();
       

        // Create the card layout panel for switching content
        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create different content panels
        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.WHITE);
        homePanel.add(new JLabel("Home - Show All Posts"));

        JPanel postPanel = new JPanel();
        postPanel.setBackground(Color.LIGHT_GRAY);
        postPanel.add(new JLabel("Post - Create New Post"));

        JPanel commentPanel = new JPanel();
        commentPanel.setBackground(Color.CYAN);
        commentPanel.add(new JLabel("Comments - View User Comments"));



        JPanel settingPanel = new JPanel();
        settingPanel.setBackground(Color.YELLOW);
        settingPanel.add(new JLabel("Settings - Update Settings"));

        JPanel logoutPanel = new JPanel();
        logoutPanel.setBackground(Color.RED);
        logoutPanel.add(new JLabel("Logged Out"));

        // Add panels to the cardPanel with unique names
        cardPanel.add(homePanel, "Home");
        cardPanel.add(postPanel, "Post");
        cardPanel.add(commentPanel, "Comment");
       
        cardPanel.add(settingPanel, "Setting");
        cardPanel.add(logoutPanel, "Logout");

        // Create the sidebar (left side) and add it to the frame
        SideBar sideBar = new SideBar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                // Show the appropriate panel based on button clicked
                switch (command) {
                    case "Home":
                        cardLayout.show(cardPanel, "Home");
                        break;
                    case "Post":
                        cardLayout.show(cardPanel, "Post");
                        break;
                    case "Comment":
                        cardLayout.show(cardPanel, "Comment");
                        break;
                    
                    case "Setting":
                        cardLayout.show(cardPanel, "Setting");
                        break;
                    case "Logout":
                        cardLayout.show(cardPanel, "Logout");
                        break;
                }
            }
        });

        // Set the layout for the frame
        frame.setLayout(new BorderLayout());
        frame.add(sideBar, BorderLayout.WEST);  // Add sidebar to the left
        frame.add(cardPanel, BorderLayout.CENTER);  // Add card panel to the center

        // Set the frame visible
        frame.setVisible(true);
    }
}
