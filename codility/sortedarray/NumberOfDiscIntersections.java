package codility.sortedarray;

import java.util.HashSet;
import java.util.Set;

/* We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].


EXAMPLE: 

IF 
    A[5] = 0
THEN CREATE ARRAY
    [5]

IF 
    A[0] = 1
THEN CREATE ARRAY
    [0]

IF
    A[1] = 5
THEN CREATE ARRAY
    [-4,-3,-2,-1,0,1,2,3,4]

ALGORITHM
    A[P] = K
IF( K != 0)
    THEN CREATE AN ARRAY WITH 
    LOWER LIMIT L = (P - (K-1))
    UPPER LIMIT U = (P + (K - 1))
    [L,....,0,...., U]
ELSE
    [K]

ARRAYS TO CREATE is N ARRAYS FOR EACH VALUE OF A

And then check if any other array created contains values from other arrays.
*/
public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 1, 4, 0 };
        int answer = solution(array);
        System.out.printf("The Expected answer is 11, And the current answer is %s %n", answer);

        int[] array1 = { 1, 1, 1 };
        answer = solution(array1);
        System.out.printf("The Expected answer is 3, And the current answer is %s %n", answer);
    }

    public static int solution(int[] circles) {
        int totalIntersections = 0;
        int circleLength = circles.length;
        Set<Integer> circleIntersectionReference = new HashSet<>();

        for (int i = 0; i < circleLength; i++) {
            int element = circles[i];

            if (element == 0 || element == 1) {
                totalIntersections = checkIfIntersected(totalIntersections, circleIntersectionReference, i);
            } else {
                int elementMinusOne = (element - 1);
                int intersectionFarthestToTheLeft = i - elementMinusOne;
                int intersectionFarthestToTheRight = i + elementMinusOne;

                for (int j = intersectionFarthestToTheLeft; j <= intersectionFarthestToTheRight; j++) {
                    totalIntersections = checkIfIntersected(totalIntersections, circleIntersectionReference, j);
                }
            }
        }

        return (totalIntersections > 10000000) ? -1 : totalIntersections;
    }

    private static int checkIfIntersected(int totalIntersections, Set<Integer> circleIntersectionReference, int i) {
        if (circleIntersectionReference.contains(i)) {
            totalIntersections++;
        } else {
            circleIntersectionReference.add(i);
        }
        return totalIntersections;
    }
}
