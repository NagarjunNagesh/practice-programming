package codility.prefixsums;

/*A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. 

TIME COMPLEXITY - O(N)*/
public class MinimumAverageTwoSlice {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        int minimumAverage = solution(array);
        System.out.printf("The Expected answer is 0, The actual value is %s %n", minimumAverage);

        int[] array1 = { 4, 2, 2, 5, 1, 5, 8 };
        minimumAverage = solution(array1);
        System.out.printf("The Expected answer is 1, The actual value is %s %n", minimumAverage);

        int[] array2 = { 6, 2, -1, -2 };
        minimumAverage = solution(array2);
        System.out.printf("The Expected answer is 2, The actual value is %s %n", minimumAverage);

        int[] array3 = { -1, -1 };
        minimumAverage = solution(array3);
        System.out.printf("The Expected answer is 0, The actual value is %s %n", minimumAverage);

        int[] array4 = { -1, 0, -1 };
        minimumAverage = solution(array4);
        System.out.printf("The Expected answer is 0, The actual value is %s %n", minimumAverage);

        int[] array5 = { 5, 4, 3, 2, 1 };
        minimumAverage = solution(array5);
        System.out.printf("The Expected answer is 3, The actual value is %s %n", minimumAverage);

        int[] array6 = { -3, -5, -8, -4, -10 };
        minimumAverage = solution(array6);
        System.out.printf("The Expected answer is 2, The actual value is %s %n", minimumAverage);
    }

    public static int solution(int[] array) {
        float absoluteMinimum = Integer.MAX_VALUE;
        int minimumIndexPosition = 0;
        for (int i = 0; i < array.length - 1; i++) {
            float average = (float) (array[i] + array[i + 1]) / 2;

            if (average < absoluteMinimum) {
                absoluteMinimum = average;
                if (average == absoluteMinimum && minimumIndexPosition != i) {
                    minimumIndexPosition = i;
                }
            }

            // Do not calculate average for 3 for the last iteration
            if (i + 2 == array.length) {
                continue;
            }

            // For Negative Values 3 values / 3 could be the answer
            float averageFor3 = (float) (array[i] + array[i + 1] + array[i + 2]) / 3;
            // If Less then assign minimum position
            if (averageFor3 < absoluteMinimum) {
                absoluteMinimum = averageFor3;
                if (averageFor3 == absoluteMinimum && minimumIndexPosition != i) {
                    minimumIndexPosition = i;
                }
            } else if (averageFor3 == absoluteMinimum && minimumIndexPosition > i) {
                // If Mimimum position is less then
                minimumIndexPosition = i;
            }
        }

        return minimumIndexPosition;
    }
}
