package codility.utility.sort;

/**
 * USE JAVA * Arrays.stream().sorted() for better performance
 * 
 * 
 * START = [ 10, 7, 8, 9, 1, 5 ] , [ 10, 7, 8, 9, 1, 5 ] --> Swap 1 with 10 , [
 * 1,7, 8, 9, 10, 5 ] --> Swap 5 with 7, [ 1, 5, 8, 9, 10, 7 ] --> Swap 7 with
 * 8, [ 1, 5, 7, 9, 10, 8 ] --> Swap 8 with 9, [ 1, 5, 7, 8, 10, 9 ] --> Swap 7
 * with 8, [ 1, 5, 7, 8, 10, 9 ] --> Swap 9 with 10, END == [ 1, 5, 7, 8, 9, 10
 * ]
 */
public class QuickSort {

    // A utility function to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * This function takes last element as pivot, places the pivot element at its
     * correct position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     */
    private static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*
     * The main function that implements QuickSort arr[] --> Array to be sorted, low
     * --> Starting index, high --> Ending index
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array
    private static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        quickSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
