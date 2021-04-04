package codility.stacksandqueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.



Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
 

TIME COMPLEXITY = O(N**2)*/
public class ManhattanBlocks {
    public static void main(String[] args) {
        int[] heights = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
        int minimumBlocksRequired = DequeSolution(heights);
        System.out.printf("The Expected answers is 7, The actual answer is %s %n", minimumBlocksRequired);

        int[] heights1 = { 8 };
        minimumBlocksRequired = DequeSolution(heights1);
        System.out.printf("The Expected answers is 1, The actual answer is %s %n", minimumBlocksRequired);

        int[] heights2 = {};
        minimumBlocksRequired = DequeSolution(heights2);
        System.out.printf("The Expected answers is 0, The actual answer is %s %n", minimumBlocksRequired);

    }

    public static int DequeSolution(int[] heights) {
        int minimumBlocksRequired = 0;
        Deque<Integer> availableBlocks = new ArrayDeque<>();

        if (heights.length == 0) {
            return minimumBlocksRequired;
        }

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            while (!availableBlocks.isEmpty() && availableBlocks.peekLast() > height) {
                availableBlocks.removeLast();
                minimumBlocksRequired++;
            }

            if (availableBlocks.isEmpty()
                    || (availableBlocks.peekLast() != height && !availableBlocks.contains(height))) {
                availableBlocks.addLast(height);
            }
        }

        // Finally add all the remaining blocks
        minimumBlocksRequired += availableBlocks.size();

        return minimumBlocksRequired;
    }

    public static int ListSolution(int[] heights) {
        int minimumBlocksRequired = 0;
        List<Integer> availableBlocks = new ArrayList<>();
        if (heights.length == 0) {
            return minimumBlocksRequired;
        }

        availableBlocks.add(heights[0]);
        for (int i = 1; i < heights.length; i++) {
            int height = heights[i];
            int abs = availableBlocks.size() - 1;

            int referenceBlocks = availableBlocks.get(abs);

            // Is List does not contain then add
            if (height != referenceBlocks && !availableBlocks.contains(height)) {
                availableBlocks.add(height);
            }

            Iterator<Integer> iterator = availableBlocks.iterator();
            while (iterator.hasNext()) {
                Integer availableBlock = iterator.next(); // must be called before you can call i.remove()
                if (height < availableBlock) {
                    // Do something
                    iterator.remove();
                    minimumBlocksRequired++;
                }
            }

        }

        // Finally add all the remaining blocks
        minimumBlocksRequired += availableBlocks.size();

        return minimumBlocksRequired;
    }

}
