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
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
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
import wolfieball.gui.MainGUI;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class EditPlayerDialogFXMLController implements Initializable {    
    @FXML
    private ComboBox<Team> fantasyTeamCombo;
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
    
    
    
    



    public void initControls(BaseballPlayer bp, MainGUI gui) {
                
        
        nameLbl.setText(bp.getFIRST_NAME() + " " + bp.getLAST_NAME());
        positionsLbl.setText(bp.getQP().replace('_', ' '));
        
        contractCombo.getItems().addAll("S1", "S2", "X");
        contractCombo.getSelectionModel().selectFirst();
        
        fantasyTeamCombo.getItems().clear();

        DraftManager.getDraftManager().getDraft().getTeams().entrySet().stream().map((team) -> (Team) team.getValue()).forEach((value) -> {
            fantasyTeamCombo.getItems().add(value);
        });
        fantasyTeamCombo.getItems().add(DraftManager.getDraftManager().getDraft().getFreeAgents());
        fantasyTeamCombo.getSelectionModel().select(DraftManager.getDraftManager().getDraft().getTeams().get(bp.getFantasyTeam()));
        if(fantasyTeamCombo.getSelectionModel().isEmpty()){
            fantasyTeamCombo.getSelectionModel().selectLast();
        }
        
        String [] pos = bp.getQP().split("_");
        positionCombo.getItems().addAll(Arrays.asList(pos));
        
        
        if(fantasyTeamCombo.getValue().getName().equals("Free Agent")){
                positionCombo.setDisable(true);
                contractCombo.setDisable(true);
                salaryField.setDisable(true);
            }else{
                positionCombo.setDisable(false);
                contractCombo.setDisable(false);
                salaryField.setDisable(false);
        }
        
        
        fantasyTeamCombo.setOnAction(e -> {
            Team selectTeam = fantasyTeamCombo.getValue();
            if(selectTeam.getName().equals("Free Agent")){
                positionCombo.setDisable(true);
                contractCombo.setDisable(true);
                salaryField.setDisable(true);
            }else{
                positionCombo.setDisable(false);
                contractCombo.setDisable(false);
                salaryField.setDisable(false);
            }
            if (!selectTeam.equals(DraftManager.getDraftManager().getDraft().getFreeAgents())) {
                if (selectTeam.getNumberOfCatchers() == 2 && positionCombo.getItems().contains("C")) {
                    positionCombo.getItems().remove("C");
                }

                if (selectTeam.getNumberOfCornerInfielder() == 1 && positionCombo.getItems().contains("CI")) {
                    positionCombo.getItems().remove("CI");
                }

                if (selectTeam.getNumberOfFirstbasemen() == 1 && positionCombo.getItems().contains("1B")) {
                    positionCombo.getItems().remove("1B");
                }

                if (selectTeam.getNumberOfSecondbasemen() == 1 && positionCombo.getItems().contains("2B")) {
                    positionCombo.getItems().remove("2B");
                }

                if (selectTeam.getNumberOfThirdbasemen() == 1 && positionCombo.getItems().contains("3B")) {
                    positionCombo.getItems().remove("3B");
                }

                if (selectTeam.getNumberOfPitchers() == 9 && positionCombo.getItems().contains("P")) {
                    positionCombo.getItems().remove("P");
                }

                if (selectTeam.getNumberOfSS() == 1 && positionCombo.getItems().contains("SS")) {
                    positionCombo.getItems().remove("SS");
                }

                if (selectTeam.getNumberOfMI() == 1 && positionCombo.getItems().contains("MI")) {
                    positionCombo.getItems().remove("MI");
                }

                if (selectTeam.getNumberOfU() == 1 && positionCombo.getItems().contains("U")) {
                    positionCombo.getItems().remove("U");
                }

                if (selectTeam.getNumberOfOF() == 1 && positionCombo.getItems().contains("OF")) {
                    positionCombo.getItems().remove("OF");
                }

                if (selectTeam.getNumberOfPlayer() == 23) {
                    positionCombo.getItems().clear();
                }
            }
        });
        
        
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
            okAction(e, bp, gui);
            
        });
        
        cancelBtn.setOnAction(e -> {
            Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
            window.close();
        });
        
    }

    private void okAction(ActionEvent e, BaseballPlayer bp, MainGUI gui) throws NumberFormatException {
        Stage window = (Stage)((Node)e.getTarget()).getScene().getWindow();
        
        
        
        if(!fantasyTeamCombo.getSelectionModel().isEmpty() && !positionCombo.getSelectionModel().isEmpty() && !salaryField.getText().isEmpty() || salaryField.disabledProperty().get()){
            Team selectedTeam = fantasyTeamCombo.getSelectionModel().getSelectedItem();
            DraftManager.getDraftManager().getDraft().getDraftOrder().remove(bp);
            
            ObservableMap<String, Team> teams = DraftManager.getDraftManager().getDraft().getTeams();
            gui.print(bp.getFantasyTeam());
            if(bp.getFantasyTeam().equals("Free Agent")){
                DraftManager.getDraftManager().getDraft().getFreeAgents().removePlayer(bp);
            }else{
                Team currentTeam = teams.get(bp.getFantasyTeam());
                currentTeam.removePlayer(bp);
            }

            bp.setFantasyTeam(selectedTeam.getName());
            
            
            bp.setFantasyPosition(positionCombo.getSelectionModel().getSelectedItem());
            bp.setContract(contractCombo.getSelectionModel().getSelectedItem());
            if(!salaryField.getText().isEmpty())bp.setSalary(Double.parseDouble(salaryField.getText()));
            
            if(bp.getContract().equals("S2") && !bp.getFantasyTeam().equals("Free Agent"))DraftManager.getDraftManager().getDraft().getDraftOrder().add(bp);
            
            if(selectedTeam.getName().equals("Free Agent")){
                bp.setContract("");
                bp.setFantasyPosition("");
                bp.setSalary(0);
                DraftManager.getDraftManager().getDraft().getFreeAgents().addPlayer(bp);
            }else{
               if(bp.getContract().equals("X")){
                   selectedTeam.getTaxi().add(bp);
               }else{
                   selectedTeam.addPlayer(bp);
               }
                
            }
            
            window.close();
            
            
            
            
            if(!fantasyTeamCombo.getValue().getName().equals("Free Agent")){
                gui.setSelectedFantasyTeam(fantasyTeamCombo.getValue());
                gui.setFantasyTableData(fantasyTeamCombo.getValue().getPlayers());
            }
            
            gui.getPlayerTable().setItems(DraftManager.getDraftManager().getDraft().getFreeAgents().getPlayers());
            //gui.getFantasyPlayers().getItems().sort(new FantasyTeamPositionComparator());
        }else{
            errorLbls.setVisible(true);
        }
    }
    
}
