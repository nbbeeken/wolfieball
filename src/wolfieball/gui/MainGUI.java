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
import wolfieball.data.DraftManager;

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
    private TableColumn<?, ?> yearOfBirthCol; 
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
    private Tab fantasyTab;
    @FXML
    private Tab standingsTab;
    @FXML
    private Tab draftTab;
    @FXML
    private Tab startTab;
    @FXML
    private Tab mlbTeamsTab;
    @FXML
    private RadioButton allRbtn;
    @FXML
    private Button headerNewBtn;
    @FXML
    private Button headerLoadBtn;
    @FXML
    private Button headerSaveBtn;
    @FXML
    private Button headerExportBtn;
    @FXML
    private Button headerQuitBtn;
    

    private final ToggleGroup group = new ToggleGroup();
    
    private DraftManager draftManager;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initRadioBtns();
        initTabs();
        initButtons();
                
    }    

    private void initTabs() {
        //Start Tabs Off until New or Load selected
        playerTab.setDisable(true);
        draftTab.setDisable(true);
        fantasyTab.setDisable(true);
        standingsTab.setDisable(true);
        mlbTeamsTab.setDisable(true);
    }    
    
    
    private void initRadioBtns() {
        //Add to Toggle Group
        allRbtn.setToggleGroup(group);
        firstBasemanRbtn.setToggleGroup(group);
        secondBasemanRbtn.setToggleGroup(group);
        thirdBasemanRbtn.setToggleGroup(group);
        cornerInfielderRbtn.setToggleGroup(group);
        catcherRbtn.setToggleGroup(group);
        shortStopRbtn.setToggleGroup(group);
        middleInfieldRbtn.setToggleGroup(group);
        outfielderRbtn.setToggleGroup(group);
        utilityRbtn.setToggleGroup(group);
        //Set Events
        
    }      

    private void initButtons() {
        //Set Events
        headerQuitBtn.setOnAction(e ->{
            System.exit(0);
        });
        //New Buttons Pair
        headerNewBtn.setOnAction(e ->{
            try{
                draftManager.newDraftRequest();
            }catch(UnsupportedOperationException exxx){
                System.out.println("YOOOOOOOOOOOO");
            }
            
        });
        newDraftBtn.setOnAction(e ->{
            draftManager.newDraftRequest();
        });
        //Load Buttons Pair
        headerLoadBtn.setOnAction(e ->{
            draftManager.loadDraftRequest();
        });
        loadDraftBtn.setOnAction(e ->{
            draftManager.loadDraftRequest();
        });
    }
    
}
