/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.concurrent.Task;
import wolfieball.data.compare.BAComparator;
import wolfieball.data.compare.ERAComparator;
import wolfieball.data.compare.HRComparator;
import wolfieball.data.compare.KComparator;
import wolfieball.data.compare.RBIComparator;
import wolfieball.data.compare.RComparator;
import wolfieball.data.compare.SBComparator;
import wolfieball.data.compare.SVComparator;
import wolfieball.data.compare.TeamComparator;
import wolfieball.data.compare.WComparator;
import wolfieball.data.compare.WHIPComparator;

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
    
    private boolean isPaused;
    
    
    public void autoDraft(boolean isP) {
        this.isPaused = isP;
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                int playersNeeded = teams.size()*23;
                int sumAlreadyDrafted=0;
                
                sumAlreadyDrafted = mapToList().stream().map((t) -> t.getNumberOfPlayer()).reduce(sumAlreadyDrafted, Integer::sum);
                
                int loops = playersNeeded - sumAlreadyDrafted;
                System.out.println(loops);
                for(int i = 0; i <= loops ; i++){
                    
                    if(isPaused)wait();
                    
                    draftTheBest();
                    Thread.sleep(30);
                }
                
                
                
                return null;
            }
        };
        
        
        
        Thread thread = new Thread(task);
        
        thread.start();
        try{
            task.notify();
        }catch(IllegalMonitorStateException ex){
            System.out.println("Don't Worry Friend");
        }
        
    }
    
    public ObservableList<Team> mapToList(){
        ObservableList<Team> list = FXCollections.observableArrayList();
        teams.entrySet().stream().map((team) -> (Team) team.getValue()).forEach((value) -> {
            list.add(value);
        });
        list.sort(new TeamComparator());
        return list;
    }
    
    public void draftTheBest() throws InterruptedException{
        ObservableList<Team> list = mapToList();

        Collections.sort(list, new TeamComparator());
        ObservableList<BaseballPlayer> freePlayers = freeAgents.getPlayers();
        BaseballPlayer bestPlayer = freePlayers.get(0);
        for (BaseballPlayer bp : freePlayers) {
            if ((bp.getRank() > bestPlayer.getRank()) && bp.getFantasyTeam().equals("Free Agent")) {
                bestPlayer = bp;
            }
        }
        bestPlayer.setSalary(1);
        for (Team t : list) {
            
            if (!t.getName().equals("Free Agent")) {
                if (t.getNeededPlayers() > 8) {
                    bestPlayer.setContract("S2");
                    bestPlayer.setFantasyTeam(t.getName());
                    t.addPlayer(bestPlayer);
                    draftOrder.add(bestPlayer);
                    break;
                }
                if (t.getNeededPlayers() <= 8 && t.getNeededPlayers() > 0) {
                    bestPlayer.setContract("X");
                    bestPlayer.setFantasyTeam(t.getName());
                    t.addPlayer(bestPlayer);
                    draftOrder.add(bestPlayer);
                    break;
                }
            }
            
            
            
            
        }

    }

    public void calcTotalPts() {
        ArrayList<Comparator> comparators = new ArrayList();
        
        comparators.add(new ERAComparator());   //0
        comparators.add(new BAComparator());    //1
        comparators.add(new HRComparator());    //2
        comparators.add(new KComparator());     //3
        comparators.add(new RBIComparator());   //4
        comparators.add(new RComparator());     //5
        comparators.add(new SBComparator());    //6
        comparators.add(new SVComparator());    //7
        comparators.add(new WComparator());     //8
        comparators.add(new WHIPComparator());  //9
        
        ObservableList<Team> teamsList = mapToList();

        for (Comparator comparator : comparators) {
           teamsList.sort(comparator);
           for(Team t : teamsList){
               t.totalPointsProperty().add(10 * teamsList.indexOf(t));
           } 
        }
        
    }


}
