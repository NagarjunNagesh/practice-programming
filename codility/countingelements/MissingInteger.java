package codility.countingelements;

import java.util.Arrays;

/* This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingInteger {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        int missingInteger = solution(array);
        System.out.printf("The answer is %s, Expected Answer is 4 %n", missingInteger);

        int[] array1 = { -1, -2, -3 };
        missingInteger = solution(array1);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", missingInteger);
    }

    public static int solution(int[] array) {
        int missingInteger = 1;
        int[] sortedArray = Arrays.stream(array).filter(a -> a > 0).sorted().distinct().toArray();

        for (int i = 0; i < sortedArray.length; i++) {
            int elementInArray = sortedArray[i];

            if (missingInteger != elementInArray) {
                break;
            }

            missingInteger++;
        }

        return missingInteger;
    }
}
