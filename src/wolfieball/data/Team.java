/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Neal
 */
public class Team {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty owner = new SimpleStringProperty();
    private final IntegerProperty numberOfPlayer = new SimpleIntegerProperty();
    private final IntegerProperty numberOfCatchers = new SimpleIntegerProperty();
    private final IntegerProperty numberOfPitchers = new SimpleIntegerProperty();
    private final IntegerProperty numberOfFirstbasemen = new SimpleIntegerProperty();
    private final IntegerProperty numberOfSecondbasemen = new SimpleIntegerProperty();
    private final IntegerProperty numberOfThirdbasemen = new SimpleIntegerProperty();
    
    
    public int getNumberOfThirdbasemen() {
        return numberOfThirdbasemen.get();
    }

    public void setNumberOfThirdbasemen(int value) {
        numberOfThirdbasemen.set(value);
    }

    public IntegerProperty numberOfThirdbasemenProperty() {
        return numberOfThirdbasemen;
    }
    
    public int getNumberOfSecondbasemen() {
        return numberOfSecondbasemen.get();
    }

    public void setNumberOfSecondbasemen(int value) {
        numberOfSecondbasemen.set(value);
    }

    public IntegerProperty numberOfSecondbasemenProperty() {
        return numberOfSecondbasemen;
    }

    public int getNumberOfFirstbasemen() {
        return numberOfFirstbasemen.get();
    }

    public void setNumberOfFirstbasemen(int value) {
        numberOfFirstbasemen.set(value);
    }

    public IntegerProperty numberOfFirstbasemenProperty() {
        return numberOfFirstbasemen;
    }
    
    public int getNumberOfPitchers() {
        return numberOfPitchers.get();
    }

    public void setNumberOfPitchers(int value) {
        numberOfPitchers.set(value);
    }

    public IntegerProperty numberOfPitchersProperty() {
        return numberOfPitchers;
    }

    public int getNumberOfCatchers() {
        return numberOfCatchers.get();
    }

    public void setNumberOfCatchers(int value) {
        numberOfCatchers.set(value);
    }

    public IntegerProperty numberOfCatchersProperty() {
        return numberOfCatchers;
    }
    
    public int getNumberOfPlayer() {
        return numberOfPlayer.get();
    }

    public void setNumberOfPlayer(int value) {
        numberOfPlayer.set(value);
    }

    public IntegerProperty numberOfPlayerProperty() {
        return numberOfPlayer;
    }    

    public String getOwner() {
        return owner.get();
    }

    public void setOwner(String value) {
        owner.set(value);
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
}
