package codility.countingelements;

import java.util.Arrays;

/* You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

TIME COMPLEXITY = O(N + M)
*/
public class IncreaseCounters {
    public static void main(String[] args) {
        int[] array = {3,4,4,6,1,4,4};
        int[] counter = solution(5, array);
        System.out.printf("The answer is %s, Expected Answer is [3,2,2,4,2] %n", Arrays.toString(counter));
    }

    public static int[] solution(int numberOfCounters, int[] array) {
        int[] counter = new int[numberOfCounters];
        int maxValueInCounter = 0;
        int currentMinValueInCounter = 0;

        for(int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            int indexPositionOfCounter = currentElement-1;

            if(isCurrentValueLessThanNumberOfCounters(currentElement, numberOfCounters)) {

                setCounterValue(counter, currentMinValueInCounter, indexPositionOfCounter);
                maxValueInCounter = updateMaxValueInCounter(maxValueInCounter, counter[indexPositionOfCounter]);
            } else {
                // Assuming that the value can only be a maximum of N+1
                currentMinValueInCounter = maxValueInCounter;
            }
        }

        increaseAllCountersByMaxValue(currentMinValueInCounter, counter);
        return counter;
    }

    private static void setCounterValue(int[] counter, int currentMinValueInCounter, int indexPositionOfCounter) {
        if(currentMinValueInCounter <= counter[indexPositionOfCounter]) {
            counter[indexPositionOfCounter] += 1;
        } else {
            counter[indexPositionOfCounter] = (currentMinValueInCounter + 1);
        }
    }

    public static void increaseAllCountersByMaxValue(int maxValueInCounter,int[] counter) {
        for(int j = 0; j < counter.length; j++) {
            // Counter set to max value
            if(counter[j] < maxValueInCounter) {
                counter[j] = maxValueInCounter;
            }
        }
    }

    public static boolean isCurrentValueLessThanNumberOfCounters(int currentElement, int numberOfCounters){
        return currentElement <= numberOfCounters;
    }

    public static int updateMaxValueInCounter(int maxValueInCounter, int currentValueinCounter) {
        // Calculate Maximum Value in the counter
        if(maxValueInCounter < currentValueinCounter) {
            maxValueInCounter = currentValueinCounter;
        }
        return maxValueInCounter;
    }
}
