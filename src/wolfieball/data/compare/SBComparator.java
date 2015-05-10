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
public class SBComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer SB1 = (int)p1.getSB();
        Integer SB2 = (int)p2.getSB();
        return SB1.compareTo(SB2);
    }
    
}