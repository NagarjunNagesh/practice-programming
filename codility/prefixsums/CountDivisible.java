package codility.prefixsums;

/* Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

TIME COMPLEXITY - O(1)*/
public class CountDivisible {
    public static void main(String[] args) {
        int numerOfCarsPassing = solution(6, 11, 2);
        System.out.printf("The Expected answer is 3, The actual value is %s %n", numerOfCarsPassing);

        numerOfCarsPassing = solution(0, 0, 2);
        System.out.printf("The Expected answer is 1, The actual value is %s %n", numerOfCarsPassing);

        numerOfCarsPassing = solution(0, 10, 2);
        System.out.printf("The Expected answer is 6, The actual value is %s %n", numerOfCarsPassing);

        numerOfCarsPassing = solution(0, 10, 12);
        System.out.printf("The Expected answer is 1, The actual value is %s %n", numerOfCarsPassing);

        numerOfCarsPassing = solution(10, 10, 10);
        System.out.printf("The Expected answer is 1, The actual value is %s %n", numerOfCarsPassing);

        numerOfCarsPassing = solution(0, 7, 3);
        System.out.printf("The Expected answer is 3, The actual value is %s %n", numerOfCarsPassing);
    }

    public static int solution(int start, int end, int divide) {
        int numberOfDivisible = 0;

        if (start % divide == 0) {
            numberOfDivisible++;
        }

        if (start != end) {
            numberOfDivisible += (end / divide) - (start / divide);
        }
        return numberOfDivisible;

    }

}
