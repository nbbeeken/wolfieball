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
public class HRComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer HR1 = (int)p1.getHR();
        Integer HR2 = (int)p2.getHR();
        return HR1.compareTo(HR2);
    }
    
}