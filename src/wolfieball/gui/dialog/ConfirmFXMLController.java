/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui.dialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import wolfieball.gui.MainGUI;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class ConfirmFXMLController implements Initializable {
    @FXML
    Button yesBtn;
    @FXML
    Button cancelBtn;
    @FXML
    Label mssg;
    
    boolean usrInput;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public boolean initControls(String message, MainGUI gui){
        
        
        mssg.setText(message);
        
        
        yesBtn.setOnAction((ActionEvent e) -> {
            Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
            gui.deleteTeamDialog();
            gui.refreshTables();
            setUsrInput(true);
            window.close();
        });
        cancelBtn.setOnAction((ActionEvent e) -> {
            Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
            setUsrInput(false);
            window.close();
        });
        
        return isUsrInput();
    }

    public void setUsrInput(boolean usrInput) {
        this.usrInput = usrInput;
    }

    public boolean isUsrInput() {
        return usrInput;
    }
    
    
    
}
