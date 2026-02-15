/**
 * R06: Tower of Hanoi
 * ===================
 * 
 * Problem:
 * The Tower of Hanoi is a classic puzzle with 3 rods (Source, Auxiliary, Destination)
 * and n disks of different sizes. The objective is to move all disks from the
 * Source rod to the Destination rod following these rules:
 * 
 * Rules:
 * 1. Only one disk can be moved at a time
 * 2. A disk can only be placed on top of a larger disk (or on empty rod)
 * 3. Only the top disk of a rod can be moved
 * 
 * Goal:
 * Move all n disks from rod 'A' (Source) to rod 'C' (Destination) using rod 'B' (Auxiliary)
 * 
 * Examples:
 * 
 * Input: n = 1
 * Output: Move disk 1 from A to C
 * (1 move)
 * 
 * Input: n = 2
 * Output:
 * Move disk 1 from A to B
 * Move disk 2 from A to C
 * Move disk 1 from B to C
 * (3 moves)
 * 
 * Input: n = 3
 * Output: 7 moves (shown below)
 * 
 * Pattern:
 * Minimum moves needed = 2^n - 1
 * - 1 disk: 1 move
 * - 2 disks: 3 moves
 * - 3 disks: 7 moves
 * - 4 disks: 15 moves
 * 
 * Strategy (Recursive):
 * To move n disks from A to C using B:
 * 1. Move (n-1) disks from A to B using C (helper)
 * 2. Move the largest disk from A to C
 * 3. Move (n-1) disks from B to C using A (helper)
 * 
 * Focus:
 * - Breaking problem into smaller subproblems
 * - Understanding the recursive strategy
 * - Managing three parameters (source, aux, dest)
 * 
 * Hints:
 * - Base case: if n == 1, just move the disk from source to destination
 * - Recursive case: follow the 3-step strategy above
 * - The "auxiliary" rod keeps changing based on what you're trying to do
 * - When moving n-1 disks, the roles of rods change!
 * 
 * Visualization for n=3:
 * Initial:        Goal:
 *   A   B   C      A   B   C
 *  [1]  |   |      |   |  [1]
 *  [2]  |   |      |   |  [2]
 *  [3]  |   |      |   |  [3]
 */

public class R06_TowerOfHanoi {

    /**
     * TODO: Implement this method
     * Solve Tower of Hanoi puzzle and print the moves
     * 
     * @param n - number of disks
     * @param source - source rod (e.g., 'A')
     * @param auxiliary - helper rod (e.g., 'B')
     * @param destination - target rod (e.g., 'C')
     */
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        // YOUR CODE HERE
    }

    /**
     * TODO: Implement this method (BONUS)
     * Calculate minimum number of moves needed
     * Formula: 2^n - 1
     * 
     * @param n - number of disks
     * @return minimum moves needed
     */
    public static int countMoves(int n) {
        // YOUR CODE HERE
        return 0; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Tower of Hanoi ===\n");

        // Test Case 1: Single disk
        System.out.println("Test 1: Tower of Hanoi with 1 disk");
        System.out.println("Expected: 1 move");
        System.out.println("Your Output:");
        towerOfHanoi(1, 'A', 'B', 'C');
        System.out.println();

        // Test Case 2: Two disks
        System.out.println("Test 2: Tower of Hanoi with 2 disks");
        System.out.println("Expected: 3 moves");
        System.out.println("Your Output:");
        towerOfHanoi(2, 'A', 'B', 'C');
        System.out.println();

        // Test Case 3: Three disks
        System.out.println("Test 3: Tower of Hanoi with 3 disks");
        System.out.println("Expected: 7 moves");
        System.out.println("Your Output:");
        towerOfHanoi(3, 'A', 'B', 'C');
        System.out.println();

        // Test Case 4: Four disks
        System.out.println("Test 4: Tower of Hanoi with 4 disks");
        System.out.println("Expected: 15 moves");
        System.out.println("Your Output:");
        towerOfHanoi(4, 'A', 'B', 'C');
        System.out.println();

        // BONUS: Test count function
        System.out.println("\n=== BONUS: Count Moves ===\n");
        System.out.println("Moves for 1 disk: " + countMoves(1) + " (Expected: 1)");
        System.out.println("Moves for 2 disks: " + countMoves(2) + " (Expected: 3)");
        System.out.println("Moves for 3 disks: " + countMoves(3) + " (Expected: 7)");
        System.out.println("Moves for 5 disks: " + countMoves(5) + " (Expected: 31)");
        System.out.println("Moves for 10 disks: " + countMoves(10) + " (Expected: 1023)");
    }
}
