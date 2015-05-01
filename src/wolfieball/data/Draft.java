/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 *
 * @author Neal
 */
public class Draft {
    //ObservableList<BaseballPlayer> mlb;
    ObservableMap<String, Team> teams;
    String name;
    private final Team freeAgents = new Team("Free Agent");
    String FREEAGENTS = "Free Agent";

    public Draft(String name) {
        //this.mlb = FXCollections.observableArrayList();
        this.teams = FXCollections.observableHashMap();
        this.teams.put(FREEAGENTS, freeAgents);
        this.name = name;
    }
    
    
//
//    public ObservableList<BaseballPlayer> getMlb() {
//        return mlb;
//    }
//
//    public void setMlb(ObservableList<BaseballPlayer> mlb) {
//        this.mlb = mlb;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableMap<String, Team> getTeams() {
        return teams;
    }

    public void setTeams(ObservableMap<String, Team> teams) {
        this.teams = teams;
    }

    public void removeTeam(String team) {
        Team get = teams.get(team);
        get.getPlayers().stream().forEach((player) -> {
            player.setFantasyTeam(FREEAGENTS);
            freeAgents.addPlayer(player);
        });
        teams.remove(team);
    }

    public Team getFreeAgents() {
        return freeAgents;
    }
    
    
    
    
}
