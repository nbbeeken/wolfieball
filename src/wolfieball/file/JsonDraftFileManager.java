package wolfieball.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.collections.ObservableList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import wolfieball.data.BaseballPlayer;
import wolfieball.data.Draft;
import wolfieball.data.Team;

/**
 *
 * @author Neal
 */
public class JsonDraftFileManager implements PlayerFileManager {

    private final String HITTER_FILE = "src\\wolfieball\\data\\hitters.json";
    private final String PITCHER_FILE = "src\\wolfieball\\data\\pitchers.json";

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

        
        
        //JsonArray mlbJsonArray = makeMLBJsonArray(draft.getMlb());
        
        //JsonArray teamsJsonArray = makeTeamsJsonArray(draft.getTeams());
        
        JsonObject draftJsonObject = Json.createObjectBuilder()
                .add("NAME", draft.getName())
                //.add("MLB", mlbJsonArray)
                //.add("TEAMS", teamsJsonArray)
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
        loadMLB(draft, HITTER_FILE, PITCHER_FILE);
    }

        /**
     *
     * @param draft
     * @param draftFile
     * @throws IOException
     */
    public void loadExistingDraft(Draft draft, File draftFile) throws IOException {
        loadFantasyMlb(draft, draftFile);
        loadFantasyTeams(draft, draftFile);
    }
    
    
    
    private void loadMLB(Draft draft, String hitterFile, String pitcherFile) throws IOException, NumberFormatException {
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
            draft.getFreeAgents().addPlayer(bp);
            //draft.getMlb().add(bp);
        }
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
                    
                .add("NOTES", player.getNOTES() + "")
                .add("YEAR_OF_BIRTH", player.getYEAR_OF_BIRTH() + "")
                .add("NATION_OF_BIRTH", player.getNATION_OF_BIRTH())
                
                .add("FANTASY_TEAM", player.getFantasyTeam())
                .build();
        

        return jsonPlayer;
    }

    private JsonArray makeMLBJsonArray(ObservableList<BaseballPlayer> mlb) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        
        mlb.stream().forEach((bp) -> {
            jsb.add(makeJsonPlayer(bp));
        });

        return jsb.build();
    }

    private void loadFantasyMlb(Draft draft, File hitterFile) throws IOException {
        JsonObject jsonHitters = loadJSONFile(hitterFile.getAbsolutePath());
        JsonArray mlbJson = jsonHitters.getJsonArray("MLB");
        
        for(int i = 0; i < mlbJson.size(); i++){
            BaseballPlayer bp = new BaseballPlayer();
            JsonObject player = mlbJson.getJsonObject(i);
            
            bp.setFIRST_NAME(player.getString("FIRST_NAME"));
            bp.setLAST_NAME(player.getString("LAST_NAME"));
            bp.setTEAM(player.getString("TEAM"));
            String positions = player.getString("QP");
            bp.setQP(positions);
            
            bp.setAB(player.getInt("AB"));
            bp.setR(player.getInt("R"));
            bp.setHR(player.getInt("HR"));
            bp.setRBI(player.getInt("RBI"));
            bp.setSB(player.getInt("SB"));
            bp.setH(player.getInt("H"));
            
            bp.setIP(Double.parseDouble(player.getString("IP")));
            bp.setER(Integer.parseInt(player.getString("ER")));
            bp.setW(Integer.parseInt(player.getString("W")));
            bp.setSV(Integer.parseInt(player.getString("SV")));
            bp.setH_P(Integer.parseInt(player.getString("H_P")));
            bp.setBB(Integer.parseInt(player.getString("BB")));
            bp.setK(Integer.parseInt(player.getString("K")));
            
            
            
            bp.setNOTES(player.getString("NOTES"));
            bp.setYEAR_OF_BIRTH(player.getInt("YEAR_OF_BIRTH"));
            bp.setNATION_OF_BIRTH(player.getString("NATION_OF_BIRTH"));
            bp.setFantasyTeam(player.getString("FANTASY_TEAM"));
            
            //draft.getMlb().add(bp);
            //BROKENNNNNNNNNNNNNNNNNNNNNNNNNN
        }
        
    
    }

    private JsonArray makeTeamsJsonArray(ObservableList<Team> teams) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        
        teams.stream().forEach((team)-> {
            jsb.add(makeFantasyTeam(team));
        });
        
        return jsb.build();
    }

    private void loadFantasyTeams(Draft draft, File draftFile) throws IOException {
        JsonObject jsonTeams = loadJSONFile(draftFile.getAbsolutePath());
        JsonArray teamsJson = jsonTeams.getJsonArray("TEAMS");
        
        for(int i = 0; i < teamsJson.size(); i++){
            Team team = new Team("");
            JsonObject jsoTeam = teamsJson.getJsonObject(i);
            team.setName(jsoTeam.getString("NAME"));
            team.setOwner(jsoTeam.getString("OWNER"));
            //draft.getTeams().add(team);
        }
    }

    private JsonObject makeFantasyTeam(Team team) {
        JsonObject jso = Json.createObjectBuilder()
                .add("NAME", team.getName())
                .add("OWNER", team.getOwner())
                .build();
        return jso;
    }

}
