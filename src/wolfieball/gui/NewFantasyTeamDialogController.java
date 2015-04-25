/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Neal
 */
public class NewFantasyTeamDialogController implements Initializable{
        /*Team create Dialog*/
  
    @FXML
    private TextField teamOwnerFld;
    @FXML
    private TextField teamNameFld;
    @FXML
    private Button teamCreateBtn;
    @FXML
    private Button teamCancelBtn;
    @FXML
    private Label teamErrorLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
