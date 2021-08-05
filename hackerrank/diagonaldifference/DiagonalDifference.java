package hackerrank.diagonaldifference;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a square matrix, calculate the absolute difference between the sums of
 * its diagonals. For example, the square matrix is shown below: 1 2 3 4 5 6 9 8
 * 9 The left-to-right diagonal = . The right to left diagonal = . Their
 * absolute difference is . Function description Complete the function in the
 * editor below. diagonalDifference takes the following parameter: int
 * arr[n][m]: an array of integers Return int: the absolute diagonal difference
 * Input Format The first line contains a single integer, , the number of rows
 * and columns in the square matrix . Each of the next lines describes a row, ,
 * and consists of space-separated integers . Constraints
 * 
 * Output Format Return the absolute difference between the sums of the matrix's
 * two diagonals as a single integer. Sample Input 3 11 2 4 4 5 6 10 8 -12
 * Sample Output 15 Explanation The primary diagonal is: 11 5 -12 Sum across the
 * primary diagonal: 11 + 5 - 12 = 4 The secondary diagonal is: 4 5 10 Sum
 * across the secondary diagonal: 4 + 5 + 10 = 19 Difference: |4 - 19| = 15
 * Note: |x| is the absolute value of x
 * 
 * Time Complexity: O(N*M)
 */
public class DiagonalDifference {

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> secondArray = new ArrayList<>();
        List<Integer> thirdArray = new ArrayList<>();
        List<Integer> fourthArray = new ArrayList<>();

        secondArray.add(11);
        secondArray.add(2);
        secondArray.add(4);
        arr.add(secondArray);

        thirdArray.add(4);
        thirdArray.add(5);
        thirdArray.add(6);
        arr.add(thirdArray);

        fourthArray.add(10);
        fourthArray.add(8);
        fourthArray.add(-12);
        arr.add(fourthArray);

        int absoluteDifference = diagonalDifference(arr);
        System.out.printf("%d%n", absoluteDifference);

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int size = arr.size();
        int leftToRightDiagonalPosition = 0, rightToLeftDiagonalPosition = (size - 1);
        long leftToRightDiagonalSum = 0, rightToLeftDiagonalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            List<Integer> row = arr.get(i);
            for (int j = 0; j < row.size(); j++) {
                int value = row.get(j);

                if (leftToRightDiagonalPosition == j) {
                    leftToRightDiagonalSum += value;
                }

                if (rightToLeftDiagonalPosition == j) {
                    rightToLeftDiagonalSum += value;
                }
            }
            leftToRightDiagonalPosition++;
            rightToLeftDiagonalPosition--;
        }

        long absoluteValue = Math.abs(leftToRightDiagonalSum - rightToLeftDiagonalSum);
        return Math.toIntExact(absoluteValue);
    }
}
