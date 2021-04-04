package codility.maximumsliceproblem;

/* A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:

double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−10,000..10,000].
 
*/
public class MaxDoubleSliceSum {
    public static void main(String[] args) {

        int[] array11 = { 3, 2, -1, 2, -2, 4, 5, -1, 2 };
        int sliceSum = solution(array11);
        System.out.printf("The MaxDoubleSlice are 12, The actual value is %s %n", sliceSum);

        int[] array8 = { 3, 6, 2, -1, 4, 5, -1, 2 };
        sliceSum = solution(array8);
        System.out.printf("The MaxDoubleSlice are 17, The actual value is %s %n", sliceSum);

        int[] array10 = { 3, -1, 2, -2, 4, 5, -1, 2 };
        sliceSum = solution(array10);
        System.out.printf("The MaxDoubleSlice are 11, The actual value is %s %n", sliceSum);

        int[] array9 = { 3, -6, 2, -1, 4, 5, -1, 2 };
        sliceSum = solution(array9);
        System.out.printf("The MaxDoubleSlice are 10, The actual value is %s %n", sliceSum);

        int[] array7 = { 3, 2, 6, -1, 4, 5, -1, 2 };
        sliceSum = solution(array7);
        System.out.printf("The MaxDoubleSlice are 17, The actual value is %s %n", sliceSum);

        int[] array5 = { 1, 1 };
        sliceSum = solution(array5);
        System.out.printf("The MaxDoubleSlice are 0, The actual value is %s %n", sliceSum);

        int[] array = {};
        sliceSum = solution(array);
        System.out.printf("The MaxDoubleSlice are 0, The actual value is %s %n", sliceSum);

        int[] array1 = { 1 };
        sliceSum = solution(array1);
        System.out.printf("The MaxDoubleSlice are 0, The actual value is %s %n", sliceSum);

        int[] array2 = { 3, 2, -6, 4, 0 };
        sliceSum = solution(array2);
        System.out.printf("The MaxDoubleSlice are 6, The actual value is %s %n", sliceSum);

        int[] array3 = { 0, 10, -5, -2, 0 };
        sliceSum = solution(array3);
        System.out.printf("The MaxDoubleSlice are 10, The actual value is %s %n", sliceSum);

    }

    public static int solution(int[] array) {
        if (array.length <= 3) {
            return 0;
        }

        if (array.length == 4) {
            return Math.max(array[1], array[2]);
        }

        int y = array[1], z = array[3], absoluteMaximum = array[2];
        int xPosition = 0, yPosition = 1, zPosition = 3;

        if (y > absoluteMaximum) {
            absoluteMaximum = y;
            y = array[2];
            yPosition = 2;
        }

        for (int i = 4; i < (array.length - 1); i++) {
            int element = array[i];
            int possibleMax = absoluteMaximum + z;
            int possibleYMax = absoluteMaximum + y;

            // 0 <= X < Y < Z < N So Z can never be in Nth Position
            if (possibleYMax > possibleMax && i != (array.length - 1)) {
                if (possibleYMax > absoluteMaximum) {
                    absoluteMaximum += y;
                    y = element;
                    yPosition = i;
                    z = element;
                    zPosition = i;
                } else if (xPosition + 1 == yPosition) {
                    xPosition = yPosition;
                    y = z;
                    yPosition = zPosition;
                    z = element;
                    zPosition = i;
                }
            } else {
                absoluteMaximum += z;
                z = element;
            }

        }

        // If Z moves to last position
        absoluteMaximum = Math.max(absoluteMaximum, (absoluteMaximum + z));

        return absoluteMaximum;
    }
}
