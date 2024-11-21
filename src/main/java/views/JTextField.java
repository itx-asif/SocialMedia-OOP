/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;

/**
 *
 * @author itxas
 */
public class JTextField extends javax.swing.JTextField {
    	private Shape shape;
	private String hint;
    public JTextField(String hint) {
        super();
		this.hint = hint;
		setFont(new Font("Segoe UI", Font.BOLD, 20));
		setOpaque(false);
		setText(hint);
		setForeground(Color.BLACK);
		setBorder(BorderFactory.createEmptyBorder(TOP, 20, BOTTOM, 20));
                   addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals("")) {
					setText(hint);
					setForeground(Color.BLACK);}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(hint)) {
					setText("");
					setForeground(Color.BLACK);
				}
			}
		});
    }
 

	    
}
