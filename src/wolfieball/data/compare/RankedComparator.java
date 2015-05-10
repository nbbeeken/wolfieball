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
public class RankedComparator implements Comparator<BaseballPlayer>{

    @Override
    public int compare(BaseballPlayer p1, BaseballPlayer p2) {
        Double p1Rank = p1.getRank();
        Double p2Rank = p2.getRank();
        return p1Rank.compareTo(p2Rank);
    }
    
}
