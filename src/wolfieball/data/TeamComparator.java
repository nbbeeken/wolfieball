/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import java.util.Comparator;

/**
 *
 * @author Neal
 */
public class TeamComparator implements Comparator<Team>{

    @Override
    public int compare(Team o1, Team o2) {
           return o1.getName().compareTo(o2.getName());
    }
    
}
