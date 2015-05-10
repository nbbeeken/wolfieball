/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data.compare;

import java.util.Comparator;
import wolfieball.data.Team;

/**
 *
 * @author Neal
 */
public class WHIPComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer WHIP1 = (int)p1.getWHIP();
        Integer WHIP2 = (int)p2.getWHIP();
        return WHIP1.compareTo(WHIP2);
    }
    
}