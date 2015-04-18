/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import wolfieball.file.JsonDraftFileManager;
import wolfieball.gui.MainGUI;

/**
 *
 * @author Neal
 */
public class DraftManager {
    private final JsonDraftFileManager jsonManager;
    private final Draft draft;
    public Draft getDraft() {return draft;}

    public DraftManager() {
        this.draft = new Draft("");
        this.jsonManager = new JsonDraftFileManager();
    }

    /**
     * This method will handle a new Draft request from the user
     * It will return a full list of ALL players in the league 
     * @param gui
     */
    public void newDraftRequest(MainGUI gui) {
        try {
            if(gui.getPlayerData().isEmpty()){
                jsonManager.loadNewDraft(draft);
                gui.print("New Draft");
            }else{
                saveRequest(gui);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DraftManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method will handle a load Draft request from the user
     * It will return a full list of ALL players in the league 
     * It will also give the players that need to be filtered 
     * because they have been drafted
     * @param gui
     * @param window
     */
    public void loadDraftRequest(MainGUI gui, Window window) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("..\\Wolfieball Draft Kit\\drafts"));
        fc.setTitle("Choose Draft File");
        File loadedDraft = fc.showOpenDialog(window);
        if (loadedDraft != null) {
            jsonManager.loadExistingDraft(draft, loadedDraft);
        } else {
            //Show error dialog
        }
        gui.print("Load Draft"); 
    }

    /**
     *
     * @param gui
     */
    public void saveAndQuitRequest(MainGUI gui) {
        gui.print("Save and Quit Draft"); 
        
        System.exit(0);
    }

    /**
     *
     * @param gui
     */
    public void saveRequest(MainGUI gui){
        Alert saveConfirm = new Alert(Alert.AlertType.CONFIRMATION);
        saveConfirm.setTitle("Save");
        saveConfirm.setContentText("Save current work before continuing?");
        
        Optional<ButtonType> result = saveConfirm.showAndWait();
        
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            jsonManager.saveDraft(draft);
        }
        if((result.isPresent()) && (result.get() == ButtonType.CANCEL)){
            gui.print("Continued Working");
        }
        
        gui.print("saveRequest");
    }

    /**
     *
     * @param gui
     */
    public void exportRequest(MainGUI gui) {
        gui.print("exportRequest"); 
    }

    /**
     *
     * @param gui
     */
    public void addPlayerRequest(MainGUI gui) {
        gui.print("addPlayerRequest"); 
    }

    /**
     *
     * @param gui
     */
    public void removePlayerRequest(MainGUI gui) {
        gui.print("removePlayerRequest"); 
    }
    
    
}
