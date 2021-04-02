package codility.maximumsliceproblem;

/* An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].

For example, consider the following array A consisting of six elements such that:

  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.

Write a function,

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.

For example, given array A consisting of six elements such that:

  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
the function should return 356, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..400,000];
each element of array A is an integer within the range [0..200,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. 

TIME COMPLEXITy - O(N)*/
public class MaxProfit {
    public static void main(String[] args) {

        int[] array7 = { 23171, 21011, 21123, 21366, 21013, 21367 };
        int sliceSum = solution(array7);
        System.out.printf("The Number of Equi Leaders are 356, The actual value is %s %n", sliceSum);

        int[] array2 = { 3, 2, 6, 4, 0 };
        sliceSum = solution(array2);
        System.out.printf("The Number of Equi Leaders are 4, The actual value is %s %n", sliceSum);

        int[] array5 = { 1, 1 };
        sliceSum = solution(array5);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", sliceSum);

        int[] array = {};
        sliceSum = solution(array);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", sliceSum);

        int[] array1 = { 1 };
        sliceSum = solution(array1);
        System.out.printf("The Number of Equi Leaders are 0, The actual value is %s %n", sliceSum);

        int[] array3 = { 1, 2, 3, 4, 5 };
        sliceSum = solution(array3);
        System.out.printf("The Number of Equi Leaders are 4, The actual value is %s %n", sliceSum);

        int[] array4 = { 0, 1, 2, 3, 4, 5 };
        sliceSum = solution(array4);
        System.out.printf("The Number of Equi Leaders are 5, The actual value is %s %n", sliceSum);
    }

    public static int solution(int[] array) {
        if (array.length <= 1) {
            return 0;
        }

        int greatestProfit = 0;
        int p = array[0], q = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            int element = array[i];
            int pDifference = element - p;
            int qDifference = element - q;

            if (pDifference >= qDifference) {
                q = element;
            } else if (qDifference > pDifference) {
                p = q;
                q = element;
            }

            greatestProfit = Math.max(greatestProfit, pDifference);
            greatestProfit = Math.max(greatestProfit, qDifference);

        }

        return greatestProfit;
    }
}
