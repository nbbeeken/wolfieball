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
public class PitcherRankComparator implements Comparator<BaseballPlayer>{

    @Override
    public int compare(BaseballPlayer o1, BaseballPlayer o2) {
        //W, SV, K, ERA, WHIP
        Double rankP1 = o1.getW() + o1.getSV() + o1.getK() + o1.getERA() + o1.getWHIP();
        Double rankP2 = o2.getW() + o2.getSV() + o2.getK() + o2.getERA() + o2.getWHIP();
        return rankP2.compareTo(rankP1);
    }
    
}
