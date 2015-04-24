/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui;


import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Neal
 */
public class WolfieballDraftKitApp extends Application {
    
    private static HostServices host;

    public static HostServices getHost() {
        return host;
    }
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        host = getHostServices();
        Parent root = FXMLLoader.load(getClass().getResource("WolfieBallDraftKitFXML.fxml"));
        Scene scene = new Scene(root);
        
        String css = WolfieballDraftKitApp.class.getResource("wolfieball.css").toExternalForm();
        
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        
        stage.setWidth(bounds.getWidth() / 1.5);
        stage.setHeight(bounds.getHeight() / 1.2);
        //stage.setFullScreen(true);
        
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
