/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author malik
 */
public class CommentPanel extends JPanel {
  public CommentPanel() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("You can Comment here!");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(100, 50, 300, 30);
        add(heading);

        JTextField searchField = new JTextField();
        searchField.setBounds(100, 100, 300, 30);
        add(searchField);

        JButton searchButton = new JButton("Comment");
        searchButton.setBounds(420, 100, 120, 30);
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(searchButton);
    }
}
