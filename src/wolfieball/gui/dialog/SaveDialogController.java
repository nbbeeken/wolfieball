/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui.dialog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import wolfieball.data.Draft;
import wolfieball.data.DraftManager;
import wolfieball.file.JsonDraftFileManager;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class SaveDialogController implements Initializable {
    
    @FXML
    private Button cancelBtn;

    @FXML
    private Label lbl;

    @FXML
    private Button noBtn;

    @FXML
    private Button yesBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initControls(JsonDraftFileManager jsonManager, boolean wantsQuit){
        
        if(wantsQuit)lbl.setText("Do you wish to save your Draft and Quit?");
        
        yesBtn.setOnAction(e ->{
            try {
                Stage w = (Stage) ((Node) e.getTarget()).getScene().getWindow();
                Draft draft = DraftManager.getDraftManager().getDraft();
                jsonManager.saveDraft(draft);
                if(wantsQuit)System.exit(0);
                w.close();
            } catch (IOException ex) {
                Logger.getLogger(SaveDialogController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        noBtn.setOnAction(e -> {
            Stage w = (Stage) ((Node) e.getTarget()).getScene().getWindow();
            if(wantsQuit)System.exit(0);
            w.close();
        });
        
        cancelBtn.setOnAction(e -> {
            Stage w = (Stage) ((Node) e.getTarget()).getScene().getWindow();
            w.close();
        });
    }
    
}
