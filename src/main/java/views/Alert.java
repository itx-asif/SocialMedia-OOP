/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.*;
/**
 *
 * @author itxas
 */
public class Alert extends JFrame {
    public Alert(String error){     
                JOptionPane.showMessageDialog(this, error);
    }
}
