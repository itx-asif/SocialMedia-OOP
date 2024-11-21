/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author malik
 */
public class PostPanel extends JPanel{
    PostPanel(){
             setBackground(Color.LIGHT_GRAY);
         JButton searchButton = new JButton("Refresh Posts");
        searchButton.setBounds(420, 100, 100, 30);
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(searchButton);
    }
}
