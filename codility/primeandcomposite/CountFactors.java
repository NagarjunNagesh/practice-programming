package codility.primeandcomposite;

/*A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. 

TIME COMPLEXITY - O(sqrt(N))*/
public class CountFactors {
    public static void main(String[] args) {
        int numberOfFactors = solution(24);
        System.out.printf("The Expected Number of factors are 8, The actual number of factors are %s %n",
                numberOfFactors);

        numberOfFactors = solution(1);
        System.out.printf("The Expected Number of factors are 1, The actual number of factors are %s %n",
                numberOfFactors);

        numberOfFactors = solution(100);
        System.out.printf("The Expected Number of factors are 9, The actual number of factors are %s %n",
                numberOfFactors);
    }

    public static int solution(int n) {
        int candidate = 1, result = 0;

        while (candidate * candidate < n) {
            if (n % candidate == 0) {
                result += 2;
            }
            candidate++;
        }

        if (candidate * candidate == n) {
            result++;
        }

        return result;
    }

}
