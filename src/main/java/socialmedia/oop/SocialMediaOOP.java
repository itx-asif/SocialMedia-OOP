package socialmedia.oop;


//import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
//import com.formdev.flatlaf.FlatLightLaf;
  import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
//import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
//import java.util.Collections;
import javax.swing.UIManager;
import views.*;

public class SocialMediaOOP {

    public static void main(String[] args) {
        // Install custom font
      //  FlatRobotoFont.install();

        // Register custom theme defaults with error handling
        try {
            FlatLaf.registerCustomDefaultsSource("Register.Themes");
           
            FlatMacDarkLaf.setup();
            UIManager.put( "Component.arc", 999 );
           
            
        } catch (Exception e) {
            System.err.println("Error loading custom themes: " + e.getMessage());
        }

        // Set default font for all components
      

        // Launch the application
        EventQueue.invokeLater(() -> new ProgressBar());
        
  
    }
}
