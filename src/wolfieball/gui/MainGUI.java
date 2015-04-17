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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
            setCurrentFilter("");
        });
        
        firstBasemanRbtn.setOnAction(e ->{
            setCurrentFilter("1B");
        });
    
        secondBasemanRbtn.setOnAction(e -> {
            setCurrentFilter("2B");
        });
        thirdBasemanRbtn.setOnAction(e -> {
            setCurrentFilter("3B");
        });
        cornerInfielderRbtn.setOnAction(e -> {
            setCurrentFilter("CI");
        });
        catcherRbtn.setOnAction(e -> {
            setCurrentFilter("C");
        });
        shortStopRbtn.setOnAction(e ->{
            setCurrentFilter("SS");
        });
        middleInfieldRbtn.setOnAction(e -> {
            setCurrentFilter("MI");
        });
        outfielderRbtn.setOnAction(e -> {
            setCurrentFilter("OF");
        });
        utilityRbtn.setOnAction(e -> {
            setCurrentFilter("U");
        });
        pitcherRbtn.setOnAction(e -> {
            setCurrentFilter("P");
        });
        
        
    }   
    
    private void setCurrentFilter(String filter) {
        FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
        filteredData.setPredicate(player -> {
            String lowerCaseFilter = filter.toLowerCase();
            return player.getQP().toLowerCase().contains(lowerCaseFilter);
        });
        SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
        playerTable.setItems(sortedData);
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
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (player.getFIRST_NAME().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (player.getLAST_NAME().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });
        SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
        playerTable.setItems(sortedData);
    }

    private void setUpTable() {
        superCol = new ArrayList<>();
        subCol = new ArrayList<>();
        hitterCol = new ArrayList<>();
        pitcherCol = new ArrayList<>();
        
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

    private void hidePitcherColumns() {
        pitcherCol.stream().forEach((tc) -> {
            tc.setVisible(false);
        });
    }
    
    private void hideHitterColumns() {
        hitterCol.stream().forEach((tc) -> {
            tc.setVisible(false);
        });
    }
    
    private void showAllColumns() {
        subCol.stream().forEach((tc) -> {
            tc.setVisible(true);
            //playerTable.getColumns().remove(tc);
        });
    }
    
}
