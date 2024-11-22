/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.TOP;
/**
 *
 * @author malik
 */
public class Registration {
   public Registration(){
       JFrame frame = new JFrame();
//	frame.setSize(900,625);
//        frame.setLocationRelativeTo(null);
       
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.LIGHT_GRAY);
                 JLabel titleLabel = new JLabel("Register Now!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centers the text
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Increases font size and makes it bold

        panel.add(titleLabel, BorderLayout.NORTH); 
		
		JPanel center = new JPanel(new GridLayout(6, 1, 10, 10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(60, 231, 17, 231));
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
                
//                confirmPassword.setFont(new Font("Segoe UI", Font.BOLD, 20));
//                
//		confirmPassword.setOpaque(false);
//		confirmPassword.setForeground(Color.decode("#f2aa4c"));
//		confirmPassword.setBorder(BorderFactory.createEmptyBorder(TOP, 20, BOTTOM, 10));
                
		    JButton createAcc = new JButton("Create Account");
        createAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                if(firstName.getText().equals("")){
                    
                
                JOptionPane.showMessageDialog(frame, "We will verify you");
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
