/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui.dialog;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import wolfieball.data.BaseballPlayer;
import wolfieball.data.DraftManager;
import wolfieball.data.Team;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class EditPlayerDialogFXMLController implements Initializable {
    private BaseballPlayer bp;
    
    @FXML
    private ComboBox<String> fantasyTeamCombo;
    @FXML
    private ComboBox<String> positionCombo;
    @FXML
    private ComboBox<String> contractCombo;
    @FXML
    private TextField salaryField;
    @FXML
    private Button okBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private ImageView playerPic;
    @FXML
    private ImageView nationFlag;
    @FXML
    private Label nameLbl;
    @FXML
    private Label positionsLbl;
    @FXML
    private VBox errorLbls;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        salaryField.textProperty().addListener((observable, old, newValue) -> {
            String value = observable.getValue();
            try {
                Integer.parseInt(value);
                salaryField.textProperty().setValue(value);
            } catch (Exception e) {
                salaryField.textProperty().setValue("");
            }
        });

    }
    
    
    
    
    public BaseballPlayer getPlayerToEdit() {
        return bp;
    }

    public void setPlayerToEdit(BaseballPlayer playerToEdit) {
        this.bp = playerToEdit;
    }

    public void initControls() {
                
        
        nameLbl.setText(bp.getFIRST_NAME() + " " + bp.getLAST_NAME());
        positionsLbl.setText(bp.getQP().replace('_', ' '));
        
        contractCombo.getItems().addAll("S1", "S2", "X");
        contractCombo.getSelectionModel().selectFirst();
        
        ObservableList<Team> teams = DraftManager.getDraftManager().getDraft().getTeams();
        teams.stream().forEach((team) -> {
            fantasyTeamCombo.getItems().add(team.getName());
        });
        fantasyTeamCombo.getItems().add("Free Agent");
        fantasyTeamCombo.getSelectionModel().selectLast();
        
        String [] pos = bp.getQP().split("_");
        positionCombo.getItems().addAll(Arrays.asList(pos));
        
        
        String defaultPlayerimg = "file:./images/dialog/players/AAA-defaultPlayer.png";
        String defaultFlagimg = "file:./images/dialog/flags/earth.png";
                
        String imgPlayerPath = "file:./images/dialog/players/" + bp.getLAST_NAME() + bp.getFIRST_NAME() + ".jpg"; 
        String imgFlagPath = "file:./images/dialog/flags/" + bp.getNATION_OF_BIRTH() + ".png";
        
        Image playerProfile = new Image(imgPlayerPath);
        Image flagPic = new Image(imgFlagPath);
        
        if(playerProfile.isError()){
            playerProfile = new Image(defaultPlayerimg);
            playerPic.setImage(playerProfile);
        }else{
            playerPic.setImage(playerProfile);
        }
        if(flagPic.isError()){
            flagPic = new Image(defaultFlagimg);
            nationFlag.setImage(flagPic);
        }else{
            nationFlag.setImage(flagPic);
        }
        
        nationFlag.setImage(new Image(imgFlagPath));
        
        okBtn.setOnAction(e -> {
            Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
            if(!fantasyTeamCombo.getSelectionModel().isEmpty() && !positionCombo.getSelectionModel().isEmpty() && !salaryField.getText().isEmpty()){
                bp.setFantasyTeam(fantasyTeamCombo.getSelectionModel().getSelectedItem());
                bp.setFantasyPosition(positionCombo.getSelectionModel().getSelectedItem());
                bp.setContract(contractCombo.getSelectionModel().getSelectedItem());
                bp.setSalary(Double.parseDouble(salaryField.getText()));
                window.close();
            }else{
                errorLbls.setVisible(true);
            }
            
        });
        
        cancelBtn.setOnAction(e -> {
            Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
            window.close();
        });
        
    }
    
}
