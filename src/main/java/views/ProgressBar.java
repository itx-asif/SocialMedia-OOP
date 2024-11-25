/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Box;
import javax.swing.BoxLayout;




public class ProgressBar {
 public ProgressBar(){
      javax.swing.JFrame frame = new javax.swing.JFrame();
        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel();

        frame.setSize(600, 200);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        l1.setText("LINKUP");
        l1.setForeground(Color.decode("#f2aa4c"));
        l1.setFont(new java.awt.Font("Segoe UI", 3, 32));
        l1.setHorizontalAlignment(JLabel.CENTER);

        p1.setLayout(new BorderLayout());
        p1.setBorder(BorderFactory.createEmptyBorder(53, 84, 76, 84));
        p1.setBackground(Color.white);

        p1.add(l1, BorderLayout.NORTH);

        JPanel progressPanel = new JPanel();
        progressPanel.setBackground(Color.white);
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.Y_AXIS));

        progressPanel.add(Box.createVerticalStrut(10));

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(false);
        progressBar.setValue(0);
        progressBar.setMaximum(100);
        progressBar.setForeground(Color.decode("#f2aa4c"));
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(false);

        progressPanel.add(progressBar);
        p1.add(progressPanel, BorderLayout.SOUTH);
        frame.add(p1);

       frame.setAlwaysOnTop(true);
     frame.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(10);
                progressBar.setValue(i);
                if(i==100){
                    
                 frame.dispose();
                new Welcome();
                    
                   
            
                }
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      
      
  
   }
}
