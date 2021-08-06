package hackerrank.countingsortone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Comparison Sorting Quicksort usually has a running time of , but is there an
 * algorithm that can sort even faster? In general, this is not possible. Most
 * sorting algorithms are comparison sorts, i.e. they sort a list just by
 * comparing the elements to one another. A comparison sort algorithm cannot
 * beat (worst-case) running time, since represents the minimum number of
 * comparisons needed to know where to place each element. For more details, you
 * can see these notes (PDF). Alternative Sorting Another sorting method, the
 * counting sort, does not require comparison. Instead, you create an integer
 * array whose index range covers the entire range of values in your array to
 * sort. Each time a value occurs in the original array, you increment the
 * counter at that index. At the end, run through your counting array, printing
 * the value of each non-zero valued index that number of times. Example
 * 
 * All of the values are in the range , so create an array of zeros, . The
 * results of each iteration follow: i arr[i] result 0 1 [0, 1, 0, 0] 1 1 [0, 2,
 * 0, 0] 2 3 [0, 2, 0, 1] 3 2 [0, 2, 1, 1] 4 1 [0, 3, 1, 1] The frequency array
 * is . These values can be used to create the sorted array as well: . Note For
 * this exercise, always return a frequency array with 100 elements. The example
 * above shows only the first 4 elements, the remainder being zeros. Challenge
 * Given a list of integers, count and return the number of times each value
 * appears as an array of integers. Function Description Complete the
 * countingSort function in the editor below. countingSort has the following
 * parameter(s): arr[n]: an array of integers Returns int[100]: a frequency
 * array Input Format The first line contains an integer , the number of items
 * in . Each of the next lines contains an integer where . Constraints
 * 
 * 
 * Sample Input 100 63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99
 * 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27
 * 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20
 * 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33
 * Sample Output 0 2 0 2 0 0 1 0 1 2 1 0 1 1 0 0 2 0 1 0 1 2 1 1 1 3 0 2 0 0 2 0
 * 3 3 1 0 0 0 0 2 2 1 1 1 2 0 2 0 1 0 1 0 0 1 0 0 2 1 0 1 1 1 0 1 0 1 0 2 1 3 2
 * 0 0 2 1 2 1 0 2 2 1 2 1 2 1 1 2 2 0 3 2 1 1 0 1 1 1 0 2 2 Explanation Each of
 * the resulting values represents the number of times appeared in
 */
public class CountingSortOne {

    public static void main(String[] args) {
        List<Integer> arr = generateArrayInput();
        List<Integer> countingSort = countingSort(arr);
        List<Integer> expectedCountingSort = calculateExpectedCountingSort();
        boolean equals = countingSort.equals(expectedCountingSort);
        System.out.printf("Counting Sort Expected %b%n", equals);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return new ArrayList<>();
        }

        int[] countingSort = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            int value = arr.get(i);
            countingSort[value]++;
        }

        return Arrays.stream(countingSort).boxed().collect(Collectors.toList());
    }

    private static List<Integer> calculateExpectedCountingSort() {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(2);
        arr.add(0);
        arr.add(2);
        arr.add(0);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(2);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(3);
        arr.add(0);
        arr.add(2);
        arr.add(0);
        arr.add(0);
        arr.add(2);
        arr.add(0);
        arr.add(3);
        arr.add(3);
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(0);
        arr.add(2);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(2);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(0);
        arr.add(0);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(0);
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(0);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(2);
        arr.add(2);
        return arr;
    }

    private static List<Integer> generateArrayInput() {
        List<Integer> arr = new ArrayList<>();
        arr.add(63);
        arr.add(25);
        arr.add(73);
        arr.add(1);
        arr.add(98);
        arr.add(73);
        arr.add(56);
        arr.add(84);
        arr.add(86);
        arr.add(57);
        arr.add(16);
        arr.add(83);
        arr.add(8);
        arr.add(25);
        arr.add(81);
        arr.add(56);
        arr.add(9);
        arr.add(53);
        arr.add(98);
        arr.add(67);
        arr.add(99);
        arr.add(12);
        arr.add(83);
        arr.add(89);
        arr.add(80);
        arr.add(91);
        arr.add(39);
        arr.add(86);
        arr.add(76);
        arr.add(85);
        arr.add(74);
        arr.add(39);
        arr.add(25);
        arr.add(90);
        arr.add(59);
        arr.add(10);
        arr.add(94);
        arr.add(32);
        arr.add(44);
        arr.add(3);
        arr.add(89);
        arr.add(30);
        arr.add(27);
        arr.add(79);
        arr.add(46);
        arr.add(96);
        arr.add(27);
        arr.add(32);
        arr.add(18);
        arr.add(21);
        arr.add(92);
        arr.add(69);
        arr.add(81);
        arr.add(40);
        arr.add(40);
        arr.add(34);
        arr.add(68);
        arr.add(78);
        arr.add(24);
        arr.add(87);
        arr.add(42);
        arr.add(69);
        arr.add(23);
        arr.add(41);
        arr.add(78);
        arr.add(22);
        arr.add(6);
        arr.add(90);
        arr.add(99);
        arr.add(89);
        arr.add(50);
        arr.add(30);
        arr.add(20);
        arr.add(1);
        arr.add(43);
        arr.add(3);
        arr.add(70);
        arr.add(95);
        arr.add(33);
        arr.add(46);
        arr.add(44);
        arr.add(9);
        arr.add(69);
        arr.add(48);
        arr.add(33);
        arr.add(60);
        arr.add(65);
        arr.add(16);
        arr.add(82);
        arr.add(67);
        arr.add(61);
        arr.add(32);
        arr.add(21);
        arr.add(79);
        arr.add(75);
        arr.add(75);
        arr.add(13);
        arr.add(87);
        arr.add(70);
        arr.add(33);
        return arr;
    }

}
