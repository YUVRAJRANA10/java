/**
 * Problem 3: CCTV Review – Last Seen Moment (Last Index)
 * 
 * A security team reviews CCTV footage stored frame-by-frame in an array. A suspicious person
 * appears multiple times in the footage. The team needs to find the last frame where the person
 * appeared.
 * 
 * Condition: The footage can be reviewed only sequentially, but the final answer must be the
 * latest appearance.
 * 
 * Task: Use recursion to find the last index of the target frame.
 */
public class Q03_LastIndex {

    /**
     * TODO: Implement this method
     * Find the last index of target element using recursion
     * 
     * @param arr - array of frame IDs
     * @param index - current index to check
     * @param target - target frame to find
     * @return index of last occurrence, or -1 if not found
     * 
     */

    public static int finall = -1;
    public static int lastIndex(int[] arr, int index, int target) {
        // YOUR CODE HERE
          
     


     if(arr[index] == target ){
        finall = index;
     }
     
     if(index ==  arr.length - 1){
        return finall;
     }

     return lastIndex(arr, index + 1, target);




        // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== CCTV Review – Last Seen Moment (Last Index) ===\n");

        // Test Case 1: Multiple occurrences
        int[] test1 = {5, 3, 5, 7, 5, 9, 5};
        System.out.println("Test 1: Array = {5, 3, 5, 7, 5, 9, 5}, Target = 5");
        System.out.println("Expected: 6 (last occurrence)");
        System.out.println("Your Output: " + lastIndex(test1, 0, 5));
        System.out.println();

        // Test Case 2: Single occurrence
        int[] test2 = {10, 20, 30, 40, 50};
        System.out.println("Test 2: Array = {10, 20, 30, 40, 50}, Target = 30");
        System.out.println("Expected: 2");
        System.out.println("Your Output: " + lastIndex(test2, 0, 30));
        System.out.println();

        // Test Case 3: Target at first position only
        int[] test3 = {99, 1, 2, 3, 4};
        System.out.println("Test 3: Array = {99, 1, 2, 3, 4}, Target = 99");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + lastIndex(test3, 0, 99));
        System.out.println();

        // Test Case 4: Target not present
        int[] test4 = {1, 2, 3, 4, 5};
        System.out.println("Test 4: Array = {1, 2, 3, 4, 5}, Target = 100");
        System.out.println("Expected: -1");
        System.out.println("Your Output: " + lastIndex(test4, 0, 100));
        System.out.println();

        // Test Case 5: All elements are same
        int[] test5 = {7, 7, 7, 7, 7};
        System.out.println("Test 5: Array = {7, 7, 7, 7, 7}, Target = 7");
        System.out.println("Expected: 4 (last index)");
        System.out.println("Your Output: " + lastIndex(test5, 0, 7));
        System.out.println();

        // Test Case 6: Two occurrences
        int[] test6 = {1, 2, 3, 2, 1};
        System.out.println("Test 6: Array = {1, 2, 3, 2, 1}, Target = 2");
        System.out.println("Expected: 3");
        System.out.println("Your Output: " + lastIndex(test6, 0, 2));
    }
}
