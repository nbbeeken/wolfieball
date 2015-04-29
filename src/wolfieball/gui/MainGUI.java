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
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import wolfieball.data.BaseballPlayer;
import wolfieball.data.DraftManager;
import wolfieball.data.Team;
import wolfieball.gui.dialog.EditPlayerDialogFXMLController;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class MainGUI implements Initializable {
    @FXML
    private AnchorPane startRoot;
    @FXML
    private ImageView splash;
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
    @FXML
    private Hyperlink hplink;
    @FXML
    private Window window;
    
    /* Fantasy Team Tab FX:id's*/
    
    @FXML
    private Button addFTeamBtn;
    @FXML
    private Button deleteFTeamBtn;
    @FXML
    private Button editFTeamBtn;
    @FXML
    private ComboBox<String> fTeamCombo;
    @FXML
    private TextField draftNameField;
    @FXML
    private TableView<BaseballPlayer> fantasyPlayers;
    @FXML
    private TableView<BaseballPlayer> taxiSquad;
    
    
    
    
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
        this.draftManager = DraftManager.getDraftManager();
        
//        splash.fitWidthProperty().bind(startRoot.widthProperty());
//        splash.fitHeightProperty().bind(startRoot.heightProperty());
//        splash.setFitWidth(1354);
//        splash.setFitHeight(820);
        
        playersTabInit();
        fantasyTabInit();
        standingTabInit();
        draftTabInit();
        mlbTabInit();
        infoArea.setText("Start Program");
    }     

    
    private void fantasyTabInit(){
        initFantasyHeader();
    }
    
    private void playersTabInit() {
        initRadioBtns();
        initTabs();
        initButtons();
        setUpTable();
        setUpTableSearchFilter();
    }     

    private void standingTabInit(){
        
    }
    
    private void draftTabInit(){
        
    }
    
    private void mlbTabInit(){
        
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
        hplink.setOnAction(e -> {
            WolfieballDraftKitApp.getHost().showDocument("http://www.rebeccamock.com/");
        });
        
        //Set Events
        headerQuitBtn.setOnAction((ActionEvent e) ->{
            draftManager.saveAndQuitRequest(this);
        });
        //New Buttons Pair
        headerNewBtn.setOnAction((ActionEvent e) ->{
            window = ((Node)e.getTarget()).getScene().getWindow();
            draftManager.newDraftRequest(this);
            playerData.setAll(draftManager.getDraft().getMlb());
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        newDraftBtn.setOnAction((ActionEvent e) ->{
            window = ((Node)e.getTarget()).getScene().getWindow();
            draftManager.newDraftRequest(this);
            playerData.setAll(draftManager.getDraft().getMlb());
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        //Load Buttons Pair
        headerLoadBtn.setOnAction((ActionEvent e) ->{
            window = ((Node)e.getTarget()).getScene().getWindow();
            draftManager.loadDraftRequest(this, window);
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        loadDraftBtn.setOnAction((ActionEvent e) ->{
            window = ((Node)e.getTarget()).getScene().getWindow();
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
        
        playerData.addListener((ListChangeListener.Change<? extends BaseballPlayer> c) -> {
                c.next();
                headerSaveBtn.setDisable(false);
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
    
    /**
     *  Prints to developer Field
     * @param input
     */
    public void print(String input){
        infoArea.appendText("\n");
        infoArea.appendText(input);
    }

    private void setUpTableSearchFilter() {
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
            setFilterPredicate(filteredData, newValue);
            SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
            playerTable.setItems(filteredData);
        });
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
            setFilterPredicate(filteredData, newValue);
            SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
            playerTable.setItems(filteredData);
        });
        
        fTeamCombo.setOnAction(e -> {
            String selection = fTeamCombo.getSelectionModel().getSelectedItem();
            FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
            
            setFilterPredicateFantasy(filteredData, "");
    
            SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(fantasyPlayers.comparatorProperty());
            fantasyPlayers.setItems(filteredData);
        });
        
//        fTeamCombo.selectionModelProperty().addListener((observable, oldValue, newValue) -> {
//            //String selectedTeam = observable.getSelectedItem();
//            FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
//            
//            setFilterPredicateFantasy(filteredData, "Astros");
//            
//            SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
//            sortedData.comparatorProperty().bind(fantasyPlayers.comparatorProperty());
//            fantasyPlayers.setItems(filteredData);
//        });
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
            if (player.getFIRST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().contains("Free Agent")) {
                return true; // Filter matches first name.
            } else if (player.getLAST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().contains("Free Agent")) {
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
            if (player.getFIRST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().contains("Free Agent")) {
                return true; // Filter matches first name.
            } else if (player.getLAST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().contains("Free Agent")) {
                return true; // Filter matches last name.
            }
            return false; // Does not match.
        });
    }
    
    private void setFilterPredicateFantasy(FilteredList<BaseballPlayer> filteredData, String newValue){
        filteredData.setPredicate(player -> {
            return player.getFantasyTeam().equals(newValue); 
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
        fantasyPlayers.setItems(playerData);
        taxiSquad.setItems(playerData);
        
        playerTable.setOnMouseClicked(e -> {
            if(e.getClickCount() == 2){
                BaseballPlayer bp = playerTable.getSelectionModel().getSelectedItem();
                editPlayerDialog(bp);
            }
        });
    }

    /**
     *  Returns current playerData
     * @return
     */
    public ObservableList<BaseballPlayer> getPlayerData() {
        return playerData;
    }

    private void initFantasyHeader() {
        
        addFTeamBtn.setOnAction(e -> {
            newFanTeamDialog();
        });
        
        deleteFTeamBtn.setOnAction(e -> {
            
        });
        
        editFTeamBtn.setOnAction(e -> {
            
            
        });
        
        draftNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            draftManager.getDraft().setName(newValue);
        });
        
        //fTeamCombo.getSelectionModel().clearSelection();
        draftManager.getDraft().getTeams().addListener((ListChangeListener.Change<? extends Team> c) -> {
            c.next();
            String newTeamName = c.getAddedSubList().get(0).getName();
            fTeamCombo.getItems().add(newTeamName);
            fTeamCombo.getSelectionModel().select(newTeamName);
        });
        
    }

    private void newFanTeamDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("dialog/newFantasyTeamDialogFXML.fxml"));
            Parent dialogPane;
            dialogPane = (Parent) fxmlLoader.load();
            Scene sc = new Scene(dialogPane);
            Stage st = new Stage();
            st.setScene(sc);
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(window);
            st.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editPlayerDialog(BaseballPlayer bp) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("dialog/editPlayerDialogFXML.fxml"));
            Parent dialogPane = (Parent) fxmlLoader.load();
            EditPlayerDialogFXMLController controller = fxmlLoader.getController();
            controller.setPlayerToEdit(bp);
            controller.initControls();
            Scene sc = new Scene(dialogPane);
            Stage st = new Stage();
            st.setScene(sc);
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(window);
            st.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
