/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.concurrent.Task;

/**
 *
 * @author Neal
 */
public class Draft {
    //ObservableList<BaseballPlayer> mlb;
    ObservableMap<String, Team> teams;
    String name;
    private Team freeAgents = new Team("Free Agent");
    String FREEAGENTS = "Free Agent";
    
    private final ObservableList<BaseballPlayer> draftOrder = FXCollections.observableArrayList();
    private final ObservableList<BaseballPlayer> allHitters = FXCollections.observableArrayList();
    private final ObservableList<BaseballPlayer> allPitchers = FXCollections.observableArrayList();

    public Draft(String name) {
        //this.mlb = FXCollections.observableArrayList();
        freeAgents.setOwner("MLB");
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

    public void setFreeAgents(Team freeAgents) {
        this.freeAgents = freeAgents;
    }

    public ObservableList<BaseballPlayer> getDraftOrder() {
        return draftOrder;
    }

    public ObservableList<BaseballPlayer> getAllHitters() {
        return allHitters;
    }

    public ObservableList<BaseballPlayer> getAllPitchers() {
        return allPitchers;
    }
    
    

    void clear() {
        setName("DEFAULT NAME");
        setTeams(FXCollections.observableHashMap());
        Team newFreeAgents = new Team(FREEAGENTS);
        newFreeAgents.setOwner("MLB");
        setFreeAgents(newFreeAgents);
    }
    
    public void autoDraft(){
       Task<Void> task = new Task<Void>() {

           @Override
           protected Void call() throws Exception {
               freeAgents.getPlayers().sort(new RankedComparator());
               ObservableList<Team> teamsList = mapToList();
               for( Team t : teamsList ){
                   if (t.getNumberOfPlayer() < 23) {
                       if (t.getNeededPlayers() > 8) {
                           if (t.getNumberOfPitchers() < 9) {
                               
                           }else{
                               
                           }
                       }
                       if (t.getNeededPlayers() >= 8 && t.getNeededPlayers() > 0) {

                       }
                   }
               }
               
               return null;
           }
       };

          
        

        Thread thread = new Thread(task);
        thread.start();
    
    
    }
    
    private ObservableList<Team> mapToList(){
        ObservableList<Team> list = FXCollections.observableArrayList();
        teams.entrySet().stream().map((team) -> (Team) team.getValue()).forEach((value) -> {
            list.add(value);
        });
        list.sort(new TeamComparator());
        return list;
    }
    
}
