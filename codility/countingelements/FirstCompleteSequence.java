package codility.countingelements;

/* A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

position value
1 2
2 1
3 4
4 5
5 5
6 3

Do Not Use Java 8 Features as the performance test fails in codility
*/
public class FirstCompleteSequence {
    private static int DEFAULT_VALUE = -1;
    public static void main(String[] args) {
        int[] array = {1,3,1,4,2,3,5,4};
        int seconds = solution(5, array);
        System.out.printf("The answer is %s, Expected Answer is 6 %n", seconds);

        int[] array1 = {1,2,3,4,5};
        seconds = solution(4, array1);
        System.out.printf("The answer is %s, Expected Answer is 3 %n", seconds);

        int[] array2 = {1,1,1,1,1};
        seconds = solution(4, array2);
        System.out.printf("The answer is %s, Expected Answer is -1 %n", seconds);

        int[] array3 = {1};
        seconds = solution(2, array3);
        System.out.printf("The answer is %s, Expected Answer is -1 %n", seconds);

        int[] array4 = {1,2,3,2,2};
        seconds = solution(4, array4);
        System.out.printf("The answer is %s, Expected Answer is -1 %n", seconds);

        int[] array6 = new int[30001];
        for(int i = 0; i < array6.length; i++) {
            array6[i] = i+1;
        }
        seconds = solution(30000, array6);
        System.out.printf("The answer is %s, Expected Answer is 29999 %n", seconds);

    }

    public static int solution(int numberOfLeaves, int[] array) {
        
        if(array.length < numberOfLeaves) {
            return DEFAULT_VALUE;
        }

        // positionOfThisIndexInArray[array[i]] == i
        Integer[] positionOfThisIndexInArray = new Integer[numberOfLeaves];
        int maximumPositionalValue = DEFAULT_VALUE;

        for(int i = 0; i < array.length; i++) {
            int currentElement = array[i];

            if(currentElement > numberOfLeaves) {
                continue;
            }

            // Only the earliest positions are stored.
            if(positionOfThisIndexInArray[currentElement-1] == null)  {
                positionOfThisIndexInArray[currentElement-1] = i;
                maximumPositionalValue = i;
            }
        }

        // Position Zero is never used so 1 to the number of elements
        boolean containsNull = false;
        for(int i=0; i< positionOfThisIndexInArray.length; i++) {
            if(positionOfThisIndexInArray[i] == null) {
                containsNull = true;
                break;
            }
        }
        
        return containsNull ? DEFAULT_VALUE : maximumPositionalValue;
    }
}
