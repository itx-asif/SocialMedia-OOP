package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Button extends JButton {
private Color color;
    private Color hoverColor;
    private Color borderColor;
    private int radius;
  
    public void setColor(Color color) {
        this.color = color;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
 

    public Color getColor() {
        return color;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public int getRadius() {
        return radius;
    }

    

    public Button(Color c,Color tcolor,Color bcolor,int r) {
        
        this.radius = r; // default radius
        this.color = c; 
        setForeground(tcolor);
        this.borderColor = bcolor; // default border color

        setBorderPainted(false);
        setContentAreaFilled(false);

        // Change color on hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                borderColor=hoverColor;
                color=    Color.decode("#f2aa4c");
                setForeground(hoverColor);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                borderColor=bcolor;
                setForeground(tcolor);
                color =  Color.decode("#f5f5f5");
                setBackground(Color.decode("#f5f5f5"));
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Anti-aliasing for smooth graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getRadius(), getRadius());

        // Fill button with color
        g2.setColor(color);
        g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, getRadius(), getRadius());
        super.paintComponent(g);
    }
}


