package wolfieball.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import wolfieball.data.BaseballPlayer;
import wolfieball.data.Draft;

/**
 * This is a CourseFileManager that uses the JSON file format to 
 * implement the necessary functions for loading and saving different
 * data for our courses, instructors, and subjects.
 * 
 * @author Richard McKenna
 */
public class JsonDraftFileManager implements PlayerFileManager {

    private final String HITTER_FILE = "..\\Wolfieball Draft Kit\\drafts\\data\\hitters.json";
    private final String PITCHER_FILE = "..\\Wolfieball Draft Kit\\drafts\\data\\pitchers.json";

    /**
     * Saves Draft to JSON
     *
     * @param draft
     * @throws IOException
     */
    public void saveDraft(Draft draft) {

    }

    /**
     * Loads the JSON formatted Draft file.
     *
     * @param draft
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadNewDraft(Draft draft) throws FileNotFoundException, IOException {
        loadMLB(draft);
    }

    private void loadMLB(Draft draft) throws IOException, NumberFormatException {
        JsonObject jsonHitters = loadJSONFile(HITTER_FILE);
        JsonArray hitters = jsonHitters.getJsonArray("Hitters");
        JsonObject jsonPitchers = loadJSONFile(PITCHER_FILE);
        JsonArray pitchers = jsonPitchers.getJsonArray("Pitchers");
        
        for(int i = 0; i < hitters.size(); i++){
            BaseballPlayer bp = new BaseballPlayer();
            JsonObject hitter = hitters.getJsonObject(i);
            bp.setFIRST_NAME(hitter.getString("FIRST_NAME"));
            bp.setLAST_NAME(hitter.getString("LAST_NAME"));
            bp.setTEAM(hitter.getString("TEAM"));
            bp.setQP(hitter.getString("QP"));
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
            draft.getMlb().add(bp);
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
            
            draft.getMlb().add(bp);
        }
    }

    private static JsonObject loadJSONFile(String jsonFilePath) throws IOException {
        JsonObject json;
        try (InputStream is = new FileInputStream(jsonFilePath); JsonReader jsonReader = Json.createReader(is)) {
            json = jsonReader.readObject();
        }
        return json;
    } 
    
    private static ArrayList<String> loadArrayFromJSONFile(String jsonFilePath, String arrayName) throws IOException {
        JsonObject json = loadJSONFile(jsonFilePath);
        ArrayList<String> items = new ArrayList();
        JsonArray jsonArray = json.getJsonArray(arrayName);
        jsonArray.stream().forEach((jsV) -> {
            items.add(jsV.toString());
        });
        return items;
    }
    
    public void loadExistingDraft(Draft draft, File loadedDraft) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
