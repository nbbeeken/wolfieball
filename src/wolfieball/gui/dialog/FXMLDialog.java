/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui.dialog;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Neal
 */
public class FXMLDialog extends Application{
    DialogType dialogType;
    String fxmlRequested;
    
    public FXMLDialog(DialogType dialogType) {
        this.dialogType = dialogType;
        switch(dialogType){
            case NewDraft:
                
                break;
            case LoadDraft:
                fxmlRequested = ".fxml";
                break;
            case SaveDraft:
                fxmlRequested = ".fxml";
                break;
            case SaveAsDraft:
                fxmlRequested = ".fxml";
                break;
            case ExportDraft:
                fxmlRequested = ".fxml";
                break;
            case ExitCheck:
                fxmlRequested = ".fxml";
                break;
            case EditPlayer:
                fxmlRequested = ".fxml";
                break;
            case NewPlayer:
                fxmlRequested = "NewPlayerFXML.fxml";
                break;
            case RemovePlayerCheck:
                fxmlRequested = ".fxml";
                break;
            
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File f = new File(fxmlRequested);
        if(!f.exists()) fxmlRequested = "Error.fxml";
        
        Parent root = FXMLLoader.load(getClass().getResource(fxmlRequested));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
