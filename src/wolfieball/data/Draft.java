/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import wolfieball.data.compare.BAComparator;
import wolfieball.data.compare.ERAComparator;
import wolfieball.data.compare.HRComparator;
import wolfieball.data.compare.HitterRankComparator;
import wolfieball.data.compare.KComparator;
import wolfieball.data.compare.PitcherRankComparator;
import wolfieball.data.compare.RBIComparator;
import wolfieball.data.compare.RComparator;
import wolfieball.data.compare.RankedComparator;
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
        draftOrder.clear();
    }
    
    private boolean isPaused;
    
    
    public void autoDraft(boolean isP) {
        this.isPaused = isP;
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                //int playersNeeded = teams.size()*31;
                //int sumAlreadyDrafted=0;
                
                //sumAlreadyDrafted = mapToList().stream().map((t) -> t.getNumberOfPlayer()).reduce(sumAlreadyDrafted, Integer::sum);
                
                
                //System.out.println(loops);
                System.out.println(orderedPositions.size());
                ObservableList<Team> list = mapToList();
                Collections.sort(list, new TeamComparator());
                for (Team t : list) {

                    for (String pos : orderedPositions) {
                        if (isPaused) {
                            wait();
                        }
                        boolean draftTheBest = draftTheBest(pos, t);
                        if(draftTheBest)Thread.sleep(333);
                    }

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
    
    
    private static final List<String> orderedPositions = Arrays.asList("C_", "C_", "1B", "CI", "2B", "3B", "MI", "SS", "OF","OF","OF","OF","OF", "P", "P", "P", "P", "P", "P", "P", "P", "P" , "U", "", "", "", "", "", "", "", "");
    
    public boolean draftTheBest(String pos, Team t) throws InterruptedException {
        BaseballPlayer bestPlayer;
        FilteredList<BaseballPlayer> freeFiltered = new FilteredList<>(freeAgents.getPlayers(), (BaseballPlayer p) -> {
            return p.getQP().contains(pos);
        });

        SortedList<BaseballPlayer> sort = new SortedList(freeFiltered, new RankedComparator());
        bestPlayer = sort.get(0);

        bestPlayer.setSalary(1);
        String posi = pos;
        if (posi.equals("C_")) {
            posi = "C";
        }
        
        bestPlayer.setFantasyPosition(posi);
        bestPlayer.calcStats();
            if (!t.getName().equals("Free Agent") && t.draftable(bestPlayer)) {
                if (t.getPlayers().size() < 23) {
                    return draftToTeam(bestPlayer, t);
                }else {
                    if (t.getTaxi().size() < 8) {
                        return draftToTaxi(bestPlayer, t);
                    }
                }

            }
        return false;
    }

    public boolean draftToTeam(BaseballPlayer bestPlayer, Team t) {
        bestPlayer.setContract("S2");
        bestPlayer.setFantasyTeam(t.getName());
        t.addPlayer(bestPlayer);
        draftOrder.add(bestPlayer);
        return freeAgents.getPlayers().remove(bestPlayer);
    }

    public boolean draftToTaxi(BaseballPlayer bestPlayer, Team t) {
        bestPlayer.setContract("X");
        bestPlayer.setFantasyTeam(t.getName());
        bestPlayer.setFantasyPosition("Taxi Squad");
        bestPlayer.setSalary(1);
        t.getTaxi().add(bestPlayer);
        //draftOrder.add(bestPlayer);
        return freeAgents.getPlayers().remove(bestPlayer);
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
               t.totalPointsProperty().set( ( t.getTotalPoints() ) + (10 * (teamsList.indexOf(t)+1) ) );
           } 
        }
        
    }
    
    public void calcEstValue(){
        allHitters.clear();
        allPitchers.clear();
        int allMoneyLeft = 0;
        int pitchersNeeded = 0;
        int hittersNeeded = 0;
        
        for(Team t : mapToList()){
            if(t.getPlayers().size() <= 23){
                allMoneyLeft += t.getMoney();
                pitchersNeeded += 9 - t.getNumberOfPitchers();
                hittersNeeded = (23-9) - t.getNumberOfHitters();
            }
        }
        
        
        freeAgents.getPlayers().stream().forEach((bp) -> {
            if(bp.getQP().equals("P")){
                allPitchers.add(bp);
            }else{
                allHitters.add(bp);
            }
        });
        
        allPitchers.sort(new PitcherRankComparator());
        allHitters.sort(new HitterRankComparator());
        
        int medianSalaryH = allMoneyLeft / ((2 * hittersNeeded)==0?Integer.MAX_VALUE:(2 * hittersNeeded));
        int medianSalaryP = allMoneyLeft / ((2 * pitchersNeeded)==0?Integer.MAX_VALUE:(2 * pitchersNeeded));
        
        int denom = (hittersNeeded + pitchersNeeded);
        
        int avgSal;
        if(denom!=0){
            avgSal = allMoneyLeft / denom;
        }else{
            avgSal = 0;
        }
        
       
        for(int i = 0; i < pitchersNeeded; i++){
            BaseballPlayer pitcher = allPitchers.get(i);
            pitcher.setEstimatedValue(avgSal/(i+1));  /// medianSalaryP * (pitchersNeeded * (2 / (i+1==0?Integer.MAX_VALUE:i+1)))
        }
        for(int i = 0; i < hittersNeeded; i++){
            BaseballPlayer hitter = allHitters.get(i);
            hitter.setEstimatedValue(avgSal/(i+1)); //medianSalaryH * (hittersNeeded * (2 / (i+1==0?Integer.MAX_VALUE:i+1)))
        }
    }


}
