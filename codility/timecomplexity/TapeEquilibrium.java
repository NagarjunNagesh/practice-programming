package codility.timecomplexity;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A non-empty array A consisting of N integers is given. Array A represents
 * numbers on a tape.
 * 
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * 
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... +
 * A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * 
 * In other words, it is the absolute difference between the sum of the first
 * part and the sum of the second part.
 * 
 * For example, consider array A such that:
 * 
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 We can split this tape in four
 * places:
 * 
 * P = 1, difference = |3 − 10| = 7 P = 2, difference = |4 − 9| = 5 P = 3,
 * difference = |6 − 7| = 1 P = 4, difference = |10 − 3| = 7 Write a function:
 * 
 * class Solution { public int solution(int[] A); } that, given a non-empty
 * array A of N integers, returns the minimal difference that can be achieved.
 * 
 * For example, given:
 * 
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 the function should return 1, as
 * explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [2..100,000]; each element of array A is an
 * integer within the range [−1,000..1,000]. Copyright 2009–2021 by Codility
 * Limited. All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] array = { 3, 1, 2, 4, 3 };
        int minimalDifference = solution(array);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", minimalDifference);

        int[] array1 = { 3, 4, 1, 2, 3 };
        minimalDifference = solution(array1);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", minimalDifference);

        int[] array2 = { 3, 4, -1, 2, 3 };
        minimalDifference = solution(array2);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", minimalDifference);

        int[] array3 = { -13, 10, -1, 2, 3 };
        minimalDifference = solution(array3);
        System.out.printf("The answer is %s, Expected Answer is 5 %n", minimalDifference);

        int[] array4 = { -13, 10, -1, 2, -23 };
        minimalDifference = solution(array4);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", minimalDifference);

        int[] array5 = { -13, 13 };
        minimalDifference = solution(array5);
        System.out.printf("The answer is %s, Expected Answer is 26 %n", minimalDifference);
    }

    public static int solution(int[] array) {
        Deque<Integer> forwardSumDeque = new ArrayDeque<>(), backwardSumDeque = new ArrayDeque<>();
        int absoluteMinimum = Integer.MAX_VALUE;

        // Find the forward Sums
        // Always split into non empty parts hance (array.length -1)
        for (int i = 0; i < array.length - 1; i++) {
            if (forwardSumDeque.isEmpty()) {
                forwardSumDeque.addLast(array[i]);
            } else {
                int nextSum = forwardSumDeque.getLast() + array[i];
                forwardSumDeque.addLast(nextSum);
            }
        }

        // Minimum One element in the first place
        // Hence i >= 1 instead of i >= 0
        for (int i = (array.length - 1); i >= 1; i--) {
            if (backwardSumDeque.isEmpty()) {
                backwardSumDeque.addFirst(array[i]);
            } else {
                int backwardSum = backwardSumDeque.getFirst() + array[i];
                backwardSumDeque.addFirst(backwardSum);
            }
        }

        while (!forwardSumDeque.isEmpty() && !backwardSumDeque.isEmpty()) {
            int currentMinimum = Math.abs(forwardSumDeque.pop() - backwardSumDeque.pop());
            absoluteMinimum = Math.min(currentMinimum, absoluteMinimum);
        }

        return absoluteMinimum;
    }
}
