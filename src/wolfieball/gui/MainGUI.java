/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Window;
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
        private TableColumn RCol;
        @FXML
        private TableColumn WCol;   
    
        @FXML
        private TableColumn HRCol;
        @FXML
        private TableColumn SVCol;

        @FXML
        private TableColumn RBICol;
        @FXML
        private TableColumn KCol;

        @FXML
        private TableColumn SBCol;
        @FXML
        private TableColumn ERACol;

        @FXML
        private TableColumn BACol;
        @FXML
        private TableColumn WHIPCol;   
        
    @FXML
    private TableColumn hitterStatCol;
    @FXML
    private TableColumn pitcherStatCol;
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
    private RadioButton pitcherRbtn;
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
    private TabPane tabPane;
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
    private int clickCount;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.draftManager = new DraftManager();
        initRadioBtns();
        initTabs();
        initButtons();
        setUpTable();
        setUpTableSearchFilter();
        
        searchField.setOnAction(e -> {
            setUpTableSearchFilter();
        });
        
        infoArea.setText("Start Program");
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
        pitcherRbtn.setToggleGroup(group);
        group.selectToggle(allRbtn);
        //Set Events
        
        allRbtn.setOnAction(e ->{
            //setCurrentFilter("");
            pitcherStatCol.setVisible(true);
            hitterStatCol.setVisible(true);
        });
        
        firstBasemanRbtn.setOnAction(e ->{
            //setCurrentFilter("1B");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
    
        secondBasemanRbtn.setOnAction(e -> {
            //setCurrentFilter("2B");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        thirdBasemanRbtn.setOnAction(e -> {
            //setCurrentFilter("3B");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        cornerInfielderRbtn.setOnAction(e -> {
            //setCurrentFilter("CI");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        catcherRbtn.setOnAction(e -> {
            //setCurrentFilter("C_");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        shortStopRbtn.setOnAction(e ->{
            //setCurrentFilter("SS");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        middleInfieldRbtn.setOnAction(e -> {
            //setCurrentFilter("MI");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        outfielderRbtn.setOnAction(e -> {
            //setCurrentFilter("OF");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        utilityRbtn.setOnAction(e -> {
            //setCurrentFilter("U");
            pitcherStatCol.setVisible(false);
            hitterStatCol.setVisible(true);
        });
        pitcherRbtn.setOnAction(e -> {
            //setCurrentFilter("P");
            pitcherStatCol.setVisible(true);
            hitterStatCol.setVisible(false);
        });
        
        
    }   

    private void initButtons(){
        //Main Buttons:
        headerSaveBtn.setDisable(true);
        headerExportBtn.setDisable(true);
        
        //Set Events
        headerQuitBtn.setOnAction((ActionEvent e) ->{
            draftManager.saveAndQuitRequest(this);
        });
        //New Buttons Pair
        headerNewBtn.setOnAction((ActionEvent e) ->{
            draftManager.newDraftRequest(this);
            playerData.setAll(draftManager.getDraft().getMlb());
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        newDraftBtn.setOnAction((ActionEvent e) ->{
            draftManager.newDraftRequest(this);
            playerData.setAll(draftManager.getDraft().getMlb());
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        //Load Buttons Pair
        headerLoadBtn.setOnAction((ActionEvent e) ->{
            Window window = ((Node)e.getTarget()).getScene().getWindow();
            draftManager.loadDraftRequest(this, window);
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        loadDraftBtn.setOnAction((ActionEvent e) ->{
            Window window = ((Node)e.getTarget()).getScene().getWindow();
            draftManager.loadDraftRequest(this, window);
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        headerSaveBtn.setOnAction(e -> {
            draftManager.saveRequest(this);
            headerSaveBtn.setDisable(true);
        });
        
        playerData.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                headerSaveBtn.setDisable(false);
            }
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
    
    private void userStartsEditing(){
        startTab.getTabPane().getTabs().remove(startTab);
        playerTab.setDisable(false);
        draftTab.setDisable(false);
        fantasyTab.setDisable(false);
        standingsTab.setDisable(false);
        mlbTeamsTab.setDisable(false);
        headerExportBtn.setDisable(false);
        
        tabPane.getSelectionModel().select(fantasyTab);
    }
    
    public void print(String input){
        infoArea.appendText("\n");
        infoArea.appendText(input);
    }

    private void setUpTableSearchFilter() {
        FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            setFilterPredicate(filteredData, newValue);
        });
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            setFilterPredicate(filteredData, newValue);
        });
//        SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
        playerTable.setItems(filteredData);
    }

    private void setFilterPredicate(FilteredList<BaseballPlayer> filteredData, String newValue) {
        filteredData.setPredicate(player -> {
            String pos = "";
            Toggle t = group.getSelectedToggle();
            
            if(t == allRbtn)pos="";
            if(t == firstBasemanRbtn)pos="1B";
            if(t == secondBasemanRbtn)pos="2B";
            if(t == thirdBasemanRbtn)pos="3B";
            if(t == cornerInfielderRbtn)pos="CI";
            if(t == catcherRbtn)pos="C_";
            if(t == shortStopRbtn)pos="SS";
            if(t == middleInfieldRbtn)pos="MI";
            if(t == outfielderRbtn)pos="OF";
            if(t == utilityRbtn)pos="U";
            if(t == pitcherRbtn)pos="P";
            
            
            
            if (newValue == null || newValue.isEmpty())
                return true;
            
            
            String lowerCaseFilter = newValue.toLowerCase();
            if (player.getFIRST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos)) {
                return true; // Filter matches first name.
            } else if (player.getLAST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos)) {
                return true; // Filter matches last name.
            }
            return false; // Does not match.
        });
    }
    
    private void setFilterPredicate(FilteredList<BaseballPlayer> filteredData, Toggle newValue) {
        filteredData.setPredicate(player -> {
            String pos = "";
            Toggle t = newValue;
            
            if(t == allRbtn)pos="";
            if(t == firstBasemanRbtn)pos="1B";
            if(t == secondBasemanRbtn)pos="2B";
            if(t == thirdBasemanRbtn)pos="3B";
            if(t == cornerInfielderRbtn)pos="CI";
            if(t == catcherRbtn)pos="C_";
            if(t == shortStopRbtn)pos="SS";
            if(t == middleInfieldRbtn)pos="MI";
            if(t == outfielderRbtn)pos="OF";
            if(t == utilityRbtn)pos="U";
            if(t == pitcherRbtn)pos="P";
            
            String lowerCaseFilter = searchField.getText().toLowerCase();
            if (player.getFIRST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos)) {
                return true; // Filter matches first name.
            } else if (player.getLAST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos)) {
                return true; // Filter matches last name.
            }
            return false; // Does not match.
        });
    }

    private void setUpTable() {

        
        playerTable.setEditable(true);
        

        lastNameCol.setCellValueFactory(new PropertyValueFactory("LAST_NAME"));
        
        
        firstNameCol.setCellValueFactory(new PropertyValueFactory("FIRST_NAME"));
        teamCol.setCellValueFactory(new PropertyValueFactory("TEAM"));
        positionsCol.setCellValueFactory(new PropertyValueFactory("QP"));
        estimatedValueCol.setCellValueFactory(new PropertyValueFactory("estimatedValue"));
        yearOfBirthCol.setCellValueFactory(new PropertyValueFactory("YEAR_OF_BIRTH"));
        notesCol.setCellValueFactory(new PropertyValueFactory("NOTES"));
        
        notesCol.setCellFactory(TextFieldTableCell.forTableColumn());
        notesCol.setOnEditCommit(new EventHandler<CellEditEvent<BaseballPlayer, String>>() {
            @Override
            public void handle(CellEditEvent t) {
                ((BaseballPlayer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setNOTES((String)t.getNewValue());
            }
        });
        
        
        RCol.setCellValueFactory(new PropertyValueFactory("R"));
        WCol.setCellValueFactory(new PropertyValueFactory("W"));


        HRCol.setCellValueFactory(new PropertyValueFactory("HR"));
        SVCol.setCellValueFactory(new PropertyValueFactory("SV"));
        
        
        RBICol.setCellValueFactory(new PropertyValueFactory("RBI"));
        KCol.setCellValueFactory(new PropertyValueFactory("K"));

        
        SBCol.setCellValueFactory(new PropertyValueFactory("SB"));
        ERACol.setCellValueFactory(new PropertyValueFactory("ERA"));


        BACol.setCellValueFactory(new PropertyValueFactory("BA"));
        WHIPCol.setCellValueFactory(new PropertyValueFactory("WHIP"));

        playerTable.setItems(playerData);
    }

    public ObservableList<BaseballPlayer> getPlayerData() {
        return playerData;
    }
    
    
    
}
