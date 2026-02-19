/**
 * ═══════════════════════════════════════════════════════════════════════════
 * SORTING ALGORITHMS - DETAILED STEP-BY-STEP TRACES
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * This file shows EXACTLY what happens at each step when you trace through
 * both Merge Sort and Quick Sort manually.
 */

import java.util.Arrays;

public class SortingTraces {

    /**
     * MERGE SORT - MANUAL TRACE
     * 
     * Let's sort: [38, 27, 43, 3]
     * 
     * Call Tree:
     * mergeSort([38,27,43,3], 0, 3)
     *     ├─ mergeSort([38,27], 0, 1)
     *     │   ├─ mergeSort([38], 0, 0)  → returns (single element)
     *     │   ├─ mergeSort([27], 1, 1)  → returns (single element)
     *     │   └─ merge([38], [27]) → [27, 38]
     *     ├─ mergeSort([43,3], 2, 3)
     *     │   ├─ mergeSort([43], 2, 2)  → returns (single element)
     *     │   ├─ mergeSort([3], 3, 3)   → returns (single element)
     *     │   └─ merge([43], [3]) → [3, 43]
     *     └─ merge([27,38], [3,43]) → [3, 27, 38, 43]
     * 
     * KEY INSIGHT: Recursion breaks down to single elements, then builds up!
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        
        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    /**
     * QUICK SORT - MANUAL TRACE
     * 
     * Let's sort: [10, 7, 8, 9, 1, 5]
     * 
     * Call Tree:
     * quickSort([10,7,8,9,1,5], 0, 5)
     *     partition() → Choose pivot 5
     *     Rearrange to: [1, 5, 10, 7, 8, 9]
     *     pivotIndex = 1
     *     ├─ quickSort([1], 0, 0)  → already sorted
     *     └─ quickSort([10,7,8,9], 2, 5)
     *         partition() → Choose pivot 9
     *         Rearrange to: [1, 5, 7, 8, 9, 10]
     *         pivotIndex = 4
     *         ├─ quickSort([7,8], 2, 3)  → continues...
     *         └─ quickSort([], 5, 5)     → empty
     * 
     * KEY INSIGHT: Partitions around pivot, then recurses on unsorted parts!
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }

    // ═══════════════════════════════════════════════════════════════════════

    /**
     * DETAILED TRACE: Merge Sort Step-by-Step
     */
    public static void traceMergeSort() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║         MERGE SORT - STEP BY STEP TRACE                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Input: " + Arrays.toString(arr) + "\n");

        System.out.println("STEP 1: DIVIDE (Recursively split in half)");
        System.out.println("─────────────────────────────────────────");
        System.out.println("mergeSort([38,27,43,3,9,82,10], 0, 6)");
        System.out.println("  mid = 3");
        System.out.println("  ├─ mergeSort([38,27,43,3], 0, 3)");
        System.out.println("  │   mid = 1");
        System.out.println("  │   ├─ mergeSort([38,27], 0, 1)");
        System.out.println("  │   │   mid = 0");
        System.out.println("  │   │   ├─ mergeSort([38], 0, 0) → base case");
        System.out.println("  │   │   ├─ mergeSort([27], 1, 1) → base case");
        System.out.println("  │   │   └─ [Now have two sorted: [38], [27]]");
        System.out.println("  │   │");
        System.out.println("  │   ├─ mergeSort([43,3], 2, 3)");
        System.out.println("  │   │   Similar process → [3], [43]");
        System.out.println("  │   │");
        System.out.println("  │   └─ [Now have two sorted: [38,27], [43,3]]");
        System.out.println("  │");
        System.out.println("  └─ mergeSort([9,82,10], 4, 6)");
        System.out.println("      Similar process...\n");

        System.out.println("STEP 2: MERGE (Combine while maintaining order)");
        System.out.println("──────────────────────────────────────────────");
        System.out.println("At each level, smaller arrays are merged:\n");

        System.out.println("Level 1 merges (singles):");
        System.out.println("  Merge [38], [27] → [27, 38]");
        System.out.println("  Merge [43], [3]  → [3, 43]");
        System.out.println("  Merge [9], [82]  → [9, 82]");
        System.out.println("  Keep [10] as is  → [10]");

        System.out.println("\nLevel 2 merges (two elements pairs):");
        System.out.println("  Merge [27,38], [3,43]  → [3, 27, 38, 43]");
        System.out.println("  Merge [9,82], [10]     → [9, 10, 82]");

        System.out.println("\nLevel 3 merge (final):");
        System.out.println("  Merge [3,27,38,43], [9,10,82] → [3, 9, 10, 27, 38, 43, 82]");

        System.out.println("\nFinal: [3, 9, 10, 27, 38, 43, 82] ✓\n");

        // Actually run it
        int[] test = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(test, 0, test.length - 1);
        System.out.println("Actual output: " + Arrays.toString(test) + " ✓\n");
    }

    /**
     * DETAILED TRACE: Quick Sort Step-by-Step
     */
    public static void traceQuickSort() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║         QUICK SORT - STEP BY STEP TRACE                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Input: " + Arrays.toString(arr) + "\n");

        System.out.println("STEP 1: PARTITION (Choose pivot = 5, rearrange)");
        System.out.println("───────────────────────────────────────────────");
        System.out.println("Array: [10, 7, 8, 9, 1, 5]");
        System.out.println("Pivot: 5 (last element)\n");

        System.out.println("Comparison process:");
        System.out.println("  10 > 5? Yes → stays on right");
        System.out.println("  7  > 5? Yes → stays on right");
        System.out.println("  8  > 5? Yes → stays on right");
        System.out.println("  9  > 5? Yes → stays on right");
        System.out.println("  1  > 5? No  → moves to left");
        System.out.println("  5 is pivot → goes to middle position\n");

        System.out.println("After partition: [1, 5, 7, 8, 9, 10]");
        System.out.println("Pivot 5 is now in correct position!\n");

        System.out.println("STEP 2: RECURSIVELY SORT");
        System.out.println("───────────────────────");
        System.out.println("Left part: [1] (only 1 element, already sorted)");
        System.out.println("Right part: [7, 8, 9, 10]");
        System.out.println("  ├─ Partition around 10");
        System.out.println("  │  All elements < 10, so: [7, 8, 9, 10]");
        System.out.println("  │  Left: [7, 8, 9]");
        System.out.println("  │");
        System.out.println("  └─ Continue recursing on smaller parts...\n");

        System.out.println("Final: [1, 5, 7, 8, 9, 10] ✓\n");

        // Actually run it
        int[] test = {10, 7, 8, 9, 1, 5};
        quickSort(test, 0, test.length - 1);
        System.out.println("Actual output: " + Arrays.toString(test) + " ✓\n");
    }

    /**
     * PARTITION SIMULATION: Show exactly how partition works
     */
    public static void partitionSimulation() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║     HOW PARTITION WORKS - DETAILED SIMULATION                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        int[] arr = {6, 2, 8, 4, 10, 3, 7};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Pivot: " + arr[arr.length - 1] + " (last element)\n");

        System.out.println("Using TWO POINTER TECHNIQUE:\n");
        System.out.println("Position [0] [1] [2] [3] [4] [5] [6]");
        System.out.println("Value:    [6] [2] [8] [4] [10][3] [7]");
        System.out.println("i pointer→                            (initially -1)");
        System.out.println("j pointer→                            (scans from 0)\n");

        System.out.println("Process:");
        System.out.println("  j=0: arr[0]=6 < 7? YES → i++ (i=0), swap arr[0] & arr[0]");
        System.out.println("  Array: [6, 2, 8, 4, 10, 3, 7]\n");

        System.out.println("  j=1: arr[1]=2 < 7? YES → i++ (i=1), swap arr[1] & arr[1]");
        System.out.println("  Array: [6, 2, 8, 4, 10, 3, 7]\n");

        System.out.println("  j=2: arr[2]=8 < 7? NO → skip");
        System.out.println("  Array: [6, 2, 8, 4, 10, 3, 7]\n");

        System.out.println("  j=3: arr[3]=4 < 7? YES → i++ (i=2), swap arr[2] & arr[3]");
        System.out.println("  Array: [6, 2, 4, 8, 10, 3, 7]\n");

        System.out.println("  j=4: arr[4]=10 < 7? NO → skip");
        System.out.println("  Array: [6, 2, 4, 8, 10, 3, 7]\n");

        System.out.println("  j=5: arr[5]=3 < 7? YES → i++ (i=3), swap arr[3] & arr[5]");
        System.out.println("  Array: [6, 2, 4, 3, 10, 8, 7]\n");

        System.out.println("Finally, place pivot in correct position:");
        System.out.println("  swap arr[i+1] & arr[last] = swap arr[4] & arr[6]");
        System.out.println("  Array: [6, 2, 4, 3, 7, 8, 10]");
        System.out.println("         [<7 ][7][>7]");
        System.out.println("  Pivot 7 is now in position 4! All < on left, all > on right!\n");

        int[] test = {6, 2, 8, 4, 10, 3, 7};
        partition(test, 0, test.length - 1);
        System.out.println("Actual result: " + Arrays.toString(test) + " ✓\n");
    }

    /**
     * COMPARISON: Same array, different algorithms
     */
    public static void compareAlgorithms() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  SIDE-BY-SIDE COMPARISON: Same Input, Different Approaches   ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        int[] arr = {9, 3, 7, 1, 4};
        System.out.println("Input: " + Arrays.toString(arr) + "\n");

        // Merge Sort
        int[] test1 = arr.clone();
        System.out.println("MERGE SORT:");
        System.out.println("  Divide: [9,3,7] | [1,4]");
        System.out.println("  Divide: [9] [3] | [7] | [1] | [4]");
        System.out.println("  Merge: [3,9] [7] [1,4]");
        System.out.println("  Merge: [3,7,9] [1,4]");
        System.out.println("  Merge: [1,3,4,7,9]");
        mergeSort(test1, 0, test1.length - 1);
        System.out.println("  Result: " + Arrays.toString(test1) + "\n");

        // Quick Sort
        int[] test2 = arr.clone();
        System.out.println("QUICK SORT:");
        System.out.println("  Pivot: 4");
        System.out.println("  Partition: [3,1] [4] [9,7]");
        System.out.println("  Pivot left (1): [1] [3]");
        System.out.println("  Pivot right (7): [7] [9]");
        System.out.println("  Result: [1,3,4,7,9]");
        quickSort(test2, 0, test2.length - 1);
        System.out.println("  Result: " + Arrays.toString(test2) + " ✓\n");
    }

    public static void main(String[] args) {
        traceMergeSort();
        System.out.println("\n" + "=".repeat(68) + "\n");
        traceQuickSort();
        System.out.println("\n" + "=".repeat(68) + "\n");
        partitionSimulation();
        System.out.println("\n" + "=".repeat(68) + "\n");
        compareAlgorithms();
    }
}
