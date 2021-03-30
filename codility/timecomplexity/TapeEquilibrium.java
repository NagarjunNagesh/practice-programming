package codility.timecomplexity;

/** A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7 
P = 2, difference = |4 − 9| = 5 
P = 3, difference = |6 − 7| = 1 
P = 4, difference = |10 − 3| = 7 
Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. */
public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] array = {3,1,2,4,3};
        int minimalDifference = solution(array);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", minimalDifference);
    }

    public static int solution(int[] array) {
        if(array.length == 0) {
            return 0;
        }

        if(array.length == 1){
            return array[0];
        }

        int arrayLength = array.length-1;
        int[] forwardSum = calculateForwardSum(array, arrayLength);
        int[] backwardSum = calculateBackwardSum(array, arrayLength);
        reverserArray(backwardSum);
        int[] differenceBetweenSums = calculateDifference(arrayLength, forwardSum, backwardSum);
        int minimalDifference = calculateMinimalDifference(arrayLength, differenceBetweenSums);

        return minimalDifference;
    }

    private static int calculateMinimalDifference(int arrayLength, int[] differenceBetweenSums) {
        int minimalDifference = Integer.MAX_VALUE;

        for(int i = 0; i < arrayLength; i++) {
            int difference = differenceBetweenSums[i];
            if(minimalDifference > difference) {
                minimalDifference = difference;
            }
        }
        return minimalDifference;
    }

    private static int[] calculateDifference(int arrayLength, int[] forwardSum, int[] backwardSum) {
        int[] differenceBetweenSums = new int[arrayLength];
         for(int i = 0; i < arrayLength; i++) {
            differenceBetweenSums[i] = Math.abs(forwardSum[i] - backwardSum[i]);
        }
        return differenceBetweenSums;
    }

    private static void reverserArray(int[] backwardSum) {
        for (int i = 0; i < backwardSum.length / 2; i++) {
            int temp = backwardSum[i];
            backwardSum[i] = backwardSum[backwardSum.length - 1 - i];
            backwardSum[backwardSum.length - 1 - i] = temp;
        }
    }

    private static int[] calculateBackwardSum(int[] array, int arrayLength) {
        int[] backwardSum = new int[arrayLength];
        backwardSum[0] = array[array.length -1];
        for(int i = 1; i < arrayLength; i++) {        
            backwardSum[i] = backwardSum[i-1] + array[arrayLength - (i+1)];
        }
        return backwardSum;
    }

    public static int[] calculateForwardSum(int[] array, int arrayLength) {
        int[] forwardSum = new int[arrayLength];
        forwardSum[0] = array[0];
        for(int i = 1; i < arrayLength; i++) {    
            forwardSum[i] = forwardSum[i-1] + array[i];
        }
        return forwardSum;
    }
}
