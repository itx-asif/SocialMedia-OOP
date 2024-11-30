/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 
package views;

import Controller.ReadUser;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JTextField;
import javax.swing.SwingConstants;
import models.Database;


/**
 *
 * @author malik
 */
public class Login {
   public Login(Database DB){
       JFrame frame = new JFrame();

		JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(60, 40, 17, 30));
		//panel.setBackground(Color.LIGHT_GRAY);
                 JLabel titleLabel = new JLabel("Login Now!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centers the text
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Increases font size and makes it bold

        panel.add(titleLabel, BorderLayout.NORTH); 
		
		JPanel center = new JPanel(new GridLayout(6, 1, 10, 10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    JLabel Emaillabel = new JLabel("Email");
		JTextField email = new JTextField("Email");
                email.setFont(new Font("Roboto", Font.PLAIN, 16));
                		center.add(Emaillabel);
		center.add(email);
                JLabel Passwordlabel = new JLabel("Password");
		JTextField password = new JTextField("Password");
                center.add(Passwordlabel);
		center.add(password);
		
                
           
		    JButton createAcc = new JButton("Login");
        createAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(email.getText().equals("")){
                    
                
                new Alert("fill the required fields");
            }
               if(password.getText().equals("")){
                    
                
                new Alert("fill the required fields");
            }          
               
               ReadUser U = new ReadUser(email.getText(),password.getText(),DB);
               if(U.isloggedIn()){
                      new Dashboard(U.getUser(),DB);
                      frame.dispose();
               }
               else{
                   new Alert("User not Found");
               }
                  
                
                
            }
       
        });
 

        center.add(createAcc);

        panel.add(center, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
                
       
    }
    
}
