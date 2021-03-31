package codility.utility.array;

import java.util.Arrays;

public class FilterLessThanOneElements {

    // The mose efficient way to remove duplicates
    // TIME COMPLEXITY : O(N)
    public static int[] filterLessThanOneElements(int[] unfilteredArray) {
        int k = 0;
        for (int i = 0; i < unfilteredArray.length; i++) {
            if (unfilteredArray[i] > 0) {
                unfilteredArray[k++] = unfilteredArray[i];
            }
        }
        return Arrays.copyOfRange(unfilteredArray, 0, k);
    }
}
