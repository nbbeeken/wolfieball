/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Neal
 */
public class BaseballPlayer extends Player{

    private final IntegerProperty salary;
    private final IntegerProperty runs;
    private final IntegerProperty homeRuns;
    private final IntegerProperty runsBattedIn;
    private final IntegerProperty stolenBases;
    private final DoubleProperty battingAverage;

    public BaseballPlayer(StringProperty lastName, StringProperty firstName, IntegerProperty salary, IntegerProperty runs, IntegerProperty homeRuns, IntegerProperty runsBattedIn, IntegerProperty stolenBases, DoubleProperty battingAverage) {
        super(lastName, firstName);
        this.salary = salary;
        this.runs = runs;
        this.homeRuns = homeRuns;
        this.runsBattedIn = runsBattedIn;
        this.stolenBases = stolenBases;
        this.battingAverage = battingAverage;
    }

    public BaseballPlayer(StringProperty lastName, StringProperty firstName) {
        super(lastName, firstName);
        salary = new SimpleIntegerProperty();
        runs = new SimpleIntegerProperty();
        homeRuns = new SimpleIntegerProperty();
        stolenBases = new SimpleIntegerProperty();
        runsBattedIn = new SimpleIntegerProperty();
        battingAverage = new SimpleDoubleProperty();
    }

    private int getSalary() {
        return salary.get();
    }

    private void setSalary(int value) {
        salary.set(value);
    }

    private IntegerProperty salaryProperty() {
        return salary;
    }
    
    private int getRuns() {
        return runs.get();
    }

    private void setRuns(int value) {
        runs.set(value);
    }

    private IntegerProperty runsProperty() {
        return runs;
    }
    
    private int getHomeRuns() {
        return homeRuns.get();
    }

    private void setHomeRuns(int value) {
        homeRuns.set(value);
    }

    private IntegerProperty homeRunsProperty() {
        return homeRuns;
    }

    private int getStolenBases() {
        return stolenBases.get();
    }

    private void setStolenBases(int value) {
        stolenBases.set(value);
    }

    private IntegerProperty stolenBasesProperty() {
        return stolenBases;
    }
    
    private int getRunsBattedIn() {
        return runsBattedIn.get();
    }

    private void setRunsBattedIn(int value) {
        runsBattedIn.set(value);
    }

    private IntegerProperty runsBattedInProperty() {
        return runsBattedIn;
    }
    
    private double getBattingAverage() {
        return battingAverage.get();
    }

    private void setBattingAverage(int value) {
        battingAverage.set(value);
    }

    private DoubleProperty battingAverageProperty() {
        return battingAverage;
    }
}
