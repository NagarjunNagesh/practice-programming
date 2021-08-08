package hackerrank.newyearchaos;

import java.util.Arrays;
import java.util.List;

/**
 * It is New Year's Day and people are in line for the Wonderland rollercoaster
 * ride. Each person wears a sticker indicating their initial position in the
 * queue from to . Any person can bribe the person directly in front of them to
 * swap positions, but they still wear their original sticker. One person can
 * bribe at most two others. Determine the minimum number of bribes that took
 * place to get to a given queue order. Print the number of bribes, or, if
 * anyone has bribed more than two people, print Too chaotic. Example
 * 
 * If person bribes person , the queue will look like this: . Only bribe is
 * required. Print 1.
 * 
 * Person had to bribe people to get to the current position. Print Too chaotic.
 * Function Description Complete the function minimumBribes in the editor below.
 * minimumBribes has the following parameter(s): int q[n]: the positions of the
 * people after all bribes Returns No value is returned. Print the minimum
 * number of bribes necessary or Too chaotic if someone has bribed more than
 * people. Input Format The first line contains an integer , the number of test
 * cases. Each of the next pairs of lines are as follows: - The first line
 * contains an integer , the number of people in the queue - The second line has
 * space-separated integers describing the final state of the queue. Constraints
 * 
 * 
 * Subtasks For score For score Sample Input STDIN Function ----- -------- 2 t =
 * 2 5 n = 5 2 1 5 3 4 q = [2, 1, 5, 3, 4] 5 n = 5 2 5 1 3 4 q = [2, 5, 1, 3, 4]
 * Sample Output 3 Too chaotic Explanation Test Case 1 The initial state:
 * pic1(1).png After person moves one position ahead by bribing person :
 * pic2.png Now person moves another position ahead by bribing person : pic3.png
 * And person moves one position ahead by bribing person : pic5.png So the final
 * state is after three bribing operations. Test Case 2 No person can bribe more
 * than two people, yet it appears person has done so. It is not possible to
 * achieve the input state.
 * 
 * WRONG ANSWER
 */
public class NewYearChaos {

    private static final int MAX_SWAP = 2;

    public static void main(String[] args) {
        Integer[] q = new Integer[] { 1, 2, 3, 5, 4, 6, 7, 8 };
        minimumBribes(Arrays.asList(q)); // Expected 1

        Integer[] q1 = new Integer[] { 4, 1, 2, 3 };
        minimumBribes(Arrays.asList(q1)); // Expected Too Chaotic

        Integer[] q2 = new Integer[] { 2, 1, 5, 3, 4 };
        minimumBribes(Arrays.asList(q2)); // Expected 3
    }

    public static void minimumBribes(List<Integer> q) {
        int swapcount = 0;
        int swappedNumber = 0;
        int totalSwap = 0;

        for (Integer number : q) {
            if (swappedNumber == 0) {
                swappedNumber = number;
            } else if (swappedNumber > number) {
                swapcount++;

                if (swapcount > MAX_SWAP) {
                    System.out.printf("Too chaotic%n");
                    break;
                }
            } else if (swappedNumber < number) {
                totalSwap += swapcount;
                swappedNumber = number;
                swapcount = 0;
            }
        }

        if (totalSwap != 0) {
            totalSwap += swapcount;
            System.out.printf("%d%n", totalSwap);
        }
    }
}
