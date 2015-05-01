/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui.dialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import wolfieball.data.BaseballPlayer;
import wolfieball.data.DraftManager;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class AddNewPlayerDialogFXMLController implements Initializable {

    @FXML
    private ComboBox<String> proTeamCombo;

    @FXML
    private CheckBox chkC;

    @FXML
    private CheckBox chk1B;

    @FXML
    private CheckBox chkP;

    @FXML
    private CheckBox chk2B;

    @FXML
    private CheckBox chkSS;

    @FXML
    private Button cancelBtn;

    @FXML
    private CheckBox chk3B;

    @FXML
    private Button addPlayerBtn;

    @FXML
    private TextField firstNameFld;

    @FXML
    private TextField lastNameFld;

    @FXML
    private CheckBox chkOF;
    
    private final ObservableList<CheckBox> checks = FXCollections.observableArrayList();
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checks.addAll(chkC, chk1B, chkP, chk2B, chkSS, chk3B, chkOF);
        proTeamCombo.getItems().addAll( "ATL", "AZ", "CHC", 
                                        "CIN", "COL", "LAD", 
                                        "MIA", "MIL", "NYM", 
                                        "PHI", "PIT", "SD", 
                                        "SF", "STL", "WAS");
    }    
    
    public void initControls(){
        addPlayerBtn.setOnAction(e ->{
            Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
            if(!firstNameFld.getText().isEmpty() || !lastNameFld.getText().isEmpty() || proTeamCombo.getValue() != null){
                BaseballPlayer newPlayer = new BaseballPlayer();
                newPlayer.setFIRST_NAME(firstNameFld.getText());
                newPlayer.setLAST_NAME(lastNameFld.getText());
                newPlayer.setTEAM(proTeamCombo.getValue());
                newPlayer.setFantasyTeam("Free Agent");
                String pos = "";
                for(CheckBox chk : checks){
                    if(chk.isSelected()){
                        pos += chk.getText() + "_";
                    }
                }
                if(pos.endsWith("_")){
                    pos = pos.substring(0, pos.length()-1);
                }
                newPlayer.setQP(pos);
                DraftManager.getDraftManager().getDraft().getFreeAgents().addPlayer(newPlayer);
                window.close();
            }else{
                System.out.println("Bad Juju");
            }
        });
        
        cancelBtn.setOnAction(e -> {
            Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
            window.close();
        });
    }
    
}
