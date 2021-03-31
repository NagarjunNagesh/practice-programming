package codility.sortedarray;

import java.util.Arrays;

/*A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].

Need to iterate because -5 * -5 = 25 (- * - = +)

TIME COMPLEXITY = O(N * log(N))
*/
public class MaxProductOfThreee {

    public static void main(String[] args) {
        int[] array = { -5, 5, -5, 4 };
        int distinctNumbers = solution(array);
        System.out.printf("The answer is %s, Expected Answer is 125 %n", distinctNumbers);

        int[] array2 = { -3, 1, 2, -2, 5, 6 };
        distinctNumbers = solution(array2);
        System.out.printf("The answer is %s, Expected Answer is 60 %n", distinctNumbers);

        int[] array3 = { -2, -3, -4, -5, 0, -1 };
        distinctNumbers = solution(array3);
        System.out.printf("The answer is %s, Expected Answer is 0 %n", distinctNumbers);

        int[] array4 = { -10, -2, -4 };
        distinctNumbers = solution(array4);
        System.out.printf("The answer is %s, Expected Answer is -80 %n", distinctNumbers);
    }

    public static int solution(int[] array) {
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        int maximalValue = 0;

        switch (array.length) {
        case 0:
            break;
        case 1:
            maximalValue = array[0];
        case 2:
            maximalValue = array[0] * array[1];
        case 3:
            maximalValue = multiplyLastThreeElements(array);
        default:
            maximalValue = calculateMaximumValue(sortedArray);
        }

        return maximalValue;
    }

    private static int multiplyLastThreeElements(int[] sortedArray) {
        return sortedArray[sortedArray.length - 3] * sortedArray[sortedArray.length - 2]
                * sortedArray[sortedArray.length - 1];
    }

    private static int calculateMaximumValue(int[] sortedArray) {
        int leastNegativeValue = sortedArray[0];
        int secondLeastNegativeValue = sortedArray[1];
        int multiplyFirstTwoElements = leastNegativeValue * secondLeastNegativeValue;

        int maximalValue = multiplyLastThreeElements(sortedArray);

        int possiblePositiveValue = sortedArray[sortedArray.length - 1];
        int onePossibleMaximumValue = multiplyFirstTwoElements * possiblePositiveValue;
        if (onePossibleMaximumValue > maximalValue) {
            maximalValue = onePossibleMaximumValue;
        }

        int thirdLeastnegativeValue = sortedArray[2];
        int secondPossibleMaximumValue = multiplyFirstTwoElements * thirdLeastnegativeValue;
        if (secondPossibleMaximumValue > maximalValue) {
            maximalValue = secondPossibleMaximumValue;
        }

        return maximalValue;
    }
}
