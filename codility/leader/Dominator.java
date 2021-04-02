package codility.leader;

import java.util.ArrayDeque;
import java.util.Deque;

/* An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

TIME COMPLEXITY - O(N)*/
public class Dominator {
    public static void main(String[] args) {
        int[] array = { 3, 4, 3, 2, 3, -1, 3, 3 };
        int dominator = solution(array);
        System.out.printf("The Expected Dominator is 0, The actual value is %s %n", dominator);

        int[] array1 = {};
        dominator = solution(array1);
        System.out.printf("The Expected Dominator is -1, The actual value is %s %n", dominator);

        int[] array2 = { 1, 2, 3 };
        dominator = solution(array2);
        System.out.printf("The Expected Dominator is -1, The actual value is %s %n", dominator);

        int[] array3 = { 1, 2, 3, 3 };
        dominator = solution(array3);
        System.out.printf("The Expected Dominator is -1, The actual value is %s %n", dominator);

        int[] array4 = { 1, 2, 3, 3, 3 };
        dominator = solution(array4);
        System.out.printf("The Expected Dominator is 4, The actual value is %s %n", dominator);
    }

    public static int solution(int[] array) {
        Deque<Integer> dominatorQueue = new ArrayDeque<>();

        if (array.length == 0) {
            return -1;
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
            return -1;
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
        return (possibleDominatorRecurrence > (array.length / 2)) ? dominatorIndex : -1;
    }
}
