/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Neal
 */
public class Draft {
    ObservableList<BaseballPlayer> mlb;
    ObservableList<Team> teams;
    String name;

    public Draft(String name) {
        this.mlb = FXCollections.observableArrayList();
        this.name = name;
    }
    
    

    public ObservableList<BaseballPlayer> getMlb() {
        return mlb;
    }

    public void setMlb(ObservableList<BaseballPlayer> mlb) {
        this.mlb = mlb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ObservableList<Team> teams) {
        this.teams = teams;
    }
    
    
    
    
    
}
