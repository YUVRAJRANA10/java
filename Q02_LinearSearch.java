/**
 * Problem 2: Lost Document Search in Records Room (Linear Search)
 * 
 * A records room contains thousands of files arranged in a line. A clerk is asked to find the first
 * occurrence of a document with a specific reference number. He checks one file at a time and if
 * it doesn't match, asks the same process to continue from the next file.
 * 
 * Task: Write a recursive function to find the first index of the given document number.
 */
public class Q02_LinearSearch {

    /**
     * TODO: Implement this method
     * Find the first index of target element using recursion
     * 
     * @param arr - array of document reference numbers
     * @param index - current index to check
     * @param target - document number to find
     * @return index of first occurrence, or -1 if not found
     */
    public static int linearSearch(int[] arr, int index, int target) {
        // YOUR CODE HERE
       if(arr[index] == target){
        return index;
       }

       if(index == arr.length -1 ){
        return -1;
       }


        return linearSearch(arr, index+ 1, target) ;// placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Lost Document Search (Linear Search) ===\n");

        // Test Case 1: Element present in middle
        int[] test1 = {1001, 1002, 1003, 1004, 1005};
        System.out.println("Test 1: Array = {1001, 1002, 1003, 1004, 1005}, Target = 1003");
        System.out.println("Expected: 2");
        System.out.println("Your Output: " + linearSearch(test1, 0, 1003));
        System.out.println();

        // Test Case 2: Element at first position
        int[] test2 = {500, 600, 700, 800};
        System.out.println("Test 2: Array = {500, 600, 700, 800}, Target = 500");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + linearSearch(test2, 0, 500));
        System.out.println();

        // Test Case 3: Element at last position
        int[] test3 = {10, 20, 30, 40, 50};
        System.out.println("Test 3: Array = {10, 20, 30, 40, 50}, Target = 50");
        System.out.println("Expected: 4");
        System.out.println("Your Output: " + linearSearch(test3, 0, 50));
        System.out.println();

        // Test Case 4: Element not present
        int[] test4 = {100, 200, 300};
        System.out.println("Test 4: Array = {100, 200, 300}, Target = 999");
        System.out.println("Expected: -1");
        System.out.println("Your Output: " + linearSearch(test4, 0, 999));
        System.out.println();

        // Test Case 5: Multiple occurrences (should return first)
        int[] test5 = {5, 10, 15, 10, 20, 10};
        System.out.println("Test 5: Array = {5, 10, 15, 10, 20, 10}, Target = 10");
        System.out.println("Expected: 1 (first occurrence)");
        System.out.println("Your Output: " + linearSearch(test5, 0, 10));
        System.out.println();

        // Test Case 6: Single element array - found
        int[] test6 = {42};
        System.out.println("Test 6: Array = {42}, Target = 42");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + linearSearch(test6, 0, 42));
    }
}
