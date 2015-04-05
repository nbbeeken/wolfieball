/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import wolfieball.gui.dialog.DialogType;
import wolfieball.gui.dialog.FXMLDialog;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class MainGUI implements Initializable {
    @FXML
    private TextArea infoArea;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fileMenu;
    @FXML
    private Menu editMenu;
    @FXML
    private Menu helpMenu;
    @FXML
    private Button newDraftBtn;
    @FXML
    private Button loadDraftBtn;
    @FXML
    private Tab playerTab;
    @FXML
    private TableView<?> playerTable;
    @FXML
    private TableColumn<?, ?> lastNameCol;
    @FXML
    private TableColumn<?, ?> firstNameCol;
    @FXML
    private TableColumn<?, ?> teamCol;
    @FXML
    private TableColumn<?, ?> othPosCol;
    @FXML
    private TableColumn<?, ?> runsCol;
    @FXML
    private TableColumn<?, ?> homeRunsCol;
    @FXML
    private TableColumn<?, ?> runsBatInCol;
    @FXML
    private TableColumn<?, ?> stolenBasesCol;
    @FXML
    private TableColumn<?, ?> battingAvgCol;
    @FXML
    private TableColumn<?, ?> salaryCol;
    @FXML
    private RadioButton firstBasemanRbtn;
    @FXML
    private RadioButton secondBasemanRbtn;
    @FXML
    private RadioButton thirdBasemanRbtn;
    @FXML
    private RadioButton cornerInfielderRbtn;
    @FXML
    private RadioButton catcherRbtn;
    @FXML
    private RadioButton shortStopRbtn;
    @FXML
    private RadioButton middleInfieldRbtn;
    @FXML
    private RadioButton outfielderRbtn;
    @FXML
    private RadioButton utilityRbtn;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchBtn;
    @FXML
    private ImageView playerImage;
    @FXML
    private Label playerLbl;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private TextArea bioArea;
    @FXML
    private Tab fantasyTab;
    @FXML
    private Tab standingsTab;
    @FXML
    private Tab draftTab;
    @FXML
    private Tab mlbTeamsTab;

    private final ToggleGroup group = new ToggleGroup();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initRadioBtns();

        newDraftBtn.setOnAction(e -> {
            try {
                showDialog();
            } catch (IOException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                
    }    
    
    
    private void initRadioBtns() {
        firstBasemanRbtn.setToggleGroup(group);
        secondBasemanRbtn.setToggleGroup(group);
        thirdBasemanRbtn.setToggleGroup(group);
        cornerInfielderRbtn.setToggleGroup(group);
        catcherRbtn.setToggleGroup(group);
        shortStopRbtn.setToggleGroup(group);
        middleInfieldRbtn.setToggleGroup(group);
        outfielderRbtn.setToggleGroup(group);
        utilityRbtn.setToggleGroup(group);
    }    

    private void showDialog() throws IOException, Exception {
        Stage s = new Stage();
        FXMLDialog dialog = new FXMLDialog(DialogType.NewPlayer);
        dialog.start(s);
        
    }  
    
}
