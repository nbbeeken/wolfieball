/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package draftkit.wolfieball;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Neal
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Tab playerTab;
    @FXML
    private TableView<?> playerTable;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchBtn;
    @FXML
    private Button playerImageBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private TextArea bioArea;
    @FXML
    private Label playerLbl;
    @FXML
    private Tab fantasyTab;
    @FXML
    private Tab standingsTab;
    @FXML
    private Tab draftTab;
    @FXML
    private Tab mlbTeamsTab;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fileMenu;
    @FXML
    private Menu editMenu;
    @FXML
    private Menu helpMenu;
    @FXML
    private TextArea infoArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
