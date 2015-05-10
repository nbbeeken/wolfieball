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
public class BAComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer BA1 = (int)p1.getBA();
        Integer BA2 = (int)p2.getBA();
        return BA1.compareTo(BA2);
    }
    
}