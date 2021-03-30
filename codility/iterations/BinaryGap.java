package codility.iterations;

/*A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.*/

public class BinaryGap {
    private static char ONE = '1';

    public static void main(String[] args) {
        int longestZerosSurroundedByOne = solution(328);
        System.out.printf("Longest Zeros is %s, Binary Representation is 101001000 and the answer is 2  %n", longestZerosSurroundedByOne);
        longestZerosSurroundedByOne = solution(1162);
        System.out.printf("Longest Zeros is %s, Binary Representation is 10010001010 and the answer is 3  %n", longestZerosSurroundedByOne);
        longestZerosSurroundedByOne = solution(51712);
        System.out.printf("Longest Zeros is %s, Binary Representation is 110010100000000 and the answer is 2  %n", longestZerosSurroundedByOne);
        longestZerosSurroundedByOne = solution(66561);
        System.out.printf("Longest Zeros is %s, Binary Representation is 10000010000000001 and the answer is 9  %n", longestZerosSurroundedByOne);
        longestZerosSurroundedByOne = solution(6291457);
        System.out.printf("Longest Zeros is %s, Binary Representation is 11000000000000000000001 and the answer is 20  %n", longestZerosSurroundedByOne);
        longestZerosSurroundedByOne = solution(805306373);
        System.out.printf("Longest Zeros is %s, Binary Representation is 110000000000000000000000000101 and the answer is 25  %n", longestZerosSurroundedByOne);
        longestZerosSurroundedByOne = solution(1610612737);
        System.out.printf("Longest Zeros is %s, Binary Representation is 1100000000000000000000000000001 and the answer is 28  %n", longestZerosSurroundedByOne);
    }

    public static int solution(int number) {
        String binaryRepresentation = Integer.toBinaryString(number);
        int longestZerosSurroundedByOne = 0;
        boolean startCalculatingZeros = false;
        int currentNumberOfZeros = 0;

        for (char currentCharacter : binaryRepresentation.toCharArray()) {
            if(currentCharacter == ONE) {
                startCalculatingZeros = true;

                if(currentNumberOfZeros > longestZerosSurroundedByOne) {
                    longestZerosSurroundedByOne = currentNumberOfZeros;
                }
                currentNumberOfZeros = 0;
            } else if(startCalculatingZeros) {
                currentNumberOfZeros++;
            }
        }

        return longestZerosSurroundedByOne;
    }
}
