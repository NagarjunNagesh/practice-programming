package hackerrank.lonelyinteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Given an array of integers, where all elements but one occur twice, find the
 * unique element. Example
 * 
 * The unique element is . Function Description Complete the lonelyinteger
 * function in the editor below. lonelyinteger has the following parameter(s):
 * int a[n]: an array of integers Returns int: the element that occurs only once
 * Input Format The first line contains a single integer, , the number of
 * integers in the array. The second line contains space-separated integers that
 * describe the values in . Constraints
 * 
 * It is guaranteed that is an odd number and that there is one unique element.
 * , where .
 * 
 * Time Complexity O(N)
 */
public class LonelyInteger {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        for (int i = 99; i > 1; i--) {
            a.add(i);
            a.add(i);
        }
        int lonelyNumber = lonelyinteger(a);
        System.out.printf("%d%n", lonelyNumber);

        List<Integer> a2 = new ArrayList<Integer>();
        a2.add(100);
        for (int i = 99; i > 0; i--) {
            a2.add(i);
            a2.add(i);
        }
        lonelyNumber = lonelyinteger(a2);
        System.out.printf("%d%n", lonelyNumber);

    }

    public static int lonelyinteger(List<Integer> a) {
        if (a == null || a.size() == 0) {
            return -1;
        }

        List<Integer> sortedList = a.stream().sorted().collect(Collectors.toList());
        Optional<Integer> matchingNumber = Optional.empty(), lonelyNumber = Optional.empty();

        for (int i = 0; i < sortedList.size(); i++) {
            int aNumber = sortedList.get(i);

            if (matchingNumber.isEmpty()) {
                matchingNumber = Optional.of(aNumber);
            } else if (matchingNumber.isPresent()) {

                if (matchingNumber.get().intValue() == aNumber) {
                    matchingNumber = Optional.empty();
                } else if (matchingNumber.get().intValue() != aNumber) {
                    lonelyNumber = matchingNumber;
                    break;
                }
            }
        }

        if (matchingNumber.isPresent()) {
            lonelyNumber = matchingNumber;
        }

        return lonelyNumber.get();

    }
}
