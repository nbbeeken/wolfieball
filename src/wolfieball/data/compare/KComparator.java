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
public class KComparator implements Comparator<Team>{

    @Override
    public int compare(Team p1, Team p2) {
        Integer K1 = (int)p1.getK();
        Integer K2 = (int)p2.getK();
        return K1.compareTo(K2);
    }
    
}