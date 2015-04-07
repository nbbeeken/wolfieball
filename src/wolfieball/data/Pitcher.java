/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Neal
 */
public class Pitcher extends BaseballPlayer{
    private final DoubleProperty IP = new SimpleDoubleProperty();
    private final DoubleProperty ER = new SimpleDoubleProperty();
    private final DoubleProperty W = new SimpleDoubleProperty();
    private final DoubleProperty SV = new SimpleDoubleProperty();
    private final DoubleProperty H = new SimpleDoubleProperty();
    private final DoubleProperty BB = new SimpleDoubleProperty();
    private final DoubleProperty K = new SimpleDoubleProperty();
    //Calculated
    private final DoubleProperty ERA = new SimpleDoubleProperty();
    private final DoubleProperty WHIP = new SimpleDoubleProperty();
    

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
    
    
    public double getBB() {
        return BB.get();
    }

    public void setBB(double value) {
        BB.set(value);
    }

    public DoubleProperty BBProperty() {
        return BB;
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
 

    
}
