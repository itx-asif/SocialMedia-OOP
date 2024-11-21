/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomePanel extends JPanel {

    public HomePanel() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("Home - Show All Posts");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(100, 50, 300, 30);
        add(heading);

        JTextField searchField = new JTextField();
        searchField.setBounds(100, 100, 300, 30);
        add(searchField);

        JButton searchButton = new JButton("Button");
        searchButton.setBounds(420, 100, 100, 30);
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(searchButton);
    }
}
