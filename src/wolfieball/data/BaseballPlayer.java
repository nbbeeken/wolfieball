/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Neal
 */
public final class BaseballPlayer{
    private final BooleanProperty isHitter = new SimpleBooleanProperty();
    IntegerProperty nine = new SimpleIntegerProperty(9);
    IntegerProperty xero = new SimpleIntegerProperty(Integer.MAX_VALUE);

    public boolean isIsHitter() {
        return isHitter.get();
    }

    public void setIsHitter(boolean value) {
        isHitter.set(value);
    }

    public BooleanProperty isHitterProperty() {
        return isHitter;
    }
    
    private final StringProperty TEAM = new SimpleStringProperty();
    private final StringProperty LAST_NAME = new SimpleStringProperty();
    private final StringProperty FIRST_NAME = new SimpleStringProperty();
    private final StringProperty NOTES = new SimpleStringProperty();
    private final IntegerProperty YEAR_OF_BIRTH = new SimpleIntegerProperty();
    private final StringProperty NATION_OF_BIRTH = new SimpleStringProperty();
    private final DoubleProperty estimatedValue = new SimpleDoubleProperty();

    public BaseballPlayer() {
        calcStats();
       
    }

    public void calcStats() {
        //BA, ERA, WHIP
        
        if(AB.get() != 0)BA.set(H.get()/AB.get());
        if(IP.get() != 0){
            ERA.set(9 * (ER.get()/IP.get()));
            WHIP.set((BB.get()+H_P.get())/IP.get());
        }
    }
    
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

    // Hitter
    
    private final StringProperty QP = new SimpleStringProperty();
    private final DoubleProperty AB = new SimpleDoubleProperty();
    private final DoubleProperty R = new SimpleDoubleProperty();
    private final DoubleProperty H = new SimpleDoubleProperty();
    private final DoubleProperty HR = new SimpleDoubleProperty();
    private final DoubleProperty RBI = new SimpleDoubleProperty();
    private final DoubleProperty SB = new SimpleDoubleProperty();
    //Calculated //BA.bind(H.divide(AB));
    private final DoubleProperty BA = new SimpleDoubleProperty();

    public double getBA() {
        return 0;
        //return BA.get();
    }

    public void setBA(double value) {
        //BA.set(value);
    }

    public DoubleProperty BAProperty() {
        return new SimpleDoubleProperty(BA.getValue().doubleValue());
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
    
    
    public double getH() {
        return H.get();
    }

    public void setH(double value) {
        H.set(value);
    }

    public DoubleProperty HProperty() {
        return H;
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
    
    public double getAB() {
        return AB.get();
    }

    public void setAB(double value) {
        AB.set(value);
    }

    public DoubleProperty ABProperty() {
        return AB;
    }
    
    
    public String getQP() {
        return QP.get();
    }

    public void setQP(String value) {
        QP.set(value);
    }

    public StringProperty QPProperty() {
        return QP;
    }
    
    //Pitcher
    
//    ERA.bind(nine.multiply(ER.divide(IP)));
//        WHIP.bind();
    
    private final DoubleProperty IP = new SimpleDoubleProperty();
    private final DoubleProperty ER = new SimpleDoubleProperty();
    private final DoubleProperty W = new SimpleDoubleProperty();
    private final DoubleProperty SV = new SimpleDoubleProperty();
    private final DoubleProperty H_P = new SimpleDoubleProperty();
    private final DoubleProperty BB = new SimpleDoubleProperty();
    private final DoubleProperty K = new SimpleDoubleProperty();
    //Calculated
    private final DoubleProperty ERA = new SimpleDoubleProperty();
    private final DoubleProperty WHIP = new SimpleDoubleProperty();
    

    public double getWHIP() {
        return 0;
        //return WHIP.get();
    }

    public void setWHIP(double value) {
        //WHIP.set(value);
    }

    public DoubleProperty WHIPProperty() {
        return WHIP;
    }
    
    
    public double getERA() {
        return 0;
        //return ERA.get();
    }

    public void setERA(double value) {
        //ERA.set(value);
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
    
    
    public double getBB() {
        return BB.get();
    }

    public void setBB(double value) {
        BB.set(value);
    }

    public DoubleProperty BBProperty() {
        return BB;
    }
    
    
    public double getH_P() {
        return H_P.get();
    }

    public void setH_P(double value) {
        H_P.set(value);
    }

    public DoubleProperty H_PProperty() {
        return H_P;
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
    
    public double getER() {
        return ER.get();
    }

    public void setER(double value) {
        ER.set(value);
    }

    public DoubleProperty ERProperty() {
        return ER;
    }
    

    public double getIP() {
        return IP.get();
    }

    public void setIP(double value) {
        IP.set(value);
    }

    public DoubleProperty IPProperty() {
        return IP;
    }
    
    
    private final StringProperty fantasyTeam = new SimpleStringProperty();
    private final DoubleProperty salary = new SimpleDoubleProperty();
    private final StringProperty contract = new SimpleStringProperty();
    private final StringProperty fantasyPosition = new SimpleStringProperty();

    public String getFantasyPosition() {
        return fantasyPosition.get();
    }

    public void setFantasyPosition(String value) {
        fantasyPosition.set(value);
    }

    public StringProperty fantasyPositionProperty() {
        return fantasyPosition;
    }
    

    public String getContract() {
        return contract.get();
    }

    public void setContract(String value) {
        contract.set(value);
    }

    public StringProperty contractProperty() {
        return contract;
    }
    
    
    public double getSalary() {
        return salary.get();
    }

    public void setSalary(double value) {
        salary.set(value);
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }
    
    
    public String getFantasyTeam() {
        return fantasyTeam.get();
    }

    public void setFantasyTeam(String value) {
        fantasyTeam.set(value);
    }

    public StringProperty fantasyTeamProperty() {
        return fantasyTeam;
    }

    public double getRank() {
        double val =  (AB.get() + BB.get() + ER.get() + H.get() + HR.get() + H_P.get() + IP.get()  + K.get() + R.get()  + RBI.get() + SB.get()  + SV.get() + W.get());
        return val;
    }
 
    
    
}
