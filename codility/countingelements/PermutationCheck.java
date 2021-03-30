package codility.countingelements;

import java.util.Arrays;

/** A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. */
public class PermutationCheck {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        int isPermutation = solution(array);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", isPermutation);

        int[] array1 = {1,2,3,5};
        isPermutation = solution(array1);
        System.out.printf("The answer is %s, Expected Answer is 0 %n", isPermutation);

        int[] array2 = {4, 1, 3, 2};
        isPermutation = solution(array2);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", isPermutation);

        int[] array3 = {4, 1, 3};
        isPermutation = solution(array3);
        System.out.printf("The answer is %s, Expected Answer is 0 %n", isPermutation);
    }

    public static int solution(int[] array) {
        int missingInteger = 1, isPermutation = 1;
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        
        for(int i = 0; i < sortedArray.length; i++) {
            int elementInArray = sortedArray[i];
            
            if(missingInteger != elementInArray) {
                isPermutation = 0;
                break;
            }

            missingInteger++;
        }

        return isPermutation;
    }
}
