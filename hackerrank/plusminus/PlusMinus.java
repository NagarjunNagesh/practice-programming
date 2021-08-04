package hackerrank.plusminus;

/**
 * Given an array of integers, calculate the ratios of its elements that are
 * positive, negative, and zero. Print the decimal value of each fraction on a
 * new line with places after the decimal.
 * 
 * Note: This challenge introduces precision problems. The test cases are scaled
 * to six decimal places, though answers with absolute error of up to are
 * acceptable. Example
 * 
 * There are elements, two positive, two negative and one zero. Their ratios are
 * , and . Results are printed as: 0.400000 0.400000 0.200000 Function
 * Description Complete the plusMinus function in the editor below. plusMinus
 * has the following parameter(s): int arr[n]: an array of integers Print Print
 * the ratios of positive, negative and zero values in the array. Each value
 * should be printed on a separate line with digits after the decimal. The
 * function should not return a value. Input Format The first line contains an
 * integer, , the size of the array. The second line contains space-separated
 * integers that describe . Constraints
 * 
 * 
 * Output Format Print the following lines, each to decimals: proportion of
 * positive values proportion of negative values proportion of zeros Sample
 * Input STDIN Function ----- -------- 6 arr[] size n = 6 -4 3 -9 0 4 1 arr =
 * [-4, 3, -9, 0, 4, 1] Sample Output 0.500000 0.333333 0.166667
 */
public class PlusMinus {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, -1, -1 };
        plusMinus(arr);

        int[] arr2 = { 0, 0, 0, 0, 0 };
        plusMinus(arr2);

        int[] arr3 = { 1, 2, 3, 4, 100 };
        plusMinus(arr3);

        int[] arr4 = { -1, -2, -3, -4, -100 };
        plusMinus(arr4);
    }

    private static void plusMinus(int[] arr) {
        int positive = 0, negative = 0, zeros = 0;
        float totalLength = arr.length;

        for (int i = 0; i < totalLength; i++) {
            int number = arr[i];

            if (number > 0) {
                positive++;
            } else if (number < 0) {
                negative++;
            } else {
                zeros++;
            }
        }

        System.out.printf("%.6f \n", (positive / totalLength));
        System.out.printf("%.6f \n", (negative / totalLength));
        System.out.printf("%.6f \n", (zeros / totalLength));
    }

}
