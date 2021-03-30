package codility.timecomplexity;

import java.util.Arrays;

public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] array = {-1, -3};
        int missingNumber = solution(array);
        System.out.printf("The answer is %s, Expected Answer is 1 %n", missingNumber);

        int[] array1 = {-1, -3, 2, 4, 5, 6, 1, 3, 0};
        missingNumber = solution(array1);
        System.out.printf("The answer is %s,  Expected answer is 7 %n", missingNumber);

        int[] array2 = {};
        missingNumber = solution(array2);
        System.out.printf("The answer is %s,  Expected answer is 1 %n", missingNumber);

        int[] array3 = {0};
        missingNumber = solution(array3);
        System.out.printf("The answer is %s,  Expected answer is 1 %n", missingNumber);

        int[] array4 = {1};
        missingNumber = solution(array4);
        System.out.printf("The answer is %s,  Expected answer is 1 %n", missingNumber); 

        int[] array5 = {7,5,6,3,4,2,1};
        missingNumber = solution(array5);
        System.out.printf("The answer is %s,  Expected answer is 8 %n", missingNumber);
    }


    public static int solution(int[] unsortedArray) {
        int[] filteredArray = Arrays.stream(unsortedArray).filter(i -> i > 0).sorted().toArray();
        int missingNumber = 1;

        for(int i=0; i < filteredArray.length; i++) {
            int currentNumber = filteredArray[i];
            missingNumber = i+1;

            if(missingNumber != currentNumber) {
                break;
            } else if(filteredArray.length == missingNumber) {
                missingNumber++;
            }
        }
        return missingNumber;
    }
}
