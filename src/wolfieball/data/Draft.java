/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.collections.ObservableList;

/**
 *
 * @author Neal
 */
public class Draft {
    ObservableList<BaseballPlayer> mlb;
    ObservableList<BaseballPlayer> fantasy;
    String name;
    
    

    public ObservableList<BaseballPlayer> getMlb() {
        return mlb;
    }

    public void setMlb(ObservableList<BaseballPlayer> mlb) {
        this.mlb = mlb;
    }

    public ObservableList<BaseballPlayer> getFantasy() {
        return fantasy;
    }

    public void setFantasy(ObservableList<BaseballPlayer> fantasy) {
        this.fantasy = fantasy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
