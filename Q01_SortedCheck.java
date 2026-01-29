/**
 * Problem 1: Office Files Verification (Sorted Check)
 * 
 * An HR system stores employee IDs in an array. The HR manager wants to verify whether the
 * IDs are arranged in increasing order before uploading them to the central server.
 * 
 * Task: Using recursion, check whether the employee ID list is sorted or not.
 * Hint: Compare the current ID with the next, then recursively check the remaining list.
 */
public class Q01_SortedCheck {

    /**
     * TODO: Implement this method
     * Check if array is sorted in increasing order using recursion
     * 
     * @param arr - array of employee IDs
     * @param index - current index to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] arr, int index) {
        // Base case: if we reach the second-to-last element, array is sorted
        if(index == arr.length - 1){
            return true;
        }

        // If current element is greater than next, NOT sorted
        if(arr[index] > arr[index + 1]){
            return false;
        }

        // Recursively check remaining array
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Office Files Verification (Sorted Check) ===\n");

        // Test Case 1: Sorted array
        int[] test1 = {101, 102, 103, 104, 105};
        System.out.println("Test 1: {101, 102, 103, 104, 105}");
        System.out.println("Expected: true");
        System.out.println("Your Output: " + isSorted(test1, 0));
        System.out.println();

        // Test Case 2: Unsorted array
        int[] test2 = {101, 105, 103, 104, 102};
        System.out.println("Test 2: {101, 105, 103, 104, 102}");
        System.out.println("Expected: false");
        System.out.println("Your Output: " + isSorted(test2, 0));
        System.out.println();

        // Test Case 3: Single element (edge case)
        int[] test3 = {100};
        System.out.println("Test 3: {100}");
        System.out.println("Expected: true");
        System.out.println("Your Output: " + isSorted(test3, 0));
        System.out.println();

        // Test Case 4: Two elements sorted
        int[] test4 = {50, 60};
        System.out.println("Test 4: {50, 60}");
        System.out.println("Expected: true");
        System.out.println("Your Output: " + isSorted(test4, 0));
        System.out.println();

        // Test Case 5: Two elements unsorted
        int[] test5 = {60, 50};
        System.out.println("Test 5: {60, 50}");
        System.out.println("Expected: false");
        System.out.println("Your Output: " + isSorted(test5, 0));
        System.out.println();

        // Test Case 6: Array with duplicates (still sorted)
        int[] test6 = {10, 20, 20, 30};
        System.out.println("Test 6: {10, 20, 20, 30}");
        System.out.println("Expected: true");
        System.out.println("Your Output: " + isSorted(test6, 0));
    }
}
