/**
 * R04: Board Path (Climbing Stairs)
 * ==================================
 * 
 * Problem:
 * You are at position 0 and want to reach position n.
 * At each step, you can move 1, 2, or 3 steps forward.
 * Print all possible paths to reach position n.
 * 
 * Examples:
 * 
 * Input: n = 2
 * Output: 11, 2  (2 paths)
 * Explanation: You can either take two 1-steps OR one 2-step
 * 
 * Input: n = 3
 * Output: 111, 12, 21, 3  (4 paths)
 * 
 * Input: n = 4
 * Output: 1111, 112, 121, 211, 13, 31, 22  (7 paths)
 * 
 * Focus:
 * - Multiple choices at each step (3 choices: 1, 2, or 3)
 * - Similar to subsequences but with different branching
 * - Understanding when to stop (reached exactly n or overshot)
 * 
 * Hints:
 * - Base case 1: if current == end, print the path (reached!)
 * - Base case 2: if current > end, return (overshot!)
 * - At each position, try all possible steps: 1, 2, and 3
 * - Build path string by appending the step taken
 * 
 * Think about it for n=3:
 *                    0 (start)
 *              /     |      \
 *           +1      +2       +3
 *            1       2        3 (goal!)
 *         /  |  \    |
 *       +1  +2 +3   +1
 *        2   3  X    3 (goal!)
 *        |       
 *       +1
 *        3 (goal!)
 * 
 * Paths found: "3", "21", "12", "111"
 */

public class R04_BoardPath {

    /**
     * TODO: Implement this method
     * Print all possible paths from 0 to n
     * 
     * @param current - current position
     * @param end - target position
     * @param path - path taken so far
     */
    public static void printBoardPath(int current, int end, String path) {
        // Base case 1: Reached the target!
        if (current == end) {
            System.out.println(path);
            return;
        }
        
        // Base case 2: Overshot the target, invalid path
        if (current > end) {
            return;
        }
        
        // Try all 3 possible moves: jump 1, 2, or 3 steps
        printBoardPath(current + 1, end, path + "1");
        printBoardPath(current + 2, end, path + "2");
        printBoardPath(current + 3, end, path + "3");
    }

    /**
     * TODO: Implement this method (BONUS)
     * Count total number of paths
     * 
     * @param current - current position
     * @param end - target position
     * @return count of paths
     */
    public static int countBoardPath(int current, int end) {
        // Base case 1: Reached the target
        if (current == end) {
            return 1;
        }
        
        // Base case 2: Overshot, invalid path
        if (current > end) {
            return 0;  // This path doesn't count!
        }

        // Count paths by trying all 3 moves
        int a = countBoardPath(current + 1, end);
        int b = countBoardPath(current + 2, end);
        int c = countBoardPath(current + 3, end);

        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("=== Board Path (Climbing Stairs) ===\n");

        // Test Case 1: Reach position 2
        System.out.println("Test 1: Paths to reach position 2");
        System.out.println("Expected: 11, 2 (2 paths)");
        System.out.println("Your Output:");
        printBoardPath(0, 2, "");
        System.out.println();

        // Test Case 2: Reach position 3
        System.out.println("Test 2: Paths to reach position 3");
        System.out.println("Expected: 111, 12, 21, 3 (4 paths)");
        System.out.println("Your Output:");
        printBoardPath(0, 3, "");
        System.out.println();

        // Test Case 3: Reach position 4
        System.out.println("Test 3: Paths to reach position 4");
        System.out.println("Expected: 7 paths");
        System.out.println("Your Output:");
        printBoardPath(0, 4, "");
        System.out.println();

        // Test Case 4: Reach position 5
        System.out.println("Test 4: Paths to reach position 5");
        System.out.println("Expected: 13 paths");
        System.out.println("Your Output:");
        printBoardPath(0, 5, "");
        System.out.println();

        // Test Case 5: Single step
        System.out.println("Test 5: Paths to reach position 1");
        System.out.println("Expected: 1 (1 path)");
        System.out.println("Your Output:");
        printBoardPath(0, 1, "");
        System.out.println();

        // BONUS: Test count function
        System.out.println("\n=== BONUS: Count Paths ===\n");
        System.out.println("Count for position 3: " + countBoardPath(0, 3) + " (Expected: 4)");
        System.out.println("Count for position 4: " + countBoardPath(0, 4) + " (Expected: 7)");
        System.out.println("Count for position 6: " + countBoardPath(0, 6) + " (Expected: 24)");
    }
}
