package codility.leader;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A non-empty array A consisting of N integers is given.
 * 
 * The leader of this array is the value that occurs in more than half of the
 * elements of A.
 * 
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0],
 * A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the
 * same value.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 we can find two equi
 * leaders:
 * 
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose
 * value is 4. 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same
 * leader, whose value is 4. The goal is to count the number of equi leaders.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the number
 * of equi leaders.
 * 
 * For example, given:
 * 
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 the function should
 * return 2, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000,000..1,000,000,000].
 * 
 * (4,3,4,4) and (4,2) comination is not an equileader because in array2 (4,2) 4
 * is not the leader because 4 does not occur more than half of the time
 * 
 */
public class EquiLeader {
    public static void main(String[] args) {

        int[] array6 = { 4, 4, 2, 5, 3, 4, 4, 4 };
        int dominator = solution(array6);
        System.out.printf("The Number of Equi Leaders are 3, The actual value is %s %n", dominator);

        int[] array = { 3, 4, 3, 2, 3, -1, 3, 3 };
        dominator = solution(array);
        System.out.printf("The Number of Equi Leaders are 4, The actual value is %s %n", dominator);

        int[] array1 = {};
        dominator = solution(array1);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", dominator);

        int[] array2 = { 1, 2, 3 };
        dominator = solution(array2);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", dominator);

        int[] array3 = { 1, 2, 3, 3 };
        dominator = solution(array3);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", dominator);

        int[] array4 = { 1, 2, 3, 3, 3 };
        dominator = solution(array4);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", dominator);

        int[] array5 = { 4, 3, 4, 4, 4, 2 };
        dominator = solution(array5);
        System.out.printf("The Number of Equi Leaders are 2, The actual value is %s %n", dominator);

    }

    public static int solution(int[] array) {
        Deque<Integer> dominatorQueue = new ArrayDeque<>();

        if (array.length == 0) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            int dominator = array[i];

            switch (dominatorQueue.size()) {
            case 0:
                dominatorQueue.addLast(dominator);
                break;
            default:
                int e1 = dominatorQueue.getLast();
                if (e1 == dominator) {
                    dominatorQueue.addLast(dominator);
                } else {
                    dominatorQueue.removeLast();
                }
                break;
            }
        }

        if (dominatorQueue.isEmpty()) {
            return 0;
        }

        int dominator = dominatorQueue.getLast();
        int possibleDominatorRecurrence = 0;
        int dominatorIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (element == dominator) {
                possibleDominatorRecurrence++;
                dominatorIndex = i;
            }

        }

        // possibleDominatorRecurrence > N/2 then it is a dominator
        dominatorIndex = (possibleDominatorRecurrence > (array.length / 2)) ? dominatorIndex : -1;
        int numberOfEquiLeaders = 0;
        if (dominatorIndex == -1) {
            return 0;
        }

        int currentDominator = array[dominatorIndex];
        int leaderCount = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == currentDominator) {
                leaderCount++;
            }

            // Have the current leader count measure up with the size of the array
            // Minus the total leader count with the current leader count > (size remaining
            // + 1/ 2)
            if (leaderCount > ((i + 1) / 2)
                    && (possibleDominatorRecurrence - leaderCount) > (array.length - (i + 1)) / 2) {
                numberOfEquiLeaders++;
            }
        }

        return numberOfEquiLeaders;

    }
}
