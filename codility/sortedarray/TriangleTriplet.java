package codility.sortedarray;

import java.util.Arrays;

/* An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

        A[P] + A[Q] > A[R],
        A[Q] + A[R] > A[P],
        A[R] + A[P] > A[Q].

For example, consider array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20

Triplet (0, 2, 4) is triangular.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:
A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20

the function should return 1, as explained above. Given array A such that:
  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1

the function should return 0.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].


TIME COMPLEXITY - O(N*log(N)) 
*/
public class TriangleTriplet {
    public static void main(String[] args) {
        int[] array = {10, 50, 5, 1};
        int isTriangle = solution(array);
        System.out.printf("The answer is %s, Expected Answer is 0 %n", isTriangle);

        int[] array1 = {10, 2, 5, 1, 8, 20};
        isTriangle = solution(array1);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", isTriangle);

        int[] array2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        isTriangle = solution(array2);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", isTriangle);
    }
    
    public static int solution(int[] unfilteredArray) {
        int[] array = filterLessThanOneElements(unfilteredArray);

        for(int i = 0; i <= (array.length - 3) ; i++) {
            long p = array[i];
            for(int j = i+1; j <= (array.length - 2); j++) {
                long q = array[j];
                for(int k = j+1; k <= (array.length - 1); k++) {
                    long r = array[k];
                    if((p + q > r) && (q + r > p) && (r + p > q)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    // The mose efficient way to remove duplicates
    // TIME COMPLEXITY : O(N)
    private static int[] filterLessThanOneElements(int[] unfilteredArray) {
        int k = 0;
        for(int i = 0; i < unfilteredArray.length; i++) {
            if(unfilteredArray[i] > 0) {
                unfilteredArray[k++] = unfilteredArray[i];
            }
        }
        return Arrays.copyOfRange(unfilteredArray, 0, k);
    }
}
