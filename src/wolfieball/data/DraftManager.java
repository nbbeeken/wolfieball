/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import java.util.ArrayList;
import wolfieball.gui.MainGUI;

/**
 *
 * @author Neal
 */
public class DraftManager {
    Draft draft;

    public DraftManager() {
        this.draft = new Draft();
    }

    /**
     * This method will handle a new Draft request from the user
     * It will return a full list of ALL players in the league 
     * @param gui
     * @return
     */
    public ArrayList<BaseballPlayer> newDraftRequest(MainGUI gui) {
        gui.print("New Draft");
        return null;
    }
    
    /**
     * This method will handle a load Draft request from the user
     * It will return a full list of ALL players in the league 
     * It will also give the players that need to be filtered 
     * because they have been drafted
     * @param gui
     * @return
     */
    public ArrayList<BaseballPlayer> loadDraftRequest(MainGUI gui) {
        gui.print("Load Draft"); 
        return null;
    }

    public void saveAndQuitRequest(MainGUI gui) {
        gui.print("Save and Quit Draft"); 
    }

    public void saveRequest(MainGUI gui) {
        gui.print("saveRequest"); 
    }

    public void exportRequest(MainGUI gui) {
        gui.print("exportRequest"); 
    }

    public void addPlayerRequest(MainGUI gui) {
        gui.print("addPlayerRequest"); 
    }

    public void removePlayerRequest(MainGUI gui) {
        gui.print("removePlayerRequest"); 
    }
    
    
}
