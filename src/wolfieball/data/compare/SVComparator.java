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
public class SVComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer SV1 = (int)p1.getSV();
        Integer SV2 = (int)p2.getSV();
        return SV1.compareTo(SV2);
    }
    
}