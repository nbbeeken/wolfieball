/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static final DraftManager dm = new DraftManager();

    private DraftManager() {
        this.draft = new Draft("DEFAULT");
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
                draft.clear();
                
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
        File draftFile = fc.showOpenDialog(window);
        
        try {
            draft.clear();
            jsonManager.loadExistingDraft(draft, draftFile);
            gui.setDraftNameFld(draft.name);
        } catch (IOException ex) {
            Logger.getLogger(DraftManager.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        gui.print("Load Draft"); 
    }

    /**
     *
     * @param gui
     */
    public void saveAndQuitRequest(MainGUI gui) {
        gui.print("Save and Quit Draft");
        saveDialog(gui, true);
        gui.print("Continued Working");
        
    }

    /**
     *
     * @param gui
     */
    public void saveRequest(MainGUI gui){
        gui.print("Save Draft");
        
        saveDialog(gui, false);
        
    }

    private void saveDialog(MainGUI gui, boolean wantsQuit) {
        gui.saveDialog(jsonManager, wantsQuit);
    }

    /**
     *
     * @param gui
     */
    public void exportRequest(MainGUI gui) {
        gui.print("exportRequest"); 
    }
    
    public static DraftManager getDraftManager(){
        return dm;
    }

    public void addPlayerToNextTeam(BaseballPlayer bestPlayer) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
