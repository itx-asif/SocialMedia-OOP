/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author itxas
 */
public class Alert {
    public Alert(String error){
        JFrame frame = new JFrame("Error");
                JOptionPane.showMessageDialog(frame, frame, error, 0);

    }
}
