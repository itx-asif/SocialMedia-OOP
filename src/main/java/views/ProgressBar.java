package views;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;

public class ProgressBar {
    public ProgressBar() {
        // Create frame and panel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("LINKUP", JLabel.CENTER);

        // Set up frame properties
        frame.setSize(600, 200);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);

        // Set label properties
        label.setForeground(Color.decode("#f2aa4c"));
        label.setFont(new Font("Segoe UI", Font.BOLD, 32));

        // Set panel properties
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(53, 84, 76, 84));
        panel.add(label, BorderLayout.NORTH);

        // Create and configure progress bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
         //progressBar.setIndeterminate(false);
        progressBar.setForeground(Color.decode("#f2aa4c"));
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(false);

      
        panel.add(progressBar, BorderLayout.SOUTH);

        // Add panel to frame and show frame
        frame.add(panel);
        frame.setVisible(true);

        // Progress bar update loop
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(30);
                progressBar.setValue(i);
                if (i == 100) {
                    frame.dispose();
                    new Welcome();  // Assuming Welcome is another class you are launching
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
