package codility.prefixsums;

import java.util.Arrays;

/* A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P, Q is an integer within the range [0..N − 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
 
TIME COMPLEXITY - O(N + M)*/
public class GenomicRangeQuery {
    private static final int A_INT = 0;
    private static final int C_INT = 1;
    private static final int G_INT = 2;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final char A = 'A';
    private static final char C = 'C';
    private static final char G = 'G';

    public static void main(String[] args) {
        int[] sp = { 2, 5, 0 };
        int[] ep = { 4, 5, 6 };
        int[] answer = solution("CAGCCTA", sp, ep);
        System.out.printf("The Expected answer is [2,4,1], The actual answer is %s %n", Arrays.toString(answer));

        int[] sp1 = { 0 };
        int[] ep1 = { 0 };
        int[] answer1 = solution("C", sp1, ep1);
        System.out.printf("The Expected answer is [2], The actual answer is %s %n", Arrays.toString(answer1));

        int[] sp2 = { 2, 5, 0 };
        int[] ep2 = { 4, 5, 6 };
        int[] answer2 = solution("TTTTTTT", sp2, ep2);
        System.out.printf("The Expected answer is [4,4,4], The actual answer is %s %n", Arrays.toString(answer2));

        int[] sp3 = { 0, 0, 1 };
        int[] ep3 = { 0, 1, 1 };
        int[] answer3 = solution("TC", sp3, ep3);
        System.out.printf("The Expected answer is [4,2,2], The actual answer is %s %n", Arrays.toString(answer3));
    }

    public static int[] solution(String string, int[] firstPosition, int[] secondPosition) {
        int[] minimalImpactFactor = new int[firstPosition.length];
        // used jagged array to hold the prefix sums of each A, C and G genoms
        // we don't need to get prefix sums of T, you will see why.
        int[][] genomes = new int[3][string.length() + 1];

        for (int i = 0; i < string.length(); i++) {
            char gene = string.charAt(i);
            int a = 0, c = 0, g = 0;

            switch (gene) {
            case A:
                a = 1;
                break;
            case C:
                c = 1;
                break;
            case G:
                g = 1;
                break;
            default:
                break;
            }

            // Prefix Sums to calculate if genomes are present in the range.
            // 0 == A
            genomes[A_INT][i + 1] = genomes[A_INT][i] + a;
            // 1 == C
            genomes[C_INT][i + 1] = genomes[C_INT][i] + c;
            // 2 == G
            genomes[G_INT][i + 1] = genomes[G_INT][i] + g;
        }

        for (int i = 0; i < firstPosition.length; i++) {
            int startPosition = firstPosition[i];
            // Simply to facilitate easy comparision from start [0] to end [0]
            int endPosition = secondPosition[i] + 1;

            if (genomes[A_INT][endPosition] - genomes[A_INT][startPosition] > 0) {
                minimalImpactFactor[i] = ONE;
            } else if (genomes[C_INT][endPosition] - genomes[C_INT][startPosition] > 0) {
                minimalImpactFactor[i] = TWO;
            } else if (genomes[G_INT][endPosition] - genomes[G_INT][startPosition] > 0) {
                minimalImpactFactor[i] = THREE;
            } else {
                minimalImpactFactor[i] = FOUR;
            }

        }

        return minimalImpactFactor;
    }

}
