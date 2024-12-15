package socialmedia.oop;



import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;


import javax.swing.UIManager;
import views.*;

public class SocialMediaOOP {

    public static void main(String[] args) {
   
        // Register custom theme defaults with error handling
        try {
            FlatLaf.registerCustomDefaultsSource("Register.Themes");
           
            FlatMacLightLaf.setup();
            UIManager.put( "Component.arc", 999 );
           
            
        } catch (Exception e) {
            System.err.println("Error loading custom themes: " + e.getMessage());
        }

        // Set default font for all components
      

        // Launch the application
        new ProgressBar();
        
  
    }
}
