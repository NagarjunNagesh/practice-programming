package hackerrank.minmaxsum;

import java.util.ArrayList;
import java.util.List;

/**
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers. Example
 * 
 * The minimum sum is and the maximum sum is . The function prints 16 24
 * Function Description Complete the miniMaxSum function in the editor below.
 * miniMaxSum has the following parameter(s): arr: an array of integers Print
 * Print two space-separated integers on one line: the minimum sum and the
 * maximum sum of of elements. Input Format A single line of five
 * space-separated integers. Constraints
 * 
 * Output Format Print two space-separated long integers denoting the respective
 * minimum and maximum values that can be calculated by summing exactly four of
 * the five integers. (The output can be greater than a 32 bit integer.) Sample
 * Input 1 2 3 4 5 Sample Output 10 14 Explanation The numbers are , , , , and .
 * Calculate the following sums using four of the five integers: Sum everything
 * except , the sum is . Sum everything except , the sum is . Sum everything
 * except , the sum is . Sum everything except , the sum is . Sum everything
 * except , the sum is . Hints: Beware of integer overflow! Use 64-bit Integer.
 * 
 * Time Complexity: O(N)
 */
public class MinMaxSum {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            arr.add(i);
        }
        minMaxSum(arr);

        List<Integer> arr2 = new ArrayList<Integer>();
        for (int i = 1; i <= 3; i++) {
            arr2.add(i);
        }
        minMaxSum(arr2);
    }

    private static void minMaxSum(List<Integer> arr) {
        long sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        if (arr == null || arr.size() == 0) {
            return;
        }

        for (Integer integer : arr) {
            sum += integer;

            if (min > integer) {
                min = integer;
            }

            if (max < integer) {
                max = integer;
            }
        }

        System.out.printf("min value %d, max value %d, sum %d%n", min, max, sum);
        System.out.printf("%d ", (sum - max));
        System.out.printf("%d %n", (sum - min));
    }

}
