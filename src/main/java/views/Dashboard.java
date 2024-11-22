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



//     

        // Add panels to the cardPanel with unique names
        cardPanel.add(new HomePanel(), "Home");
        cardPanel.add(new PostPanel(), "Post");
        cardPanel.add(new CommentPanel(), "Comment");
       
        cardPanel.add(new SettingPanel(), "Setting");
        

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
                        System.exit(0);
                        
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
