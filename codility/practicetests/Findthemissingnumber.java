package codility.practicetests;
/*This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.*/
import java.util.Arrays;

class Solution {
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

    public static int solution(int[] array) {
        int[] filteredArray = Arrays.stream(array).filter(i -> i > 0).sorted().toArray();
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
