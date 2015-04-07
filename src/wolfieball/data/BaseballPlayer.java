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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Neal
 */
public class BaseballPlayer extends Player{
    private final StringProperty TEAM = new SimpleStringProperty();
    private final StringProperty LAST_NAME = new SimpleStringProperty();
    private final StringProperty FIRST_NAME = new SimpleStringProperty();
    private final StringProperty NOTES = new SimpleStringProperty();
    private final IntegerProperty YEAR_OF_BIRTH = new SimpleIntegerProperty();
    private final StringProperty NATION_OF_BIRTH = new SimpleStringProperty();
    private final DoubleProperty estimatedValue = new SimpleDoubleProperty();

    public double getEstimatedValue() {
        return estimatedValue.get();
    }

    public void setEstimatedValue(double value) {
        estimatedValue.set(value);
    }

    public DoubleProperty estimatedValueProperty() {
        return estimatedValue;
    }
    

    public String getNATION_OF_BIRTH() {
        return NATION_OF_BIRTH.get();
    }

    public void setNATION_OF_BIRTH(String value) {
        NATION_OF_BIRTH.set(value);
    }

    public StringProperty NATION_OF_BIRTHProperty() {
        return NATION_OF_BIRTH;
    }
    
    
    public int getYEAR_OF_BIRTH() {
        return YEAR_OF_BIRTH.get();
    }

    public void setYEAR_OF_BIRTH(int value) {
        YEAR_OF_BIRTH.set(value);
    }

    public IntegerProperty YEAR_OF_BIRTHProperty() {
        return YEAR_OF_BIRTH;
    }
    
    
    public String getNOTES() {
        return NOTES.get();
    }

    public void setNOTES(String value) {
        NOTES.set(value);
    }

    public StringProperty NOTESProperty() {
        return NOTES;
    }
    
    
    public String getFIRST_NAME() {
        return FIRST_NAME.get();
    }

    public void setFIRST_NAME(String value) {
        FIRST_NAME.set(value);
    }

    public StringProperty FIRST_NAMEProperty() {
        return FIRST_NAME;
    }
    
    
    public String getLAST_NAME() {
        return LAST_NAME.get();
    }

    public void setLAST_NAME(String value) {
        LAST_NAME.set(value);
    }

    public StringProperty LAST_NAMEProperty() {
        return LAST_NAME;
    }
    
    public String getTEAM() {
        return TEAM.get();
    }

    public void setTEAM(String value) {
        TEAM.set(value);
    }

    public StringProperty TEAMProperty() {
        return TEAM;
    }

    

    
}
