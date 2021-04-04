package codility.primeandcomposite;

/* An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..1,000,000,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. 

TIME COMPLEXITY -  O(sqrt(N))*/
public class MinimalPerimeterRectangle {
    public static void main(String[] args) {
        int numberOfFactors = solution(30);
        System.out.printf("The Expected Number of factors are 22, The actual number of factors are %s %n",
                numberOfFactors);

        numberOfFactors = solution(25);
        System.out.printf("The Expected Number of factors are 20, The actual number of factors are %s %n",
                numberOfFactors);

        numberOfFactors = solution(1);
        System.out.printf("The Expected Number of factors are 4, The actual number of factors are %s %n",
                numberOfFactors);

        numberOfFactors = solution(100);
        System.out.printf("The Expected Number of factors are 40, The actual number of factors are %s %n",
                numberOfFactors);
    }

    public static int solution(int n) {
        int candidate = 1, absoluteMinimumPerimeter = Integer.MAX_VALUE;

        while (candidate * candidate < n) {
            if (n % candidate == 0) {
                int tempPerimeter = 2 * ((n / candidate) + candidate);
                absoluteMinimumPerimeter = Math.min(absoluteMinimumPerimeter, tempPerimeter);
            }
            candidate++;
        }

        if (candidate * candidate == n) {
            int tempPerimeter = 2 * (candidate + candidate);
            absoluteMinimumPerimeter = Math.min(absoluteMinimumPerimeter, tempPerimeter);
        }

        return absoluteMinimumPerimeter;
    }
}
