/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Neal
 */
public class Hitter extends BaseballPlayer{
    private final StringProperty QP = new SimpleStringProperty();
    private final DoubleProperty AB = new SimpleDoubleProperty();
    private final DoubleProperty R = new SimpleDoubleProperty();
    private final DoubleProperty H = new SimpleDoubleProperty();
    private final DoubleProperty HR = new SimpleDoubleProperty();
    private final DoubleProperty RBI = new SimpleDoubleProperty();
    private final DoubleProperty SB = new SimpleDoubleProperty();
    //Calculated
    private final DoubleProperty BA = new SimpleDoubleProperty();

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
    
}
