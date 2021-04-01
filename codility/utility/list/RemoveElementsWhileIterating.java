package codility.utility.list;

import java.util.Iterator;
import java.util.List;

public class RemoveElementsWhileIterating {
    // Example to remove an element from list while iterating.
    public static void removeElementWhileIterating(List<Integer> list, int compare) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer availableBlock = iterator.next(); // must be called before you can call i.remove()
            if (compare < availableBlock) {
                // Do something
                iterator.remove();
            }
        }
    }
}
