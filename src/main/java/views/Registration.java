/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import Controller.CreateUser;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.event.*;

//import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.TOP;
import models.Database;
import models.User;
/**
 *
 * @author malik
 */
public class Registration {
   public Registration(Database DB){
       JFrame frame = new JFrame();

       
		JPanel panel = new JPanel(new BorderLayout());
              panel.setBorder(BorderFactory.createEmptyBorder(60, 40, 17, 30));
                
		//panel.setBackground(Color.LIGHT_GRAY);
                 JLabel titleLabel = new JLabel("Register Now!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centers the text
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Increases font size and makes it bold

        panel.add(titleLabel, BorderLayout.NORTH); 
		
		JPanel center = new JPanel(new GridLayout(6, 1, 10, 10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
		JTextField firstName = new JTextField("First Name");
		center.add(firstName);
		JTextField lastName = new JTextField("Last Name");
		center.add(lastName);
		JTextField email = new JTextField("Email");
		center.add(email);
		JTextField password = new JTextField("Password");
		center.add(password);
		JTextField confirmPassword = new JTextField("Confirm Password");
		center.add(confirmPassword);
                
           
		    JButton createAcc = new JButton("Create Account");
        createAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           
               if(firstName.getText().equals("")){
                    
                
                JOptionPane.showMessageDialog(frame, "fill the required fields");
            }
               if(lastName.getText().equals("")){
                    
                
                JOptionPane.showMessageDialog(frame, "fill the required fields");
            }
               if(email.getText().equals("")){
                    
                
                JOptionPane.showMessageDialog(frame, "fill the required fields");
            }
               if(password.getText().equals("")){
                    
                
                JOptionPane.showMessageDialog(frame, "fill the required fields");
            }
               boolean Equal = password.getText().equals(confirmPassword.getText());
                          if(!Equal){
                    
                              System.out.println(password.getText());
                                System.out.println(confirmPassword.getText());
                JOptionPane.showMessageDialog(frame, "password dont match");
                              }
                             User u = new User();
				u.setFirstName(firstName.getText());
				u.setLastName(lastName.getText());
				u.setEmail(email.getText());
				u.setPassword(password.getText());
				CreateUser create = new CreateUser(u, DB);
                                if (!create.isEmailUsed()) {
					create.create();
					
					 new Dashboard(create.getUser(),DB);
					frame.dispose();
				} else {
					 JOptionPane.showMessageDialog(frame, "user Exists");
				}
        }
        });
  

        center.add(createAcc);

        panel.add(center, BorderLayout.CENTER);
        frame.add(panel, "width 400, height 500");
        frame.setVisible(true);
                
       
    }
    
}
