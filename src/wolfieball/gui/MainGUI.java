/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.gui;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.control.TableCell;
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
import javafx.util.Callback;
import javafx.util.StringConverter;
import wolfieball.data.BaseballPlayer;
import wolfieball.data.DraftManager;
import wolfieball.data.MLBPlayer;
import wolfieball.data.Team;
import wolfieball.data.compare.FantasyTeamPositionComparator;
import wolfieball.data.compare.TeamComparator;
import wolfieball.file.JsonDraftFileManager;
import wolfieball.gui.dialog.AddNewPlayerDialogFXMLController;
import wolfieball.gui.dialog.ConfirmFXMLController;
import wolfieball.gui.dialog.ConfirmType;
import wolfieball.gui.dialog.EditPlayerDialogFXMLController;
import wolfieball.gui.dialog.NewFantasyTeamDialogController;
import wolfieball.gui.dialog.SaveDialogController;

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
    private TableColumn lastNameFanCol;
    @FXML
    private TableColumn firstNameFanCol;
    @FXML
    private TableColumn teamFanCol;
    @FXML
    private TableColumn positionsFanCol;
    
        @FXML
        private TableColumn RFanCol;
        @FXML
        private TableColumn WFanCol;   
    
        @FXML
        private TableColumn HRFanCol;
        @FXML
        private TableColumn SVFanCol;

        @FXML
        private TableColumn RBIFanCol;
        @FXML
        private TableColumn KFanCol;

        @FXML
        private TableColumn SBFanCol;
        @FXML
        private TableColumn ERAFanCol;

        @FXML
        private TableColumn BAFanCol;
        @FXML
        private TableColumn WHIPFanCol;   
        
    @FXML
    private TableColumn hitterStatFanCol;
    @FXML
    private TableColumn pitcherStatFanCol;
    @FXML
    private TableColumn yearOfBirthFanCol;
    @FXML
    private TableColumn contractFanCol;
    @FXML
    private TableColumn salaryFanCol;
    
    @FXML
    private TableColumn lastNameTaxCol;
    @FXML
    private TableColumn firstNameTaxCol;
    @FXML
    private TableColumn teamTaxCol;
    @FXML
    private TableColumn positionsTaxCol;
    
        @FXML
        private TableColumn RTaxCol;
        @FXML
        private TableColumn WTaxCol;   
    
        @FXML
        private TableColumn HRTaxCol;
        @FXML
        private TableColumn SVTaxCol;

        @FXML
        private TableColumn RBITaxCol;
        @FXML
        private TableColumn KTaxCol;

        @FXML
        private TableColumn SBTaxCol;
        @FXML
        private TableColumn ERATaxCol;

        @FXML
        private TableColumn BATaxCol;
        @FXML
        private TableColumn WHIPTaxCol;   
        
    @FXML
    private TableColumn hitterStatTaxCol;
    @FXML
    private TableColumn pitcherStatTaxCol;
    @FXML
    private TableColumn yearOfBirthTaxCol;
    @FXML
    private TableColumn contractTaxCol;
    @FXML
    private TableColumn salaryTaxCol;
    
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
    private ComboBox<Team> fTeamCombo;
    @FXML
    private TextField draftNameField;
    @FXML
    private TableView<BaseballPlayer> fantasyPlayers;
    @FXML
    private TableView<BaseballPlayer> taxiSquad;
    
    /* Fantasy Standings Tab */
    
    @FXML
    private TableView<Team> standingsTable;
    
    @FXML
    private TableColumn teamNameStdCol;
    @FXML
    private TableColumn playersNeededStdCol;
    @FXML
    private TableColumn moneyLeftStdCol;
    @FXML
    private TableColumn moneyPerPlayerStdCol;
    @FXML
    private TableColumn R_StdCol;
    @FXML
    private TableColumn HR_StdCol;
    @FXML
    private TableColumn RBI_StdCol;
    @FXML
    private TableColumn SB_StdCol;
    @FXML
    private TableColumn BA_StdCol;
    @FXML
    private TableColumn W_StdCol;
    @FXML
    private TableColumn SV_StdCol;
    @FXML
    private TableColumn K_StdCol;
    @FXML
    private TableColumn ERA_StdCol;
    @FXML
    private TableColumn WHIP_StdCol;
    @FXML
    private TableColumn totalPointsStdCol;
    
    
    /* Draft Summary Tab */
    
    @FXML
    private Button bestPlayerBtn;
    @FXML
    private Button startAutoDraftBtn;
    @FXML
    private Button stopAutoDraftBtn;
    @FXML
    private TableView<BaseballPlayer> draftPickTable;
    @FXML
    private TableColumn pickNumCol;
    @FXML
    private TableColumn firstNameDraftSumCol;
    @FXML
    private TableColumn lastNameDraftSumCol;
    @FXML
    private TableColumn fantasyTeamCol;
    @FXML
    private TableColumn contractDraftSumCol;
    @FXML
    private TableColumn salaryDraftSumCol;
    
    /* MLB Teams Tab */
    
    @FXML
    private ComboBox<String> mlbCombo;
    @FXML
    private TableView<MLBPlayer> mlbPlayersTable;
    @FXML
    private TableColumn lastNameMlbCol;
    @FXML
    private TableColumn firstNameMlbCol;
    @FXML
    private TableColumn positionsMlbCol;
    
    
    //My Fields
    private final ToggleGroup group = new ToggleGroup();
    private DraftManager draftManager;
    private ObservableList<BaseballPlayer> playerData = FXCollections.observableArrayList();
    private int clickCount;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.draftManager = DraftManager.getDraftManager();
        playersTabInit();
        fantasyTabInit();
        standingTabInit();
        draftTabInit();
        mlbTabInit();
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
        standingsTab.setOnSelectionChanged((Event e) -> {
            ObservableList<Team> list;
            list = DraftManager.getDraftManager().getDraft().mapToList();
            list.stream().forEach(t -> {
                t.recalculate();
            });
            draftManager.getDraft().calcTotalPts();
            standingsTable.setItems(list);
        });
        
        standingsTable.setOnMouseClicked(e -> {
            if(e.getClickCount() == 2){
                Team selectedItem = standingsTable.getSelectionModel().getSelectedItem();
                print(selectedItem.completePrint());
                System.out.println(selectedItem.completePrint());
            }
        });
        
        teamNameStdCol.setCellValueFactory(new PropertyValueFactory("name"));
        playersNeededStdCol.setCellValueFactory(new PropertyValueFactory("neededPlayers"));
        
        moneyLeftStdCol.setCellValueFactory(new PropertyValueFactory("money"));
        moneyPerPlayerStdCol.setCellValueFactory(new PropertyValueFactory("moneyPerPlayer"));
        
        R_StdCol.setCellValueFactory(new PropertyValueFactory("R"));
        R_StdCol.setCellFactory(decimalTruncateTeam(0));
        HR_StdCol.setCellValueFactory(new PropertyValueFactory("HR"));
        HR_StdCol.setCellFactory(decimalTruncateTeam(0));
        RBI_StdCol.setCellValueFactory(new PropertyValueFactory("RBI"));
        RBI_StdCol.setCellFactory(decimalTruncateTeam(0));
        SB_StdCol.setCellValueFactory(new PropertyValueFactory("SB"));
        SB_StdCol.setCellFactory(decimalTruncateTeam(0));
        BA_StdCol.setCellValueFactory(new PropertyValueFactory("BA"));
        BA_StdCol.setCellFactory(decimalTruncateTeam(3));
        W_StdCol.setCellValueFactory(new PropertyValueFactory("W"));
        W_StdCol.setCellFactory(decimalTruncateTeam(0));
        SV_StdCol.setCellValueFactory(new PropertyValueFactory("SV"));
        SV_StdCol.setCellFactory(decimalTruncateTeam(0));
        K_StdCol.setCellValueFactory(new PropertyValueFactory("K"));
        K_StdCol.setCellFactory(decimalTruncateTeam(0));
        ERA_StdCol.setCellValueFactory(new PropertyValueFactory("ERA"));
        ERA_StdCol.setCellFactory(decimalTruncateTeam(2));
        WHIP_StdCol.setCellValueFactory(new PropertyValueFactory("WHIP"));
        WHIP_StdCol.setCellFactory(decimalTruncateTeam(2));
        totalPointsStdCol.setCellValueFactory(new PropertyValueFactory("totalPoints"));
        totalPointsStdCol.setCellFactory(decimalTruncateTeam(0));
        
        
    }
    
    private void draftTabInit(){
        draftPickTable.setItems(draftManager.getDraft().getDraftOrder());
//        pickNumCol.setCellValueFactory(p -> {
//            return new ReadOnlyObjectWrapper(draftPickTable.getItems().indexOf(p));
//        }); 
//        pickNumCol.setSortable(false);
        
        firstNameDraftSumCol.setCellValueFactory(new PropertyValueFactory("FIRST_NAME"));
        lastNameDraftSumCol.setCellValueFactory(new PropertyValueFactory("LAST_NAME"));
        fantasyTeamCol.setCellValueFactory(new PropertyValueFactory("fantasyTeam"));
        contractDraftSumCol.setCellValueFactory(new PropertyValueFactory("contract"));
        salaryDraftSumCol.setCellValueFactory(new PropertyValueFactory("salary"));
        
        bestPlayerBtn.setOnAction(e -> {
            ObservableList<Team> list = FXCollections.observableArrayList();
            DraftManager.getDraftManager().getDraft().getTeams().entrySet().stream().map((teamIT) -> (Team) teamIT.getValue()).forEach((value) -> {
                //value.recalculate();
                list.add(value);
            });
            Collections.sort(list, new TeamComparator());
            ObservableList<BaseballPlayer> freePlayers = draftManager.getDraft().getFreeAgents().getPlayers();
            BaseballPlayer bestPlayer = freePlayers.get(0);
            for(BaseballPlayer bp : freePlayers){
                if( (bp.getRank() > bestPlayer.getRank())  && bp.getFantasyTeam().equals("Free Agent")){
                    bestPlayer = bp;
                }
            }
            bestPlayer.setSalary(1);
            for(Team t : list){
                if (!t.getName().equals("Free Agent") && t.draftable(bestPlayer)) {
                    
                    if (t.getNeededPlayers() > 8) {
                        bestPlayer.setContract("S2");
                        bestPlayer.setFantasyTeam(t.getName());
                        t.addPlayer(bestPlayer);
                        draftManager.getDraft().getDraftOrder().add(bestPlayer);
                        break;
                    }
                    if (t.getNeededPlayers() <= 8 && t.getNeededPlayers() > 0) {
                        bestPlayer.setContract("X");
                        bestPlayer.setFantasyTeam(t.getName());
                        t.addPlayer(bestPlayer);
                        draftManager.getDraft().getDraftOrder().add(bestPlayer);
                        break;
                    }
                }
            }
            
        });
        
        startAutoDraftBtn.setOnAction(e -> {
            draftManager.getDraft().autoDraft(false);
            
        });
        
        stopAutoDraftBtn.setOnAction(e -> {
            draftManager.getDraft().autoDraft(true);
        });
    }
    
    private void mlbTabInit(){
        try {
            mlbCombo.getItems().addAll( "ATL",  "AZ", "CHC", "CIN",
                    "COL", "LAD", "MIA", "MIL",
                    "NYM", "PHI", "PIT", "SD" ,
                    "SF" , "STL", "WAS");
            final ObservableList<MLBPlayer> ob = JsonDraftFileManager.loadMLB();
            
            
            lastNameMlbCol.setCellValueFactory(new PropertyValueFactory("lastName"));
            firstNameMlbCol.setCellValueFactory(new PropertyValueFactory("firstName"));
            positionsMlbCol.setCellValueFactory(new PropertyValueFactory("positions"));
            positionsMlbCol.setSortable(false);
            
            mlbCombo.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                mlbPlayersTable.setItems(ob);
                FilteredList<MLBPlayer> filteredData = new FilteredList<>(mlbPlayersTable.getItems(), p -> true);
                filteredData.setPredicate((MLBPlayer player) -> {
                    return player.getProTeam().equals(newValue);
                });
                SortedList<MLBPlayer> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(mlbPlayersTable.comparatorProperty());
                mlbPlayersTable.setItems(sortedData);
            });
            
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        //headerSaveBtn.setDisable(true);
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
            playerData = draftManager.getDraft().getFreeAgents().getPlayers();
            playerTable.setItems(playerData);
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        newDraftBtn.setOnAction((ActionEvent e) ->{
            window = ((Node)e.getTarget()).getScene().getWindow();
            draftManager.newDraftRequest(this);
            playerData = draftManager.getDraft().getFreeAgents().getPlayers();
            playerTable.setItems(playerData);
            if(clickCount <= 0){
                userStartsEditing();
                clickCount++;
            }
        });
        //Load Buttons Pair
        headerLoadBtn.setOnAction((ActionEvent e) ->{
            window = ((Node) e.getTarget()).getScene().getWindow();
            draftManager.loadDraftRequest(this, window);
            
            playerData = draftManager.getDraft().getFreeAgents().getPlayers();
            playerTable.setItems(playerData);
            fantasyPlayers.setItems(FXCollections.observableArrayList());
            ObservableList list = FXCollections.observableArrayList();
            DraftManager.getDraftManager().getDraft().getTeams().entrySet().stream().map((teamIT) -> (Team) teamIT.getValue()).forEach((value) -> {
                list.add(value);
            });
            fTeamCombo.setItems(list);
            fTeamCombo.getItems().remove(draftManager.getDraft().getFreeAgents());
            fTeamCombo.getSelectionModel().clearSelection();
            
            if (clickCount <= 0) {
                userStartsEditing();
                clickCount++;
            }
        });
        loadDraftBtn.setOnAction((ActionEvent e) ->{
            window = ((Node)e.getTarget()).getScene().getWindow();
            draftManager.loadDraftRequest(this, window);
            
            
            playerData = draftManager.getDraft().getFreeAgents().getPlayers();
            playerTable.setItems(playerData);
            fantasyPlayers.setItems(FXCollections.observableArrayList());
            ObservableList list = FXCollections.observableArrayList();
            DraftManager.getDraftManager().getDraft().getTeams().entrySet().stream().map((teamIT) -> (Team) teamIT.getValue()).forEach((value) -> {
                list.add(value);
            });
            fTeamCombo.setItems(list);
            fTeamCombo.getItems().remove(draftManager.getDraft().getFreeAgents());
            fTeamCombo.getSelectionModel().clearSelection();
            
            
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
            addNewPlayerDialog();
        });
        removeBtn.setOnAction(e -> {
            BaseballPlayer bp = playerTable.getSelectionModel().getSelectedItem();
            confirmDialog("Are you sure you want to delete "+ bp.getFIRST_NAME() + " " + bp.getLAST_NAME() +"?", ConfirmType.deletePlayer);
            
        });
        
    }
    
    private void userStartsEditing(){
        startTab.getTabPane().getTabs().remove(startTab);
        playerTab.setDisable(false);
        draftTab.setDisable(false);
        fantasyTab.setDisable(false);
        standingsTab.setDisable(false);
        mlbTeamsTab.setDisable(false);
        //headerExportBtn.setDisable(false);
        
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
    
    private void setUpTable() {

        
        playerTable.setEditable(true);
        positionsFanCol.setComparator(new FantasyTeamPositionComparator());
        positionsCol.setSortType(TableColumn.SortType.ASCENDING);

        setUpAvailiblePlayerTableColTypes();
        setUpFantasyTeamTableColTypes();
        setUpTaxiSquadTableColTypes();


        
        playerTable.setOnMouseClicked(e -> {
            if(e.getClickCount() == 2){
                BaseballPlayer bp = playerTable.getSelectionModel().getSelectedItem();
                editPlayerDialog(bp);
            }
        });
        
        fantasyPlayers.setOnMouseClicked(e -> {
            if(e.getClickCount() == 2){
                BaseballPlayer bp = fantasyPlayers.getSelectionModel().getSelectedItem();
                editPlayerDialog(bp);
            }
        });
    }

    private void setUpTableSearchFilter() {
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            setFilterPredicate(newValue);
        });
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
            setFilterPredicate(filteredData, newValue);
            SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
            playerTable.setItems(sortedData);
        });
        fTeamCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                setFantasyTableData(newValue.getPlayers());
            }
        });
    }

    public void setFilterPredicate(String newValue) {
        FilteredList<BaseballPlayer> filteredData = new FilteredList<>(playerData, p -> true);
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
            
            
            
            if ((newValue == null || newValue.isEmpty()) && player.getFantasyTeam().contains("Free Agent"))
                return true;
            
            
            String lowerCaseFilter = newValue.toLowerCase();
            if (player.getFIRST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().contains("Free Agent")) {
                return true; // Filter matches first name.
            } else if (player.getLAST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().contains("Free Agent")) {
                return true; // Filter matches last name.
            }
            return false; // Does not match.
        });
        SortedList<BaseballPlayer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(playerTable.comparatorProperty());
        playerTable.setItems(sortedData);
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
            if (player.getFIRST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().equals("Free Agent")) {
                return true; // Filter matches first name.
            } else if (player.getLAST_NAME().toLowerCase().startsWith(lowerCaseFilter) && player.getQP().contains(pos) && player.getFantasyTeam().equals("Free Agent")) {
                return true; // Filter matches last name.
            }
            return false; // Does not match.
        });
    }
      
    private void setUpAvailiblePlayerTableColTypes() {
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
        RCol.setCellFactory(decimalTruncate(0));
        WCol.setCellValueFactory(new PropertyValueFactory("W"));
        WCol.setCellFactory(decimalTruncate(0));
        
        
        HRCol.setCellValueFactory(new PropertyValueFactory("HR"));
        HRCol.setCellFactory(decimalTruncate(0));
        SVCol.setCellValueFactory(new PropertyValueFactory("SV"));
        SVCol.setCellFactory(decimalTruncate(0));

        RBICol.setCellValueFactory(new PropertyValueFactory("RBI"));
        RBICol.setCellFactory(decimalTruncate(0));
        KCol.setCellValueFactory(new PropertyValueFactory("K"));
        KCol.setCellFactory(decimalTruncate(0));

        SBCol.setCellValueFactory(new PropertyValueFactory("SB"));
        SBCol.setCellFactory(decimalTruncate(0));
        ERACol.setCellValueFactory(new PropertyValueFactory("ERA"));
        ERACol.setCellFactory(decimalTruncate(2));

        BACol.setCellValueFactory(new PropertyValueFactory("BA"));
        BACol.setCellFactory(decimalTruncate(3));
        WHIPCol.setCellValueFactory(new PropertyValueFactory("WHIP"));
        WHIPCol.setCellFactory(decimalTruncate(2));
    }

    private Callback<TableColumn<BaseballPlayer, Double>, TableCell<BaseballPlayer, Double>> decimalTruncate(int dec) {
        return TextFieldTableCell.<BaseballPlayer, Double>forTableColumn(new StringConverter<Double>() {
            private final NumberFormat nf = NumberFormat.getNumberInstance();
            
            {
                nf.setMaximumFractionDigits(dec);
                nf.setMinimumFractionDigits(dec);
            }

            @Override
            public String toString(final Double value) {
                return nf.format(value);
            }

            @Override
            public Double fromString(final String s) {
                // Don't need this, unless table is editable, see DoubleStringConverter if needed
                return null;
            }
        });
    }
    
    private Callback<TableColumn<Team, Double>, TableCell<Team, Double>> decimalTruncateTeam(int dec) {
        return TextFieldTableCell.<Team, Double>forTableColumn(new StringConverter<Double>() {
            private final NumberFormat nf = NumberFormat.getNumberInstance();
            
            {
                nf.setMaximumFractionDigits(dec);
                nf.setMinimumFractionDigits(dec);
            }

            @Override
            public String toString(final Double value) {
                return nf.format(value);
            }

            @Override
            public Double fromString(final String s) {
                // Don't need this, unless table is editable, see DoubleStringConverter if needed
                return null;
            }
        });
    }
    
    

    private void setUpFantasyTeamTableColTypes() {
        lastNameFanCol.setCellValueFactory(new PropertyValueFactory("LAST_NAME"));
        firstNameFanCol.setCellValueFactory(new PropertyValueFactory("FIRST_NAME"));
        teamFanCol.setCellValueFactory(new PropertyValueFactory("TEAM"));
        positionsFanCol.setCellValueFactory(new PropertyValueFactory("fantasyPosition"));
        RFanCol.setCellValueFactory(new PropertyValueFactory("R"));
        
        WFanCol.setCellValueFactory(new PropertyValueFactory("W"));
        HRFanCol.setCellValueFactory(new PropertyValueFactory("HR"));
        SVFanCol.setCellValueFactory(new PropertyValueFactory("SV"));
        RBIFanCol.setCellValueFactory(new PropertyValueFactory("RBI"));
        KFanCol.setCellValueFactory(new PropertyValueFactory("K"));
        SBFanCol.setCellValueFactory(new PropertyValueFactory("SB"));
        ERAFanCol.setCellValueFactory(new PropertyValueFactory("ERA"));
        BAFanCol.setCellValueFactory(new PropertyValueFactory("BA"));
        WHIPFanCol.setCellValueFactory(new PropertyValueFactory("WHIP"));
//        hitterStatFanCol.setCellValueFactory(new PropertyValueFactory(""));
//        pitcherStatFanCol.setCellValueFactory(new PropertyValueFactory(""));
        yearOfBirthFanCol.setCellValueFactory(new PropertyValueFactory("YEAR_OF_BIRTH"));
        contractFanCol.setCellValueFactory(new PropertyValueFactory("contract"));
        salaryFanCol.setCellValueFactory(new PropertyValueFactory("salary"));
        
        positionsFanCol.setComparator(new FantasyTeamPositionComparator());
    }
     
    private void setUpTaxiSquadTableColTypes() {
        lastNameTaxCol.setCellValueFactory(new PropertyValueFactory("LAST_NAME"));
        firstNameTaxCol.setCellValueFactory(new PropertyValueFactory("FIRST_NAME"));
        teamTaxCol.setCellValueFactory(new PropertyValueFactory("TEAM"));
        positionsTaxCol.setCellValueFactory(new PropertyValueFactory("fantasyPosition"));
        RTaxCol.setCellValueFactory(new PropertyValueFactory("R"));
        
        WTaxCol.setCellValueFactory(new PropertyValueFactory("W"));
        HRTaxCol.setCellValueFactory(new PropertyValueFactory("HR"));
        SVTaxCol.setCellValueFactory(new PropertyValueFactory("SV"));
        RBITaxCol.setCellValueFactory(new PropertyValueFactory("RBI"));
        KTaxCol.setCellValueFactory(new PropertyValueFactory("K"));
        SBTaxCol.setCellValueFactory(new PropertyValueFactory("SB"));
        ERATaxCol.setCellValueFactory(new PropertyValueFactory("ERA"));
        BATaxCol.setCellValueFactory(new PropertyValueFactory("BA"));
        WHIPTaxCol.setCellValueFactory(new PropertyValueFactory("WHIP"));
//        hitterStatTaxCol.setCellValueFactory(new PropertyValueFactory(""));
//        pitcherStatTaxCol.setCellValueFactory(new PropertyValueFactory(""));
        yearOfBirthTaxCol.setCellValueFactory(new PropertyValueFactory("YEAR_OF_BIRTH"));
        contractTaxCol.setCellValueFactory(new PropertyValueFactory("contract"));
        salaryTaxCol.setCellValueFactory(new PropertyValueFactory("salary"));
        
        positionsTaxCol.setComparator(new FantasyTeamPositionComparator());
    }
    
    /**
     *  Returns current playerData
     * @return
     */
    public ObservableList<BaseballPlayer> getPlayerData() {
        return playerData;
    }

    private void initFantasyHeader() {
        draftNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            draftManager.getDraft().setName(newValue);
        });

        addFTeamBtn.setOnAction(e -> {
            newFanTeamDialog(false);
        });
        deleteFTeamBtn.setOnAction(e -> {
            Team team = fTeamCombo.getSelectionModel().getSelectedItem();
            boolean confirmDialog = confirmDialog("Are you sure you want to delete the " + team + " team?", ConfirmType.deleteFTeam);
        });

        editFTeamBtn.setOnAction(e -> {
            newFanTeamDialog(true);
        });

        ObservableList list = FXCollections.observableArrayList();
        DraftManager.getDraftManager().getDraft().getTeams().entrySet().stream().map((teamIT) -> (Team) teamIT.getValue()).forEach((value) -> {
            list.add(value);
        });
        
        fTeamCombo.setItems(list);
        fTeamCombo.getItems().remove(draftManager.getDraft().getFreeAgents());
    }

    public void deleteTeamDialog() {
        Team team = fTeamCombo.getSelectionModel().getSelectedItem();
        draftManager.getDraft().removeTeam(team.getName());
        fTeamCombo.getItems().clear();
        
        
        ObservableList list = FXCollections.observableArrayList();
        DraftManager.getDraftManager().getDraft().getTeams().entrySet().stream().map((teamIT) -> (Team) teamIT.getValue()).forEach((value) -> {
            list.add(value);
        });
        
        
        fTeamCombo.setItems(list);
    }

    private void newFanTeamDialog(boolean isEditing) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("dialog/newFantasyTeamDialogFXML.fxml"));
            Parent dialogPane;
            dialogPane = (Parent) fxmlLoader.load();
            NewFantasyTeamDialogController controller = fxmlLoader.getController();
            Team t = fTeamCombo.getSelectionModel().getSelectedItem();
            controller.initControls(isEditing, t, this);
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
            controller.initControls(bp, this);
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
    
    private boolean confirmDialog(String message, ConfirmType cT){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("dialog/confirmFXML.fxml"));
            Parent dialogPane = (Parent) fxmlLoader.load();
            ConfirmFXMLController controller = fxmlLoader.getController();
            boolean userChoice = controller.initControls(message, this, cT);
            Scene sc = new Scene(dialogPane);
            Stage st = new Stage();
            st.setScene(sc);
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(window);
            st.showAndWait();
            return userChoice;
        }catch(IOException ex){
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public void setSelectedFantasyTeam(Team s) {
        fTeamCombo.getSelectionModel().select(s);
    }

    public TableView<BaseballPlayer> getFantasyPlayers() {
        return fantasyPlayers;
    }

    public TableView<BaseballPlayer> getTaxiSquad() {
        return taxiSquad;
    }

    public TableView<BaseballPlayer> getPlayerTable() {
        return playerTable;
    }
    
    
    
    public ComboBox<Team> getfTeamCombo() {
        return fTeamCombo;
    }

    public void setFantasyTableData(ObservableList<BaseballPlayer> players) {

        FilteredList<BaseballPlayer> filteredData = new FilteredList<>(players, p -> true);
        
        filteredData.setPredicate(player -> {
            return player.getContract().equals("S1") || player.getContract().equals("S2");
        });
        
        SortedList<BaseballPlayer> sortedFantasy = new SortedList(filteredData, new FantasyTeamPositionComparator());
        //sortedFantasy.comparatorProperty().bind(fantasyPlayers.comparatorProperty());
        fantasyPlayers.setItems(sortedFantasy);
        //fantasyPlayers.getItems().sort(new FantasyTeamPositionComparator());
        
        FilteredList<BaseballPlayer> filteredDataTaxi = new FilteredList<>(players, p -> true);
        
        filteredDataTaxi.setPredicate(player -> {
            return player.getContract().equals("X");
        });
        
        SortedList<BaseballPlayer> sortedTaxi = new SortedList(filteredDataTaxi, new FantasyTeamPositionComparator());
        //sortedTaxi.comparatorProperty().bind(taxiSquad.comparatorProperty());
        taxiSquad.setItems(sortedTaxi);
        //taxiSquad.getItems().sort(new FantasyTeamPositionComparator());

    }
    
    public void refreshTables(){
        playerTable.setVisible(false);
        fantasyPlayers.setVisible(false);
        taxiSquad.setVisible(false);
        
        playerTable.setVisible(true);
        fantasyPlayers.setVisible(true);
        taxiSquad.setVisible(true);
    }

    private void addNewPlayerDialog() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("dialog/addNewPlayerDialogFXML.fxml"));
            Parent dialogPane = (Parent) fxmlLoader.load();
            AddNewPlayerDialogFXMLController controller = fxmlLoader.getController();
            controller.initControls();
            Scene sc = new Scene(dialogPane);
            Stage st = new Stage();
            st.setScene(sc);
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(window);
            st.showAndWait();
        }catch(IOException ex){
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Window getWindow() {
        return window;
    }
    
    public void saveDialog(JsonDraftFileManager jsonManager, boolean wantsQuit){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("dialog/saveDialog.fxml"));
            Parent dialogPane = (Parent) fxmlLoader.load();
            SaveDialogController controller = fxmlLoader.getController();
            controller.initControls(jsonManager, wantsQuit);
            Scene sc = new Scene(dialogPane);
            Stage st = new Stage();
            st.setScene(sc);
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(window);
            st.showAndWait();
        }catch(IOException ex){
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDraftNameFld(String name) {
        draftNameField.setText(name);
    }
}
