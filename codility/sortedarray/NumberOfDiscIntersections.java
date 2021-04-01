package codility.sortedarray;

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
int[] array = { 1, 5, 2, 1, 4, 0 };
        int answer = solution(array);
        System.out.printf("The Expected answer is 11, And the current answer is %s %n", answer);

        int[] array1 = { 1, 1, 1 };
        answer = solution(array1);
        System.out.printf("The Expected answer is 3, And the current answer is %s %n", answer);

        int[] array2 = { 1, 2147483647, 0 };
        answer = solution(array2);
        System.out.printf("The Expected answer is 2, And the current answer is %s %n", answer);

*/
public class NumberOfDiscIntersections {
    public static void main(String[] args) {

        int[] array3 = { 1, 10, 100, 1 };
        int answer = solution(array3);
        System.out.printf("The Expected answer is 5, And the current answer is %s %n", answer);

    }

    public static int solution(int[] circles) {
        // Total Interactions
        int ti = 0;
        int circleLength = circles.length;

        if (circles.length == 0) {
            return ti;
        }

        // Left Most corner is 0 (Other Values are irrevalent) (As N is a non Negative
        // Integer)
        // Calculates number of intersections at each location
        int[] csp = new int[circleLength];
        // Right most Corner is (a.length) (Other Values are Irrelevant) (As N is a non
        // Negative Integer)
        // Calculates number of intersections at each location
        int[] cep = new int[circleLength];
        // Final Position of Array (Ending point array position)
        int epp = (circleLength - 1);
        for (int i = 0; i < circleLength; i++) {
            int element = circles[i];
            // Starting Point (Element < 0, then 0, Else SP (i - element))
            int sp = element < 0 ? 0 : i - element;
            // SP < 0 choose 0 else choose sp
            sp = sp < 0 ? 0 : sp;
            // Ending Point (element > circleLength) ? circleLength else choose (i +
            // element)
            int ep = element > epp ? epp : (i + element);
            // Ending point > circle length choose circle length else ep
            ep = ep > epp ? epp : ep;

            // Increase the relevant intersecions
            csp[sp]++;
            cep[ep]++;
        }

        // Active Circle Counter
        int acc = 0;
        // Calculate the number of intersections
        for (int i = 0; i < circleLength; i++) {
            // Number of Starting Point intersections
            int spi = csp[i];
            // Number of Ending point intersections
            int epi = cep[i];

            if (ti > 10000000) {
                return -1;
            }

            // Calculate Starting Point together as a single interaction (IF SP = 0 ensure
            // it adds 0 and not -1)
            if (spi > 0) {
                // If 5 circles then (n-1) * (n/2) interactions for each circle (1+2+3+4)
                // interactions
                ti += (int) ((spi - 1) * ((float) spi / 2));
                // Also Register Any Active Circle as interaction
                ti += spi * acc;
            }
            // Calculate Active Circle Counter (Add Strating Point to Active Circle Minus
            // Ending Point Circle)
            acc += (spi - epi);

        }

        return ti;
    }

}
