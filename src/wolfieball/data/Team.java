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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Neal
 */
public class Team {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty owner = new SimpleStringProperty();
    private final IntegerProperty numberOfPlayer = new SimpleIntegerProperty(); // NOT TO EXCEED 23
    private final IntegerProperty numberOfC = new SimpleIntegerProperty(); // 2
    private final IntegerProperty numberOfP = new SimpleIntegerProperty(); // 9
    private final IntegerProperty numberOf1B = new SimpleIntegerProperty(); // 1
    private final IntegerProperty numberOf2B = new SimpleIntegerProperty(); // 1
    private final IntegerProperty numberOf3B = new SimpleIntegerProperty(); // 1
    private final IntegerProperty numberOfCI = new SimpleIntegerProperty(); // 1
    private final IntegerProperty numberOfSS = new SimpleIntegerProperty(); // 1
    private final IntegerProperty numberOfMI = new SimpleIntegerProperty(); // 1
    private final IntegerProperty numberOfOF = new SimpleIntegerProperty(); // 5
    private final IntegerProperty numberOfU = new SimpleIntegerProperty(); // 1
    private final IntegerProperty numberOfTaxi = new SimpleIntegerProperty(); // 8
    private final ObservableList<BaseballPlayer> players = FXCollections.observableArrayList();;

    public Team(String teamName) {
        name.setValue(teamName);

    }

    public ObservableList<BaseballPlayer> getPlayers() {
        return players;
    }

    public void addPlayer(BaseballPlayer player) {
        String fantasyPosition = player.getFantasyPosition();
        if (fantasyPosition != null) {
            if (fantasyPosition.equals("C")) {
                int x = numberOfC.get();
                x++;
                numberOfC.set(x);
            }
            if (fantasyPosition.equals("P")) {
                int x = numberOfP.get();
                x++;
                numberOfP.set(x);
            }
            if (fantasyPosition.equals("1B")) {
                int x = numberOf1B.get();
                x++;
                numberOf1B.set(x);
            }
            if (fantasyPosition.equals("2B")) {
                int x = numberOf2B.get();
                x++;
                numberOf2B.set(x);
            }
            if (fantasyPosition.equals("3B")) {
                int x = numberOf3B.get();
                x++;
                numberOf3B.set(x);
            }
            if (fantasyPosition.equals("CI")) {
                int x = numberOfCI.get();
                x++;
                numberOfCI.set(x);
            }
            if (fantasyPosition.equals("SS")) {
                int x = numberOfSS.get();
                x++;
                numberOfSS.set(x);
            }
            if (fantasyPosition.equals("MI")) {
                int x = numberOfMI.get();
                x++;
                numberOfMI.set(x);
            }
            if (fantasyPosition.equals("OF")) {
                int x = numberOfOF.get();
                x++;
                numberOfOF.set(x);
            }
            if (fantasyPosition.equals("U")) {
                int x = numberOfU.get();
                x++;
                numberOfU.set(x);
            }
        }
        players.add(player);

    }
    
    public void removePlayer(BaseballPlayer player) {
               String fantasyPosition = player.getFantasyPosition();
        if (fantasyPosition != null) {
            if (fantasyPosition.equals("C")) {
                int x = numberOfC.get();
                x--;
                numberOfC.set(x);
            }
            if (fantasyPosition.equals("P")) {
                int x = numberOfP.get();
                x--;
                numberOfP.set(x);
            }
            if (fantasyPosition.equals("1B")) {
                int x = numberOf1B.get();
                x--;
                numberOf1B.set(x);
            }
            if (fantasyPosition.equals("2B")) {
                int x = numberOf2B.get();
                x--;
                numberOf2B.set(x);
            }
            if (fantasyPosition.equals("3B")) {
                int x = numberOf3B.get();
                x--;
                numberOf3B.set(x);
            }
            if (fantasyPosition.equals("CI")) {
                int x = numberOfCI.get();
                x--;
                numberOfCI.set(x);
            }
            if (fantasyPosition.equals("SS")) {
                int x = numberOfSS.get();
                x--;
                numberOfSS.set(x);
            }
            if (fantasyPosition.equals("MI")) {
                int x = numberOfMI.get();
                x--;
                numberOfMI.set(x);
            }
            if (fantasyPosition.equals("OF")) {
                int x = numberOfOF.get();
                x--;
                numberOfOF.set(x);
            }
            if (fantasyPosition.equals("U")) {
                int x = numberOfU.get();
                x--;
                numberOfU.set(x);
            }
        }
        players.remove(player);
    }
    
    public int getNumberOfTaxi() {
        return numberOfTaxi.get();
    }

    public void setNumberOfTaxi(int value) {
        numberOfTaxi.set(value);
    }

    public IntegerProperty numberOfTaxiProperty() {
        return numberOfTaxi;
    }
    
    

    public int getNumberOfU() {
        return numberOfU.get();
    }

    public void setNumberOfU(int value) {
        numberOfU.set(value);
    }

    public IntegerProperty numberOfUProperty() {
        return numberOfU;
    }
    
    

    public int getNumberOfOF() {
        return numberOfOF.get();
    }

    public void setNumberOfOF(int value) {
        numberOfOF.set(value);
    }

    public IntegerProperty numberOfOFProperty() {
        return numberOfOF;
    }
    

    public int getNumberOfMI() {
        return numberOfMI.get();
    }

    public void setNumberOfMI(int value) {
        numberOfMI.set(value);
    }

    public IntegerProperty numberOfMIProperty() {
        return numberOfMI;
    }
    

    public int getNumberOfSS() {
        return numberOfSS.get();
    }

    public void setNumberOfSS(int value) {
        numberOfSS.set(value);
    }

    public IntegerProperty numberOfSSProperty() {
        return numberOfSS;
    }
    

    public int getNumberOfCornerInfielder() {
        return numberOfCI.get();
    }

    public void setNumberOfCornerInfielder(int value) {
        numberOfCI.set(value);
    }

    public IntegerProperty numberOfCornerInfielderProperty() {
        return numberOfCI;
    }
    
    public int getNumberOfThirdbasemen() {
        return numberOf3B.get();
    }

    public void setNumberOfThirdbasemen(int value) {
        numberOf3B.set(value);
    }

    public IntegerProperty numberOfThirdbasemenProperty() {
        return numberOf3B;
    }
    
    public int getNumberOfSecondbasemen() {
        return numberOf2B.get();
    }

    public void setNumberOfSecondbasemen(int value) {
        numberOf2B.set(value);
    }

    public IntegerProperty numberOfSecondbasemenProperty() {
        return numberOf2B;
    }

    public int getNumberOfFirstbasemen() {
        return numberOf1B.get();
    }

    public void setNumberOfFirstbasemen(int value) {
        numberOf1B.set(value);
    }

    public IntegerProperty numberOfFirstbasemenProperty() {
        return numberOf1B;
    }
    
    public int getNumberOfPitchers() {
        return numberOfP.get();
    }

    public void setNumberOfPitchers(int value) {
        numberOfP.set(value);
    }

    public IntegerProperty numberOfPitchersProperty() {
        return numberOfP;
    }

    public int getNumberOfCatchers() {
        return numberOfC.get();
    }

    public void setNumberOfCatchers(int value) {
        numberOfC.set(value);
    }

    public IntegerProperty numberOfCatchersProperty() {
        return numberOfC;
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

    @Override
    public String toString() {
        return name.get();
    }


    
    
}
