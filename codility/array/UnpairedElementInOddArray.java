package codility.array;

import java.util.Arrays;
import java.util.Optional;

/* A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. */
public class UnpairedElementInOddArray {
    private static int DEFAULT_RETURN_VALUE = 0;
    public static void main(String[] args) {
        int[] array = {1,2,3,1,2,3,4};
        int oddOccurence = solution(array);
        System.out.printf("Expected 4, We got %s %n", oddOccurence);

        int[] array1 = {1,2,3,1,2,3};
        oddOccurence = solution(array1);
        System.out.printf("Expected 0, We got %s %n", oddOccurence);

        int[] array2 = {3};
        oddOccurence = solution(array2);
        System.out.printf("Expected 3, We got %s %n", oddOccurence);

        int[] array3 = {};
        oddOccurence = solution(array3);
        System.out.printf("Expected 0, We got %s %n", oddOccurence);

        int[] array4 = {9, 3, 9, 3, 9, 7, 9};
        oddOccurence = solution(array4);
        System.out.printf("Expected 7, We got %s %n", oddOccurence);
    }

    public static int solution(int[] array) {
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        Optional<Integer> oddOccurence = Optional.empty();
        Optional<Integer> previousOccurence = Optional.empty();

        for(int element : sortedArray) {
            if(previousOccurence.isEmpty()) {
                previousOccurence = Optional.of(element);
                continue;
            } 
            
            if(previousOccurence.get().intValue() != element){
                break;
            }

            previousOccurence = Optional.empty();
        }

        if(oddOccurence.isEmpty()) {
            oddOccurence = previousOccurence;
        } else {
            oddOccurence = Optional.of(DEFAULT_RETURN_VALUE);
        }

        return oddOccurence.get().intValue();
    }
}
