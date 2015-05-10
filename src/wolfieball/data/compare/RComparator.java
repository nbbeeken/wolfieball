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
public class RComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer R1 = (int)p1.getR();
        Integer R2 = (int)p2.getR();
        return R1.compareTo(R2);
    }
    
}