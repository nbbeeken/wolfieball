/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data.compare;

import java.util.Comparator;
import wolfieball.data.BaseballPlayer;

/**
 *
 * @author Neal
 */
public class HitterRankComparator implements Comparator<BaseballPlayer>{

    @Override
    public int compare(BaseballPlayer o1, BaseballPlayer o2) {
        //R, HR, RBI, SB, BA
        Double rankH1 = o1.getR() + o1.getHR() + o1.getRBI() + o1.getSB() + o1.getBA();
        Double rankH2 = o2.getR() + o2.getHR() + o2.getRBI() + o2.getSB() + o2.getBA();
        return rankH2.compareTo(rankH1);
    }
    
}
