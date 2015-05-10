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
public class ERAComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer ERA1 = (int)p1.getERA();
        Integer ERA2 = (int)p2.getERA();
        return ERA1.compareTo(ERA1);
    }
    
}