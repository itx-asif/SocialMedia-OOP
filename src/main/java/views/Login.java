/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 
package views;

import java.awt.*;
import java.awt.event.*;
//import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.SwingConstants;


/**
 *
 * @author malik
 */
public class Login {
   public Login(){
       JFrame frame = new JFrame();
//	frame.setSize(900,625);
//        frame.setLocationRelativeTo(null);
       
		JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(60, 40, 17, 30));
		panel.setBackground(Color.LIGHT_GRAY);
                 JLabel titleLabel = new JLabel("Login Now!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centers the text
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Increases font size and makes it bold

        panel.add(titleLabel, BorderLayout.NORTH); 
		
		JPanel center = new JPanel(new GridLayout(6, 1, 10, 10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(60, 231, 17, 231));
                    JLabel Emaillabel = new JLabel("Email");
		JTextField email = new JTextField("Email");
                		center.add(Emaillabel);
		center.add(email);
                JLabel Passwordlabel = new JLabel("Password");
		JTextField password = new JTextField("Password");
                center.add(Passwordlabel);
		center.add(password);
		
                
//                confirmPassword.setFont(new Font("Segoe UI", Font.BOLD, 20));
//                
//		confirmPassword.setOpaque(false);
//		confirmPassword.setForeground(Color.decode("#f2aa4c"));
//		confirmPassword.setBorder(BorderFactory.createEmptyBorder(TOP, 20, BOTTOM, 10));
                
		    JButton createAcc = new JButton("Login");
        createAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                if(firstName.getText().equals("")){
                  
                      new Dashboard();
                  
                  
                
                
            }
//        }
        });
//     firstName.addFocusListener(new FocusListener() {
//    @Override
//    public void focusGained(FocusEvent e) {
//        firstName.setText("");  // Assuming 'firstName' is a JTextField
//    }
//
//    @Override
//    public void focusLost(FocusEvent e) {
//        // You can leave this empty or add some logic here
//    }
//});

        center.add(createAcc);

        panel.add(center, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
                
       
    }
    
}
