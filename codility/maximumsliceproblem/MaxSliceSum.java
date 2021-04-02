package codility.maximumsliceproblem;

/*A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

For example, given array A such that:

A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0
the function should return 5 because:

(3, 4) is a slice of A that has sum 4,
(2, 2) is a slice of A that has sum −6,
(0, 1) is a slice of A that has sum 5,
no other slice of A has sum greater than (0, 1).
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..1,000,000];
each element of array A is an integer within the range [−1,000,000..1,000,000];
the result will be an integer within the range [−2,147,483,648..2,147,483,647].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. */
public class MaxSliceSum {

    public static void main(String[] args) {

        int[] array5 = { 1, 1 };
        int sliceSum = solution(array5);
        System.out.printf("The Number of Equi Leaders are 2, The actual value is %s %n", sliceSum);

        int[] array = {};
        sliceSum = solution(array);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", sliceSum);

        int[] array1 = { 1 };
        sliceSum = solution(array1);
        System.out.printf("The Number of Equi Leaders are 1, The actual value is %s %n", sliceSum);

        int[] array2 = { 3, 2, -6, 4, 0 };
        sliceSum = solution(array2);
        System.out.printf("The Number of Equi Leaders are 5, The actual value is %s %n", sliceSum);

        int[] array3 = { -1, -2, -3, -4, -5 };
        sliceSum = solution(array3);
        System.out.printf("The Number of Equi Leaders are -1, The actual value is %s %n", sliceSum);

        int[] array4 = { 0, -1, -2, -3, -4, -5 };
        sliceSum = solution(array4);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", sliceSum);
    }

    public static int solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int maximumAmount = array[0], absoluteMaximum = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            int element = array[i];
            maximumAmount += element;

            maximumAmount = Math.max(maximumAmount, element);
            absoluteMaximum = Math.max(absoluteMaximum, maximumAmount);
        }

        return absoluteMaximum;
    }

}
