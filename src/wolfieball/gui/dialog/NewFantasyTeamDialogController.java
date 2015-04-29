/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui.dialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import wolfieball.data.DraftManager;
import wolfieball.data.Team;

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
        teamCreateBtn.setOnAction(e1 -> {
            Stage w = (Stage) ((Node) e1.getTarget()).getScene().getWindow();
            if (!teamNameFld.getText().trim().isEmpty() && !teamOwnerFld.getText().trim().isEmpty()) {
                Team t = new Team();
                t.setName(teamNameFld.getText());
                t.setOwner(teamOwnerFld.getText());
                w.close();
                DraftManager.getDraftManager().getDraft().getTeams().add(t);
            } else {
                teamErrorLbl.setText("Please Enter Values");
            }
        });
        teamCancelBtn.setOnAction(e2 -> {
            Stage w = (Stage) ((Node) e2.getTarget()).getScene().getWindow();
            w.close();
        });
    }
    
}
