/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author itxas
 */
public class JFrame extends javax.swing.JFrame {
    public JFrame(){
    super("Social Media Platform");
		getContentPane().setBackground(Color.white);
		setSize(900, 625);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
                setResizable(false);
//               Icon set by umair
//                Any confusion cordinate to me
             ImageIcon image=new ImageIcon("C:\\Users\\malik\\Pictures\\image1.jpeg");
        setIconImage(image.getImage());
    }
    
}
