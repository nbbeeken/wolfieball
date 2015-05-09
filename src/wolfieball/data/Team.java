/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.When;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
    IntegerProperty xero = new SimpleIntegerProperty(Integer.MAX_VALUE);
    
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty owner = new SimpleStringProperty();
    private final IntegerProperty money = new SimpleIntegerProperty();
    private final DoubleProperty R = new SimpleDoubleProperty();
    private final DoubleProperty HR = new SimpleDoubleProperty();
    private final DoubleProperty RBI = new SimpleDoubleProperty();
    private final DoubleProperty SB = new SimpleDoubleProperty();
    private final DoubleProperty BA = new SimpleDoubleProperty();
    private final DoubleProperty W = new SimpleDoubleProperty();
    private final DoubleProperty SV = new SimpleDoubleProperty();
    private final DoubleProperty K = new SimpleDoubleProperty();
    private final DoubleProperty ERA = new SimpleDoubleProperty();
    private final DoubleProperty WHIP = new SimpleDoubleProperty();
    private final DoubleProperty totalPoints = new SimpleDoubleProperty();
    

    public double getTotalPoints() {
        return totalPoints.get();
    }

    public void setTotalPoints(double value) {
        totalPoints.set(value);
    }

    public DoubleProperty totalPointsProperty() {
        return totalPoints;
    }
    

    public double getWHIP() {
        return WHIP.get();
    }

    public void setWHIP(double value) {
        WHIP.set(value);
    }

    public DoubleProperty WHIPProperty() {
        return WHIP;
    }
    
    
    public double getERA() {
        return ERA.get();
    }

    public void setERA(double value) {
        ERA.set(value);
    }

    public DoubleProperty ERAProperty() {
        return ERA;
    }
    

    public double getK() {
        return K.get();
    }

    public void setK(double value) {
        K.set(value);
    }

    public DoubleProperty KProperty() {
        return K;
    }
    

    public double getSV() {
        return SV.get();
    }

    public void setSV(double value) {
        SV.set(value);
    }

    public DoubleProperty SVProperty() {
        return SV;
    }
    
    
    public double getW() {
        return W.get();
    }

    public void setW(double value) {
        W.set(value);
    }

    public DoubleProperty WProperty() {
        return W;
    }
    

    public double getBA() {
        return BA.get();
    }

    public void setBA(double value) {
        BA.set(value);
    }

    public DoubleProperty BAProperty() {
        return BA;
    }
    

    public double getSB() {
        return SB.get();
    }

    public void setSB(double value) {
        SB.set(value);
    }

    public DoubleProperty SBProperty() {
        return SB;
    }
    

    public double getRBI() {
        return RBI.get();
    }

    public void setRBI(double value) {
        RBI.set(value);
    }

    public DoubleProperty RBIProperty() {
        return RBI;
    }
    
    
    public double getHR() {
        return HR.get();
    }

    public void setHR(double value) {
        HR.set(value);
    }

    public DoubleProperty HRProperty() {
        return HR;
    }
    

    public double getR() {
        return R.get();
    }

    public void setR(double value) {
        R.set(value);
    }

    public DoubleProperty RProperty() {
        return R;
    }
    

    public int getMoney() {
        return money.get();
    }

    public void setMoney(int value) {
        money.set(value);
    }

    public IntegerProperty moneyProperty() {
        return money;
    }
    
    
    
    
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
    private ObservableList<BaseballPlayer> players = FXCollections.observableArrayList();;

    public Team(String teamName) {
        
        name.setValue(teamName);
        money.set(260);
        IntegerProperty twentyThree = new SimpleIntegerProperty(23);
        neededPlayers.bind(twentyThree.subtract(numberOfPlayer));
        
        //moneyPerPlayer.bind(money.divide(neededPlayers));
        
    }

    public ObservableList<BaseballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ObservableList<BaseballPlayer> players) {
        this.players = players;
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
        money.subtract(player.salaryProperty());
        players.add(player);
        recalculate();
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
        money.add(player.salaryProperty());
        players.remove(player);
        recalculate();
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

    public void recalculate() {
        double R_local = 0;
        double HR_local = 0;
        double RBI_local = 0;
        double SB_local = 0;
        double BA_local = 0;
        double W_local = 0;
        double SV_local = 0;
        double K_local = 0;
        double ERA_local = 0;
        double WHIP_local = 0;
        int numPlayers = players.size();
        numberOfPlayer.set(numPlayers);
        int salarySum = 0;
        for( BaseballPlayer player : players){
            if(player.isIsHitter()){
                R_local += player.getR();
                R_local /= numPlayers;
                HR_local += player.getHR();
                HR_local /= numPlayers;
                RBI_local += player.getRBI();
                RBI_local /= numPlayers;
                SB_local += player.getSB();
                SB_local /= numPlayers;
                BA_local += player.getBA();
                BA_local /= numPlayers;
            } else {
                W_local += player.getW();
                W_local /= numPlayers;
                SV_local += player.getSV();
                SV_local /= numPlayers;
                K_local += player.getK();
                K_local /= numPlayers;
                ERA_local += player.getERA();
                ERA_local /= numPlayers;
                WHIP_local += player.getWHIP();
                WHIP_local /= numPlayers;
            }
            salarySum += player.getSalary();
        }
        
        R.set(R_local);
        HR.set(HR_local);
        RBI.set(RBI_local);
        SB.set(SB_local);
        BA.set(BA_local);
        W.set(W_local);
        SV.set(SV_local);
        K.set(K_local);
        ERA.set(ERA_local);
        WHIP.set(WHIP_local);
        //neededPlayers.set(23-numberOfPlayer.get());
        money.set(260 - salarySum);
        //moneyPerPlayer.set(money.get()/(neededPlayers.get()==0?1:neededPlayers.get()));
        
    }
    private final IntegerProperty neededPlayers = new SimpleIntegerProperty();

    public int getNeededPlayers() {
        return neededPlayers.get();
    }

    public void setNeededPlayers(int value) {
        neededPlayers.set(value);
    }

    public IntegerProperty neededPlayersProperty() {
        return neededPlayers;
    }
    
    private final NumberBinding moneyPerPlayer = new When(neededPlayers.isEqualTo(0)).then(money.divide(xero)).otherwise(money.divide(neededPlayers));

    public int getMoneyPerPlayer() {
        return 0;
        //return moneyPerPlayer.get();
    }

    public void setMoneyPerPlayer(int value) {
        //moneyPerPlayer.set(value);
    }

    public IntegerProperty moneyPerPlayerProperty() {
        return new SimpleIntegerProperty(moneyPerPlayer.getValue().intValue());
    }
    
    
    
    
}
