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
public class WComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer W1 = (int)p1.getW();
        Integer W2 = (int)p2.getW();
        return W1.compareTo(W2);
    }
    
}