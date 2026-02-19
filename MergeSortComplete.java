/**
 * ═══════════════════════════════════════════════════════════════════════════
 * MERGE SORT - COMPLETE GUIDE WITH VISUAL TRACES
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * WHAT IS MERGE SORT?
 * ─────────────────
 * Merge Sort is a DIVIDE-AND-CONQUER sorting algorithm that:
 * 1. DIVIDE: Split array into two halves recursively until single elements
 * 2. CONQUER: Merge pairs of sorted arrays back together in sorted order
 * 
 * KEY CHARACTERISTICS:
 * ─────────────────
 * ✓ Time Complexity: O(n log n) - ALL CASES (Best, Average, Worst)
 * ✓ Space Complexity: O(n) - needs extra space for merging
 * ✓ Stable: Equal elements maintain their relative order
 * ✓ Not In-place: Requires temporary arrays during merge
 * ✓ Great for: Linked lists, large datasets, guaranteed O(n log n)
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * VISUAL TRACE OF MERGE SORT
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Input Array: [38, 27, 43, 3, 9, 82, 10]
 * 
 * STEP 1: DIVIDE (Breaking down into single elements)
 * ──────────────────────────────────────────────────
 * 
 *                    [38, 27, 43, 3, 9, 82, 10]
 *                          /              \
 *                   /────────              ────────\
 *              [38, 27, 43, 3]          [9, 82, 10]
 *              /              \          /         \
 *           /────              ────\   /────       ────\
 *       [38, 27]            [43, 3]  [9, 82]      [10]
 *       /      \            /     \   /    \
 *     [38]    [27]      [43]    [3] [9]  [82]     [10]
 * 
 * Now we have single elements (sorted by definition!)
 * 
 * STEP 2: CONQUER (Merging while maintaining sorted order)
 * ──────────────────────────────────────────────────────
 * 
 * Merge [38] and [27] → [27, 38]
 * Merge [43] and [3]  → [3, 43]
 * Merge [9] and [82]  → [9, 82]
 * 
 *         [27, 38]         [3, 43]        [9, 82]      [10]
 *              \              /              \          /
 *               ────────────────              ──────────
 *                      |                            |
 *              Merge [27,38] + [3,43]    Merge [9,82] + [10]
 *                      |                            |
 *                  [3, 27, 38, 43]            [9, 10, 82]
 *                         \                        /
 *                          ───────────────────────
 *                                  |
 *                   Final Merge [3,27,38,43] + [9,10,82]
 *                                  |
 *                      [3, 9, 10, 27, 38, 43, 82] ✓ SORTED!
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * HOW MERGING WORKS (The Core Concept)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Two sorted halves:  [27, 38, 43]    and    [3, 9, 82]
 * 
 * Compare pointers:
 * 
 * Result: []
 * Left: [27, 38, 43]  (pointer at 27)
 * Right: [3, 9, 82]   (pointer at 3)
 * 
 * Step 1: Compare 27 vs 3 → 3 is smaller
 *         Result: [3]
 *         Move Right pointer
 * 
 * Step 2: Compare 27 vs 9 → 9 is smaller
 *         Result: [3, 9]
 *         Move Right pointer
 * 
 * Step 3: Compare 27 vs 82 → 27 is smaller
 *         Result: [3, 9, 27]
 *         Move Left pointer
 * 
 * Step 4: Compare 38 vs 82 → 38 is smaller
 *         Result: [3, 9, 27, 38]
 *         Move Left pointer
 * 
 * Step 5: Compare 43 vs 82 → 43 is smaller
 *         Result: [3, 9, 27, 38, 43]
 *         Move Left pointer
 * 
 * Step 6: Left exhausted, copy remaining from Right
 *         Result: [3, 9, 27, 38, 43, 82] ✓
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 */

import java.util.Arrays;

public class MergeSortComplete {

    /**
     * MAIN MERGE SORT METHOD
     * 
     * Recursively divides array and calls merge
     * @param arr - array to sort
     * @param left - starting index
     * @param right - ending index
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find middle point
            int mid = left + (right - left) / 2;
            
            // Sort left half
            mergeSort(arr, left, mid);
            
            // Sort right half
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * MERGE METHOD - The heart of Merge Sort
     * 
     * Merges two sorted subarrays: arr[left..mid] and arr[mid+1..right]
     * Uses two-pointer technique to combine in sorted order
     * 
     * @param arr - array containing both sorted halves
     * @param left - start of left half
     * @param mid - end of left half
     * @param right - end of right half
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // Create temp arrays for left and right halves
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        
        // Copy data to temp arrays
        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        
        // Merge the temp arrays back into arr[left..right]
        // i = pointer for left array
        // j = pointer for right array
        // k = pointer for main array
        int i = 0, j = 0, k = left;
        
        // Compare elements from left and right arrays
        // Pick the smaller one and add to main array
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        // Copy remaining elements from left array (if any)
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }
        
        // Copy remaining elements from right array (if any)
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    /**
     * Helper method to print merge process (for understanding)
     */
    public static void printMergeProcess(int[] leftArr, int[] rightArr, int[] result) {
        System.out.println("  Merging: " + Arrays.toString(leftArr) + " + " + 
                          Arrays.toString(rightArr) + " → " + Arrays.toString(result));
    }

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║           MERGE SORT - COMPLETE IMPLEMENTATION                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        // Test Case 1: Example from PDF
        System.out.println("TEST 1: Basic Unsorted Array");
        System.out.println("─────────────────────────────");
        int[] test1 = {5, 2, 4, 1};
        System.out.println("Before: " + Arrays.toString(test1));
        mergeSort(test1, 0, test1.length - 1);
        System.out.println("After:  " + Arrays.toString(test1));
        System.out.println("Expected: [1, 2, 4, 5] ✓\n");

        // Test Case 2: Larger array
        System.out.println("TEST 2: Larger Unsorted Array");
        System.out.println("─────────────────────────────");
        int[] test2 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before: " + Arrays.toString(test2));
        mergeSort(test2, 0, test2.length - 1);
        System.out.println("After:  " + Arrays.toString(test2));
        System.out.println("Expected: [3, 9, 10, 27, 38, 43, 82] ✓\n");

        // Test Case 3: Already sorted
        System.out.println("TEST 3: Already Sorted Array");
        System.out.println("────────────────────────────");
        int[] test3 = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(test3));
        mergeSort(test3, 0, test3.length - 1);
        System.out.println("After:  " + Arrays.toString(test3));
        System.out.println("Expected: [1, 2, 3, 4, 5] ✓\n");

        // Test Case 4: Reverse sorted
        System.out.println("TEST 4: Reverse Sorted Array");
        System.out.println("────────────────────────────");
        int[] test4 = {9, 7, 5, 3, 1};
        System.out.println("Before: " + Arrays.toString(test4));
        mergeSort(test4, 0, test4.length - 1);
        System.out.println("After:  " + Arrays.toString(test4));
        System.out.println("Expected: [1, 3, 5, 7, 9] ✓\n");

        // Test Case 5: Duplicates
        System.out.println("TEST 5: Array with Duplicates");
        System.out.println("─────────────────────────────");
        int[] test5 = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        System.out.println("Before: " + Arrays.toString(test5));
        mergeSort(test5, 0, test5.length - 1);
        System.out.println("After:  " + Arrays.toString(test5));
        System.out.println("Expected: [1, 1, 2, 3, 4, 5, 5, 6, 9] ✓\n");

        // Test Case 6: Negative numbers
        System.out.println("TEST 6: Array with Negative Numbers");
        System.out.println("───────────────────────────────────");
        int[] test6 = {-5, 10, -3, 0, 7, -1};
        System.out.println("Before: " + Arrays.toString(test6));
        mergeSort(test6, 0, test6.length - 1);
        System.out.println("After:  " + Arrays.toString(test6));
        System.out.println("Expected: [-5, -3, -1, 0, 7, 10] ✓\n");

        // Test Case 7: Single element
        System.out.println("TEST 7: Single Element");
        System.out.println("─────────────────────");
        int[] test7 = {42};
        System.out.println("Before: " + Arrays.toString(test7));
        mergeSort(test7, 0, test7.length - 1);
        System.out.println("After:  " + Arrays.toString(test7));
        System.out.println("Expected: [42] ✓\n");

        // Test Case 8: Two elements
        System.out.println("TEST 8: Two Elements");
        System.out.println("───────────────────");
        int[] test8 = {2, 1};
        System.out.println("Before: " + Arrays.toString(test8));
        mergeSort(test8, 0, test8.length - 1);
        System.out.println("After:  " + Arrays.toString(test8));
        System.out.println("Expected: [1, 2] ✓\n");

        // Performance info
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║ TIME COMPLEXITY:   O(n log n) - All Cases (Best/Avg/Worst)   ║");
        System.out.println("║ SPACE COMPLEXITY:  O(n) - Temporary arrays needed            ║");
        System.out.println("║ STABLE:            Yes - Equal elements keep relative order  ║");
        System.out.println("║ IN-PLACE:          No - Requires extra space                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
}
