/*
 * Neal Beeken
 * ID: 109069890
 * CSE 219 Stony Brook
 * Prof.  Richard McKenna
 */
package wolfieball.data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Neal
 */
public class FantasyTeamPositionComparator implements Comparator<BaseballPlayer>{

    private static final List<String> orderedPositions = Arrays.asList("C", "1B", "CI", "2B", "3B", "MI", "SS", "OF", "P", "U");

    @Override
    public int compare(BaseballPlayer o1, BaseballPlayer o2) {
        String pos1 = o1.getFantasyPosition();
        String pos2 = o2.getFantasyPosition();
        
        if (orderedPositions.contains(pos1) && orderedPositions.contains(pos2)) {
      // Both objects are in our ordered list. Compare them by
            // their position in the list
            return orderedPositions.indexOf(pos1) - orderedPositions.indexOf(pos2);
        }

        if (orderedPositions.contains(pos1)) {
            // pos1 is in the ordered list, but pos2 isn't. pos1 is smaller (i.e. first)
            return -1;
        }

        if (orderedPositions.contains(pos2)) {
            // pos2 is in the ordered list, but pos1 isn't. pos2 is smaller (i.e. first)
            return 1;
        }

        return pos1.compareTo(pos2);

    }

    
}
