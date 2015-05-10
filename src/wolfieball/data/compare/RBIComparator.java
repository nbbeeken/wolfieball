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
public class RBIComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer RBI1 = (int)p1.getRBI();
        Integer RBI2 = (int)p2.getRBI();
        return RBI1.compareTo(RBI2);
    }
    
}