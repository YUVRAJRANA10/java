/**
 * ═══════════════════════════════════════════════════════════════════════════
 * QUICK SORT - COMPLETE GUIDE WITH VISUAL TRACES
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * WHAT IS QUICK SORT?
 * ─────────────────
 * Quick Sort is a DIVIDE-AND-CONQUER algorithm that:
 * 1. SELECT: Choose a pivot element
 * 2. PARTITION: Arrange so elements < pivot on left, > pivot on right
 * 3. RECURSIVELY: Sort left and right partitions
 * 
 * KEY CHARACTERISTICS:
 * ─────────────────
 * ✓ Time Complexity: O(n log n) average, O(n²) worst case
 * ✓ Space Complexity: O(log n) - only recursion stack
 * ✗ NOT Stable: Equal elements may change relative order
 * ✓ In-place: Sorts within the array, minimal extra space
 * ✓ Great for: General purpose sorting, memory constrained environments
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * VISUAL TRACE OF QUICK SORT
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Input Array: [10, 7, 8, 9, 1, 5]
 * 
 * STEP 1: CHOOSE PIVOT
 * ───────────────────
 * We choose the last element as pivot: 5
 * 
 * [10, 7, 8, 9, 1, | 5 ]
 *                    ↑ pivot
 * 
 * STEP 2: PARTITION
 * ─────────────────
 * Rearrange so: [elements < 5]  [elements > 5]  [5]
 * 
 * Process:
 * - 10 > 5, move to right
 * - 7 > 5, move to right
 * - 8 > 5, move to right
 * - 9 > 5, move to right
 * - 1 < 5, move to left
 * - Pivot (5) goes to its correct position
 * 
 * After Partition:
 * [1] [5] [10, 7, 8, 9]
 *       ↑ Pivot in correct position!
 * 
 * STEP 3: RECURSIVELY SORT LEFT AND RIGHT
 * ────────────────────────────────────────
 * 
 * Left part: [1] → already sorted ✓
 * 
 * Right part: [10, 7, 8, 9]
 *              ↑ Choose pivot 9
 * 
 * After partition:
 * [7, 8] [9] [10]
 * 
 * Continue recursing...
 * [7, 8] → [7] [8]
 * 
 * Final Result:
 * [1, 5, 7, 8, 9, 10] ✓
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * HOW PARTITION WORKS (The Core Concept)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Array: [10, 7, 8, 9, 1, 5]
 * Pivot: 5 (last element)
 * 
 * We use TWO POINTERS technique:
 * i = left pointer (finds elements > pivot)
 * j = right pointer (finds elements < pivot)
 * Then SWAP them
 * 
 * Initial State:
 * i: [10, 7, 8, 9, 1, | 5]
 *     ↑
 * j:  [10, 7, 8, 9, 1, | 5]
 *                        ↑
 * 
 * Iteration 1:
 * - i finds 10 (> 5) at position 0
 * - j finds 1 (< 5) at position 4
 * - Swap 10 and 1
 * [1, 7, 8, 9, 10, | 5]
 * 
 * Iteration 2:
 * - i finds 7 (> 5) at position 1... wait, 7 > 5, move i
 * - i finds 8 (> 5) at position 2... wait, 8 > 5, move i
 * - i finds 9 (> 5) at position 3... wait, 9 > 5, move i
 * - j moves from 10... it's already checked
 * - Pointers cross, stop partition
 * 
 * Place pivot in correct position
 * [1, 5, 7, 8, 9, 10]
 *    ↑
 * Pivot now at correct index!
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 */

import java.util.Arrays;

public class QuickSortComplete {

    /**
     * MAIN QUICK SORT METHOD
     * 
     * Recursively partitions array and sorts subarrays
     * @param arr - array to sort
     * @param low - starting index
     * @param high - ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition and get pivot position
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort left partition (elements < pivot)
            quickSort(arr, low, pivotIndex - 1);
            
            // Recursively sort right partition (elements > pivot)
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * PARTITION METHOD - The heart of Quick Sort
     * 
     * Rearranges array so:
     * - All elements < pivot are on left
     * - All elements > pivot are on right
     * - Pivot is in its final sorted position
     * 
     * @param arr - array to partition
     * @param low - starting index
     * @param high - ending index (pivot location)
     * @return final position of pivot
     */
    public static int partition(int[] arr, int low, int high) {
        // Choose pivot as the last element
        int pivot = arr[high];
        
        // i will be the position where pivot should go
        // It tracks the boundary between < pivot and > pivot elements
        int i = low - 1;
        
        // Iterate through array and compare each element with pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                // Found element smaller than pivot
                i++; // Move boundary
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Place pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1; // Return pivot's final position
    }

    /**
     * Alternative partition method using Hoare partition scheme
     * (More efficient, uses 2-way partition)
     */
    public static int partitionHoare(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        
        while (true) {
            // Move i from left until we find element >= pivot
            do {
                i++;
            } while (arr[i] < pivot);
            
            // Move j from right until we find element <= pivot
            do {
                j--;
            } while (arr[j] > pivot);
            
            // If pointers crossed, partition is done
            if (i >= j) {
                return j;
            }
            
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║           QUICK SORT - COMPLETE IMPLEMENTATION                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        // Test Case 1: Example from PDF
        System.out.println("TEST 1: Basic Unsorted Array");
        System.out.println("────────────────────────────");
        int[] test1 = {10, 7, 8, 9, 1, 5};
        System.out.println("Before: " + Arrays.toString(test1));
        quickSort(test1, 0, test1.length - 1);
        System.out.println("After:  " + Arrays.toString(test1));
        System.out.println("Expected: [1, 5, 7, 8, 9, 10] ✓\n");

        // Test Case 2: Already sorted
        System.out.println("TEST 2: Already Sorted Array");
        System.out.println("────────────────────────────");
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(test2));
        quickSort(test2, 0, test2.length - 1);
        System.out.println("After:  " + Arrays.toString(test2));
        System.out.println("Expected: [1, 2, 3, 4, 5] ✓");
        System.out.println("Note: Worst case O(n²) for already sorted array!\n");

        // Test Case 3: Reverse sorted
        System.out.println("TEST 3: Reverse Sorted Array");
        System.out.println("────────────────────────────");
        int[] test3 = {5, 4, 3, 2, 1};
        System.out.println("Before: " + Arrays.toString(test3));
        quickSort(test3, 0, test3.length - 1);
        System.out.println("After:  " + Arrays.toString(test3));
        System.out.println("Expected: [1, 2, 3, 4, 5] ✓\n");

        // Test Case 4: Duplicates
        System.out.println("TEST 4: Array with Duplicates");
        System.out.println("─────────────────────────────");
        int[] test4 = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        System.out.println("Before: " + Arrays.toString(test4));
        quickSort(test4, 0, test4.length - 1);
        System.out.println("After:  " + Arrays.toString(test4));
        System.out.println("Expected: [1, 1, 2, 3, 4, 5, 5, 6, 9] ✓\n");

        // Test Case 5: Negative numbers
        System.out.println("TEST 5: Array with Negative Numbers");
        System.out.println("───────────────────────────────────");
        int[] test5 = {-5, 10, -3, 0, 7, -1};
        System.out.println("Before: " + Arrays.toString(test5));
        quickSort(test5, 0, test5.length - 1);
        System.out.println("After:  " + Arrays.toString(test5));
        System.out.println("Expected: [-5, -3, -1, 0, 7, 10] ✓\n");

        // Test Case 6: Single element
        System.out.println("TEST 6: Single Element");
        System.out.println("─────────────────────");
        int[] test6 = {42};
        System.out.println("Before: " + Arrays.toString(test6));
        quickSort(test6, 0, test6.length - 1);
        System.out.println("After:  " + Arrays.toString(test6));
        System.out.println("Expected: [42] ✓\n");

        // Test Case 7: Two elements
        System.out.println("TEST 7: Two Elements");
        System.out.println("───────────────────");
        int[] test7 = {2, 1};
        System.out.println("Before: " + Arrays.toString(test7));
        quickSort(test7, 0, test7.length - 1);
        System.out.println("After:  " + Arrays.toString(test7));
        System.out.println("Expected: [1, 2] ✓\n");

        // Test Case 8: Large random array
        System.out.println("TEST 8: Larger Array");
        System.out.println("───────────────────");
        int[] test8 = {38, 27, 43, 3, 9, 82, 10, 100, 55, 25};
        System.out.println("Before: " + Arrays.toString(test8));
        quickSort(test8, 0, test8.length - 1);
        System.out.println("After:  " + Arrays.toString(test8));
        System.out.println("Expected: [3, 9, 10, 25, 27, 38, 43, 55, 82, 100] ✓\n");

        // Performance info
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║ TIME COMPLEXITY:                                              ║");
        System.out.println("║   Average Case:  O(n log n)                                   ║");
        System.out.println("║   Worst Case:    O(n²) - when pivot divides unevenly         ║");
        System.out.println("║   Best Case:     O(n log n) - when pivot divides evenly      ║");
        System.out.println("║ SPACE COMPLEXITY:  O(log n) - Only recursion stack           ║");
        System.out.println("║ STABLE:            No - Equal elements may change order      ║");
        System.out.println("║ IN-PLACE:          Yes - Sorts within the array             ║");
        System.out.println("║                                                              ║");
        System.out.println("║ ADVANTAGES OVER MERGE SORT:                                 ║");
        System.out.println("║ • O(log n) space vs O(n) for Merge Sort                     ║");
        System.out.println("║ • Faster average case in practice                           ║");
        System.out.println("║ • In-place sorting                                          ║");
        System.out.println("║                                                              ║");
        System.out.println("║ DISADVANTAGES:                                              ║");
        System.out.println("║ • O(n²) worst case possible                                 ║");
        System.out.println("║ • Not stable                                                ║");
        System.out.println("║ • Pivot selection affects performance                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
}
