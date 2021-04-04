package codility.timecomplexity;

/**
 * A small frog wants to get to the other side of the road. The frog is
 * currently located at position X and wants to get to a position greater than
 * or equal to Y. The small frog always jumps a fixed distance, D.
 * 
 * Count the minimal number of jumps that the small frog must perform to reach
 * its target.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int X, int Y, int D); }
 * 
 * that, given three integers X, Y and D, returns the minimal number of jumps
 * from position X to a position equal to or greater than Y.
 * 
 * For example, given:
 * 
 * X = 10 Y = 85 D = 30 the function should return 3, because the frog will be
 * positioned as follows:
 * 
 * after the first jump, at position 10 + 30 = 40 after the second jump, at
 * position 10 + 30 + 30 = 70 after the third jump, at position 10 + 30 + 30 +
 * 30 = 100 Write an efficient algorithm for the following assumptions:
 * 
 * X, Y and D are integers within the range [1..1,000,000,000]; X ≤ Y.
 */
public class JumpFrog {

    public static void main(String[] args) {
        int numberOfJumps = solution(1, 5, 1);
        System.out.printf("The answer is %s, Expected Answer is 4 %n", numberOfJumps);
        numberOfJumps = solution(10, 85, 30);
        System.out.printf("The answer is %s, Expected Answer is 3 %n", numberOfJumps);
        numberOfJumps = solution(10, 10, 30);
        System.out.printf("The answer is %s, Expected Answer is 0 %n", numberOfJumps);
    }

    public static boolean isNotDivisible(int totalDistance, int jumpDistance) {
        return totalDistance % jumpDistance != 0;
    }

    public static int solution(int startPosition, int endPosition, int jumpDistance) {
        int totalDistance = (endPosition - startPosition);
        int requiredJumps = totalDistance / jumpDistance;

        if (isNotDivisible(totalDistance, jumpDistance)) {
            requiredJumps++;
        }

        return requiredJumps;
    }

}
