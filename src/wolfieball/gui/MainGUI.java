/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import wolfieball.data.BaseballPlayer;
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
    private Button newDraftBtn;
    @FXML
    private Button loadDraftBtn;
    @FXML
    private Tab playerTab;
    @FXML
    private TableView<BaseballPlayer> playerTable;
    @FXML
    private TableColumn lastNameCol;
    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn teamCol;
    @FXML
    private TableColumn positionsCol;
    @FXML
    private TableColumn R_WCol;
        @FXML
        private TableColumn RCol;
        @FXML
        private TableColumn WCol;   
    @FXML
    private TableColumn HR_SVCol;
        @FXML
        private TableColumn HRCol;
        @FXML
        private TableColumn SVCol;
    @FXML
    private TableColumn RBI_KCol;
        @FXML
        private TableColumn RBICol;
        @FXML
        private TableColumn KCol;
    @FXML
    private TableColumn SB_ERACol;
        @FXML
        private TableColumn SBCol;
        @FXML
        private TableColumn ERACol;
    @FXML
    private TableColumn BA_WHIPCol;
        @FXML
        private TableColumn BACol;
        @FXML
        private TableColumn WHIPCol;    
    @FXML
    private TableColumn estimatedValueCol;
    @FXML
    private TableColumn yearOfBirthCol;
    @FXML
    private TableColumn notesCol; 
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
    
    //My Fields
    private final ToggleGroup group = new ToggleGroup();
    private DraftManager draftManager;
    private final ObservableList<BaseballPlayer> playerData = FXCollections.observableArrayList();
    ArrayList<TableColumn> superCol;
    ArrayList<TableColumn> subCol;
    ArrayList<TableColumn> hitterCol;
    ArrayList<TableColumn> pitcherCol;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        addTestPlayer();
        this.draftManager = new DraftManager();
        initRadioBtns();
        initTabs();
        initButtons();
        setUpTable();
        setUpTableSearchFilter();
        
        infoArea.setText("Start Program");
    }    

    private void addTestPlayer() {
        BaseballPlayer p = new BaseballPlayer();
        p.setAB(1);
        p.setBA(2);
        p.setBB(3);
        p.setER(4);
        p.setERA(5);
        p.setEstimatedValue(6);
        p.setFIRST_NAME("Neal");
        p.setH(7);
        p.setHR(8);
        p.setIP(9);
        p.setK(10);
        p.setLAST_NAME("Beeken");
        p.setNATION_OF_BIRTH("HBIC Land");
        p.setNOTES("Cool Kid");
        p.setQP(";)");
        p.setR(11);
        p.setRBI(12);
        p.setSB(13);
        p.setSV(14);
        p.setTEAM("GAY");
        p.setW(15);
        p.setWHIP(16);
        p.setYEAR_OF_BIRTH(1995);
        playerData.add(p);
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
        group.selectToggle(allRbtn);
        //Set Events
        
        
        firstBasemanRbtn.setOnAction(e ->{
            String positionToFilter="1B";
            setPositionTableFilter(positionToFilter);
        });
        
        
        
    }      

    private void initButtons() {
        //Main Buttons:
        headerSaveBtn.setDisable(true);
        headerExportBtn.setDisable(true);
        
        //Set Events
        headerQuitBtn.setOnAction((ActionEvent e) ->{
            draftManager.saveAndQuitRequest(this);
        });
        //New Buttons Pair
        headerNewBtn.setOnAction((ActionEvent e) ->{
            playerData.setAll(draftManager.newDraftRequest(this));
            userStartsEditing();
        });
        newDraftBtn.setOnAction((ActionEvent e) ->{
            playerData.setAll(draftManager.newDraftRequest(this));
            userStartsEditing();
        });
        //Load Buttons Pair
        headerLoadBtn.setOnAction((ActionEvent e) ->{
            playerData.setAll(draftManager.loadDraftRequest(this));
            userStartsEditing();
        });
        loadDraftBtn.setOnAction((ActionEvent e) ->{
            playerData.setAll(draftManager.loadDraftRequest(this));
            userStartsEditing();
        });
        headerSaveBtn.setOnAction(e ->{
            draftManager.saveRequest(this);
        });
        headerExportBtn.setOnAction(e ->{
            draftManager.exportRequest(this);
        });
        
        //BaseballPlayers Tab:
        addBtn.setOnAction(e ->{
            draftManager.addPlayerRequest(this);
        });
        removeBtn.setOnAction(e -> {
            draftManager.removePlayerRequest(this);
        });
    }
    
    public void userStartsEditing(){
        startTab.getTabPane().getTabs().remove(startTab);
        playerTab.setDisable(false);
        draftTab.setDisable(false);
        fantasyTab.setDisable(false);
        standingsTab.setDisable(false);
        mlbTeamsTab.setDisable(false);
        headerSaveBtn.setDisable(false);
        headerExportBtn.setDisable(false);
    }
    
    public void print(String input){
        infoArea.appendText("\n");
        infoArea.appendText(input);
    }

    private void setUpTableSearchFilter() {
        
        
        
        FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(player -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (player.getFIRST_NAME().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (player.getLAST_NAME().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
        
        // 3. Wrap the FilteredList in a SortedList. 
		SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		playerTable.setItems(sortedData);
    }

    private void setUpTable() {
        superCol = new ArrayList<>();
        subCol = new ArrayList<>();
        hitterCol = new ArrayList<>();
        pitcherCol = new ArrayList<>();
        
        

        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("LAST_NAME"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory("FIRST_NAME"));
        teamCol.setCellValueFactory(new PropertyValueFactory("TEAM"));
        positionsCol.setCellValueFactory(new PropertyValueFactory("QP"));
        estimatedValueCol.setCellValueFactory(new PropertyValueFactory("estimatedValue"));
        yearOfBirthCol.setCellValueFactory(new PropertyValueFactory("YEAR_OF_BIRTH"));
        notesCol.setCellValueFactory(new PropertyValueFactory("NOTES"));
        
        superCol.add(R_WCol);
        superCol.add(HR_SVCol);
        superCol.add(RBI_KCol);
        superCol.add(SB_ERACol);
        superCol.add(BA_WHIPCol);
        
        RCol.setCellValueFactory(new PropertyValueFactory("R"));
        WCol.setCellValueFactory(new PropertyValueFactory("W"));
        subCol.add(RCol);
        hitterCol.add(RCol);
        subCol.add(WCol);
        pitcherCol.add(WCol);

        HRCol.setCellValueFactory(new PropertyValueFactory("HR"));
        SVCol.setCellValueFactory(new PropertyValueFactory("SV"));
        subCol.add(HRCol);
        hitterCol.add(HRCol);
        subCol.add(SVCol);
        pitcherCol.add(SVCol);
        
        
        RBICol.setCellValueFactory(new PropertyValueFactory("RBI"));
        KCol.setCellValueFactory(new PropertyValueFactory("K"));
        subCol.add(RBICol);
        hitterCol.add(RBICol);
        subCol.add(KCol);
        pitcherCol.add(KCol);
        
        SBCol.setCellValueFactory(new PropertyValueFactory("SB"));
        ERACol.setCellValueFactory(new PropertyValueFactory("ERA"));
        subCol.add(SBCol);
        hitterCol.add(SBCol);
        subCol.add(ERACol);
        pitcherCol.add(ERACol);

        BACol.setCellValueFactory(new PropertyValueFactory("BA"));
        WHIPCol.setCellValueFactory(new PropertyValueFactory("WHIP"));
        subCol.add(BACol);
        hitterCol.add(BACol);
        subCol.add(WHIPCol);
        pitcherCol.add(WHIPCol);
        
        playerTable.setItems(playerData);
    }

    private void setPositionTableFilter(String positionToFilter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
