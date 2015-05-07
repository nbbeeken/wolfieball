/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Neal
 */
public class MLBPlayer {
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty positions = new SimpleStringProperty();
    private final StringProperty proTeam = new SimpleStringProperty();

    public String getProTeam() {
        return proTeam.get();
    }

    public void setProTeam(String value) {
        proTeam.set(value);
    }

    public StringProperty proTeamProperty() {
        return proTeam;
    }
    

    public String getPositions() {
        return positions.get();
    }

    public void setPositions(String value) {
        positions.set(value);
    }

    public StringProperty positionsProperty() {
        return positions;
    }
    
    
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String value) {
        lastName.set(value);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }
    

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String value) {
        firstName.set(value);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }
    
}
