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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import wolfieball.data.DraftManager;
import wolfieball.data.Team;
import wolfieball.gui.MainGUI;

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

    public void initControls(boolean isEditing, Team team, MainGUI gui) {
        String originalTeam = team.getName();
        if(isEditing){
            teamOwnerFld.setText(team.getOwner());
            teamNameFld.setText(team.getName());
        }
        teamCreateBtn.setOnAction(e1 -> {
            Team t = new Team("");
            Stage w = (Stage) ((Node) e1.getTarget()).getScene().getWindow();
            if(isEditing) t = DraftManager.getDraftManager().getDraft().getTeams().get(originalTeam);
            if (!teamNameFld.getText().trim().isEmpty() && !teamOwnerFld.getText().trim().isEmpty()) {
                t.setName(teamNameFld.getText());
                t.setOwner(teamOwnerFld.getText());
                w.close();
                DraftManager.getDraftManager().getDraft().getTeams().put(teamNameFld.getText(),t);
                
                ObservableList list = FXCollections.observableArrayList();
                DraftManager.getDraftManager().getDraft().getTeams().entrySet().stream().map((teamIT) -> (Team) teamIT.getValue()).forEach((value) -> {
                    list.add(value);
                });
                
                gui.getfTeamCombo().setItems(list);
                gui.getfTeamCombo().getItems().remove(DraftManager.getDraftManager().getDraft().getFreeAgents());
                
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
