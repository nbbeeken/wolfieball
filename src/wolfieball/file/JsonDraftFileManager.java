package wolfieball.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import wolfieball.data.BaseballPlayer;
import wolfieball.data.Draft;
import wolfieball.data.MLBPlayer;
import wolfieball.data.Team;

/**
 *
 * @author Neal
 */
public class JsonDraftFileManager implements PlayerFileManager {

    private static final String HITTER_FILE = "src\\wolfieball\\data\\hitters.json";
    private static final String PITCHER_FILE = "src\\wolfieball\\data\\pitchers.json";
    
    

    /**
     * Saves Draft to JSON
     *
     * @param draft
     * @throws java.io.IOException
     */
    public void saveDraft(Draft draft) throws IOException {
        String jsonFilePath = "drafts\\" + (draft.getName().isEmpty()?"DEFAULT_NAME":draft.getName()) + ".json";
        OutputStream os = new FileOutputStream(jsonFilePath);
        JsonWriter jsonWriter = Json.createWriter(os);  

        
        
        JsonArray teamsMapJsonArray = makeTeamsMapToArray(draft.getTeams());
        
        JsonObject freeAgentsJson = makeFreeAgentsArray(draft.getFreeAgents());
        
        
        JsonObject draftJsonObject = Json.createObjectBuilder()
                .add("NAME", draft.getName())
                .add("TEAMS_MAP", teamsMapJsonArray)
                .add("FREE_AGENTS", freeAgentsJson)
                .build();
        
        
        jsonWriter.writeObject(draftJsonObject);
    }

    /**
     * Loads the JSON formatted Draft file.
     *
     * @param draft
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadNewDraft(Draft draft) throws FileNotFoundException, IOException {
        loadAllDefaultPlayers(draft, HITTER_FILE, PITCHER_FILE);
    }

        /**
     *
     * @param draft
     * @param draftFile
     * @throws IOException
     */
    public void loadExistingDraft(Draft draft, File draftFile) throws IOException {
        JsonObject allData = loadJSONFile(draftFile.getAbsolutePath());
        draft.setName(allData.getString("NAME"));
        draft.setTeams(buildTeamsMap(allData.getJsonArray("TEAMS_MAP")));
        draft.setFreeAgents(buildFreeAgentsTeam(allData.getJsonObject("FREE_AGENTS")));
    }
    
    
    
    private void loadAllDefaultPlayers(Draft draft, String hitterFile, String pitcherFile) throws IOException, NumberFormatException {
        JsonObject jsonHitters = loadJSONFile(hitterFile);
        JsonArray hitters = jsonHitters.getJsonArray("Hitters");
        JsonObject jsonPitchers = loadJSONFile(pitcherFile);
        JsonArray pitchers = jsonPitchers.getJsonArray("Pitchers");
        
        for(int i = 0; i < hitters.size(); i++){
            BaseballPlayer bp = new BaseballPlayer();
            JsonObject hitter = hitters.getJsonObject(i);
            bp.setFIRST_NAME(hitter.getString("FIRST_NAME"));
            bp.setLAST_NAME(hitter.getString("LAST_NAME"));
            bp.setTEAM(hitter.getString("TEAM"));
            String positions = hitter.getString("QP");
            
            if(positions.contains("SS") || positions.contains("2B") && !positions.contains("MI"))
                positions += "_MI";
            if(positions.contains("1B") || positions.contains("3B") && !positions.contains("CI"))
                positions += "_CI";
            
            bp.setQP(positions+(positions.contains("U")?"":"_U"));
            bp.setAB(hitter.getInt("AB"));
            bp.setR(hitter.getInt("R"));
            bp.setHR(hitter.getInt("HR"));
            bp.setRBI(hitter.getInt("RBI"));
            bp.setSB(hitter.getInt("SB"));
            bp.setH(hitter.getInt("H"));
            bp.setNOTES(hitter.getString("NOTES"));
            bp.setYEAR_OF_BIRTH(hitter.getInt("YEAR_OF_BIRTH"));
            bp.setNATION_OF_BIRTH(hitter.getString("NATION_OF_BIRTH"));
            bp.setIsHitter(true);
            bp.setFantasyTeam("Free Agent");
            bp.setFantasyPosition("");
            draft.getFreeAgents().addPlayer(bp);
            //draft.getMlb().add(bp);
        }
        
        for(int i = 0; i < pitchers.size(); i++){
            BaseballPlayer bp = new BaseballPlayer();
            JsonObject pitcher = pitchers.getJsonObject(i);
            bp.setFIRST_NAME(pitcher.getString("FIRST_NAME"));
            bp.setLAST_NAME(pitcher.getString("LAST_NAME"));
            bp.setTEAM(pitcher.getString("TEAM"));
            bp.setQP("P");
            bp.setIP(Double.parseDouble(pitcher.getString("IP")));
            bp.setER(Integer.parseInt(pitcher.getString("ER")));
            bp.setW(Integer.parseInt(pitcher.getString("W")));
            bp.setSV(Integer.parseInt(pitcher.getString("SV")));
            bp.setH_P(Integer.parseInt(pitcher.getString("H")));
            bp.setBB(Integer.parseInt(pitcher.getString("BB")));
            bp.setK(Integer.parseInt(pitcher.getString("K")));
            bp.setNOTES(pitcher.getString("NOTES"));
            bp.setYEAR_OF_BIRTH(Integer.parseInt(pitcher.getString("YEAR_OF_BIRTH")));
            bp.setNATION_OF_BIRTH(pitcher.getString("NATION_OF_BIRTH"));
            bp.setIsHitter(false);
            bp.setFantasyTeam("Free Agent");
            bp.setFantasyPosition("");
            draft.getFreeAgents().addPlayer(bp);
            //draft.getMlb().add(bp);
        }
    }

    public static ObservableList<MLBPlayer> loadMLB() throws IOException{
        ObservableList<MLBPlayer> mlb = FXCollections.observableArrayList();
        JsonObject jsonHitters = loadJSONFile(HITTER_FILE);
        JsonArray hitters = jsonHitters.getJsonArray("Hitters");
        JsonObject jsonPitchers = loadJSONFile(PITCHER_FILE);
        JsonArray pitchers = jsonPitchers.getJsonArray("Pitchers");
        
        for(int i = 0; i < hitters.size(); i++){
            MLBPlayer bp = new MLBPlayer();
            JsonObject hitter = hitters.getJsonObject(i);
            bp.setFirstName(hitter.getString("FIRST_NAME"));
            bp.setLastName(hitter.getString("LAST_NAME"));
            bp.setProTeam(hitter.getString("TEAM"));
            String positions = hitter.getString("QP");
            
            if(positions.contains("SS") || positions.contains("2B") && !positions.contains("MI"))
                positions += "_MI";
            if(positions.contains("1B") || positions.contains("3B") && !positions.contains("CI"))
                positions += "_CI";
            
            bp.setPositions(positions+(positions.contains("U")?"":"_U"));
            
            mlb.add(bp);
        }
        
        for(int i = 0; i < pitchers.size(); i++){
            MLBPlayer bp = new MLBPlayer();
            JsonObject pitcher = pitchers.getJsonObject(i);
             bp.setFirstName(pitcher.getString("FIRST_NAME"));
            bp.setLastName(pitcher.getString("LAST_NAME"));
            bp.setProTeam(pitcher.getString("TEAM"));
            bp.setPositions("P");

            mlb.add(bp);
        }
        
        return mlb;
    }
    
    private static JsonObject loadJSONFile(String jsonFilePath) throws IOException {
        JsonObject json;
        try (InputStream is = new FileInputStream(jsonFilePath); JsonReader jsonReader = Json.createReader(is)) {
            json = jsonReader.readObject();
        }
        return json;
    } 
    
    private JsonObject makeJsonPlayer(BaseballPlayer player) {
        JsonObject jsonPlayer;
        String contract = player.getContract();
        if(contract == null) contract = "";
            jsonPlayer = Json.createObjectBuilder()
                .add("TEAM", player.getTEAM())
                .add("LAST_NAME", player.getLAST_NAME())
                .add("FIRST_NAME", player.getFIRST_NAME())
                .add("QP", player.getQP() + "")
                    
                .add("IP", player.getIP() + "")
                .add("ER", player.getER() + "")
                .add("W", player.getW() + "")
                .add("SV", player.getSV() + "")
                .add("H_P", player.getH_P() + "")
                .add("BB", player.getBB() + "")
                .add("K", player.getK() + "")
                    
                .add("AB", player.getAB() + "")
                .add("R", player.getR() + "")
                .add("H", player.getH() + "")
                .add("HR", player.getHR() + "")
                .add("RBI", player.getRBI() + "")
                .add("SB", player.getSB() + "")
                    
                .add("NOTES", player.getNOTES())
                .add("YEAR_OF_BIRTH", player.getYEAR_OF_BIRTH())
                .add("NATION_OF_BIRTH", player.getNATION_OF_BIRTH())
                
                .add("FANTASY_TEAM", player.getFantasyTeam())
                .add("SALARY", player.getSalary() + "")
                .add("CONTRACT",  contract  )
                .add("FANTASY_POSITION", player.getFantasyPosition())
                .build();
        

        return jsonPlayer;
    }

    private Team loadFantasyTeams(JsonObject teamJson){
        Team team = new Team("");

        team.setName(teamJson.getString("NAME"));
        team.setOwner(teamJson.getString("OWNER"));
        team.setNumberOfPlayer(teamJson.getInt("NUM_PLAYERS"));
        team.setNumberOfCatchers(teamJson.getInt("NUM_C"));
        team.setNumberOfPitchers(teamJson.getInt("NUM_P"));
        team.setNumberOfFirstbasemen(teamJson.getInt("NUM_1B"));
        team.setNumberOfSecondbasemen(teamJson.getInt("NUM_2B"));
        team.setNumberOfThirdbasemen(teamJson.getInt("NUM_3B"));
        team.setNumberOfCornerInfielder(teamJson.getInt("NUM_CI"));
        team.setNumberOfSS(teamJson.getInt("NUM_SS"));
        team.setNumberOfMI(teamJson.getInt("NUM_MI"));
        team.setNumberOfOF(teamJson.getInt("NUM_OF"));
        team.setNumberOfU(teamJson.getInt("NUM_U"));
        team.setNumberOfTaxi(teamJson.getInt("NUM_TAXI"));
        team.setPlayers(buildPlayersArray(teamJson.getJsonArray("PLAYERS")));
        
        
        

        return team;
    }

    private JsonObject makeFantasyTeam(Team team) {
        JsonObject jso = Json.createObjectBuilder()
                .add("NAME", team.getName())
                .add("OWNER", team.getOwner())
                .add("NUM_PLAYERS", team.getNumberOfPlayer())
                .add("NUM_C", team.getNumberOfCatchers())
                .add("NUM_P", team.getNumberOfPitchers())
                .add("NUM_1B", team.getNumberOfFirstbasemen())
                .add("NUM_2B", team.getNumberOfSecondbasemen())
                .add("NUM_3B", team.getNumberOfThirdbasemen())
                .add("NUM_CI", team.getNumberOfCornerInfielder())
                .add("NUM_SS", team.getNumberOfSS())
                .add("NUM_MI", team.getNumberOfMI())
                .add("NUM_OF", team.getNumberOfOF())
                .add("NUM_U", team.getNumberOfU())
                .add("NUM_TAXI", team.getNumberOfU())
                .add("PLAYERS", makePlayersArray(team.getPlayers()))
                .build();
        return jso;
    }

    private JsonArray makeTeamsMapToArray(ObservableMap<String, Team> teams) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        
        teams.entrySet().stream().map((team) -> (Team) team.getValue()).forEach((value) -> {
            jsb.add(makeFantasyTeam(value));
        });
        
        return jsb.build();
    }

    private JsonObject makeFreeAgentsArray(Team freeAgents) {
        return makeFantasyTeam(freeAgents);
    }

    private JsonArray makePlayersArray(ObservableList<BaseballPlayer> players) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        
        players.stream().forEach(player -> {
            jsb.add(makeJsonPlayer(player));
        });
        
        return jsb.build();
    }

    private ObservableMap<String, Team> buildTeamsMap(JsonArray jsonArray) {
        ObservableMap<String, Team> map = FXCollections.observableHashMap();
        for(int i =0; i < jsonArray.size(); i++){
            JsonObject get = jsonArray.getJsonObject(i);
            Team team = loadFantasyTeams(get);
            map.put(team.getName(), team);
        }
        
        return map;
    }

    private Team buildFreeAgentsTeam(JsonObject teamJson) {
        return loadFantasyTeams(teamJson);
    }

    private ObservableList<BaseballPlayer> buildPlayersArray(JsonArray jsonArray) {
        ObservableList<BaseballPlayer> list = FXCollections.observableArrayList();
        for(int i = 0; i < jsonArray.size(); i++){
            BaseballPlayer bp = new BaseballPlayer();
            JsonObject player = jsonArray.getJsonObject(i);
            
            bp.setFIRST_NAME(player.getString("FIRST_NAME"));
            bp.setLAST_NAME(player.getString("LAST_NAME"));
            bp.setTEAM(player.getString("TEAM"));
            String positions = player.getString("QP");
            bp.setQP(positions);
            
            bp.setAB(Double.parseDouble(player.getString("AB")));
            bp.setR(Double.parseDouble(player.getString("R")));
            bp.setHR(Double.parseDouble(player.getString("HR")));
            bp.setRBI(Double.parseDouble(player.getString("RBI")));
            bp.setSB(Double.parseDouble(player.getString("SB")));
            bp.setH(Double.parseDouble(player.getString("H")));
            
            bp.setIP(Double.parseDouble(player.getString("IP")));
            bp.setER(Double.parseDouble(player.getString("ER")));
            bp.setW(Double.parseDouble(player.getString("W")));
            bp.setSV(Double.parseDouble(player.getString("SV")));
            bp.setH_P(Double.parseDouble(player.getString("H_P")));
            bp.setBB(Double.parseDouble(player.getString("BB")));
            bp.setK(Double.parseDouble(player.getString("K")));
            
            
            
            bp.setNOTES(player.getString("NOTES"));
            bp.setYEAR_OF_BIRTH(player.getInt("YEAR_OF_BIRTH"));
            bp.setNATION_OF_BIRTH(player.getString("NATION_OF_BIRTH"));
            bp.setFantasyTeam(player.getString("FANTASY_TEAM"));
            bp.setSalary(Double.parseDouble(player.getString("SALARY")));
            bp.setContract(player.getString("CONTRACT"));
            bp.setFantasyPosition(player.getString("FANTASY_POSITION"));
            
            list.add(bp);
        }
        return list;
    }

}
