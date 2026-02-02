/**
 * RECURSION - PART 3: ADVANCED RECURSION II
 * ===========================================
 * 
 * Topics Covered:
 * 1. Permutations
 * 2. Tower of Hanoi
 * 3. Lexicographical Counting
 * 
 * MASTER LEVEL CONCEPTS:
 * ----------------------
 * - Complex Backtracking
 * - State Management
 * - Multiple Base Cases
 * - Mathematical Recursion
 */

public class Part3_AdvancedRecursion2 {
    
    // ========================================================================
    // EXAMPLE 1: PERMUTATIONS
    // ========================================================================
    /**
     * PERMUTATIONS EXPLANATION:
     * -------------------------
     * A permutation is an arrangement of elements where order matters.
     * 
     * Example: Permutations of "abc"
     * "abc", "acb", "bac", "bca", "cab", "cba"
     * Total: n! permutations
     * 
     * APPROACH 1: Using Swapping
     * --------------------------
     * For each position, try putting each remaining character there.
     * 
     * Example for "abc":
     *                         abc
     *           /              |              \
     *      (a at 0)       (b at 0)       (c at 0)
     *         abc             bac             cba
     *        /  \            /  \            /  \
     *     abc  acb        bac  bca        cab  cba
     * 
     * Time Complexity: O(n! * n)
     * Space Complexity: O(n)
     */
    public static void permuteSwap(String str, int index) {
        // Base case: reached end, print the permutation
        if (index == str.length()) {
            System.out.println(str);
            return;
        }
        
        // Try each character at current position
        for (int i = index; i < str.length(); i++) {
            // Swap current with i
            str = swap(str, index, i);
            
            // Recurse for next position
            permuteSwap(str, index + 1);
            
            // Backtrack: swap back
            str = swap(str, index, i);
        }
    }
    
    // Helper function to swap characters in string
    private static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
    
    /**
     * APPROACH 2: Using Include/Exclude
     * ----------------------------------
     * Build permutation by choosing remaining characters one by one.
     */
    public static void permuteInclude(String str, String current, boolean[] used) {
        // Base case: built a complete permutation
        if (current.length() == str.length()) {
            System.out.println(current);
            return;
        }
        
        // Try adding each unused character
        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                permuteInclude(str, current + str.charAt(i), used);
                used[i] = false; // Backtrack
            }
        }
    }
    
    /**
     * Count total permutations (should be n!)
     */
    public static int countPermutations(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * countPermutations(n - 1); // This is factorial!
    }
    
    
    // ========================================================================
    // EXAMPLE 2: TOWER OF HANOI
    // ========================================================================
    /**
     * TOWER OF HANOI EXPLANATION:
     * ---------------------------
     * Classic puzzle with 3 rods (Source, Auxiliary, Destination) and n disks.
     * 
     * Rules:
     * 1. Only one disk can be moved at a time
     * 2. A disk can only be placed on top of a larger disk
     * 3. Move all disks from Source to Destination using Auxiliary
     * 
     * STRATEGY:
     * ---------
     * To move n disks from A to C using B:
     * 1. Move (n-1) disks from A to B using C
     * 2. Move largest disk from A to C
     * 3. Move (n-1) disks from B to C using A
     * 
     * VISUALIZATION for n=3:
     * 
     * Initial State:
     *   A     B     C
     *   |     |     |
     *  [1]    |     |
     *  [2]    |     |
     *  [3]    |     |
     * 
     * Steps:
     * 1. Move disk 1: A → C
     * 2. Move disk 2: A → B
     * 3. Move disk 1: C → B
     * 4. Move disk 3: A → C
     * 5. Move disk 1: B → A
     * 6. Move disk 2: B → C
     * 7. Move disk 1: A → C
     * 
     * Total moves: 2^n - 1
     * 
     * Recurrence Relation:
     * moves(n) = 2 * moves(n-1) + 1
     * moves(1) = 1
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: only one disk
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Step 1: Move (n-1) disks from source to auxiliary using destination
        towerOfHanoi(n - 1, source, destination, auxiliary);
        
        // Step 2: Move the largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Step 3: Move (n-1) disks from auxiliary to destination using source
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
    
    /**
     * Count total moves for Tower of Hanoi
     */
    public static int towerOfHanoiMoves(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * towerOfHanoiMoves(n - 1) + 1;
    }
    
    
    // ========================================================================
    // EXAMPLE 3: LEXICOGRAPHICAL COUNTING
    // ========================================================================
    /**
     * LEXICOGRAPHICAL COUNTING:
     * -------------------------
     * Count from 0 to n in lexicographical (dictionary) order.
     * 
     * Example: n = 15
     * Output: 0, 1, 10, 11, 12, 13, 14, 15, 2, 3, 4, 5, 6, 7, 8, 9
     * 
     * Why this order?
     * In dictionary: "1" comes before "2"
     *                "10" comes before "2" (because "1" < "2")
     *                "100" comes before "20"
     * 
     * Example: n = 25
     * Output: 0, 1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, 5, 6, 7, 8, 9
     * 
     * APPROACH:
     * ---------
     * Start from 0, then try appending digits 0-9 to current number.
     * But don't exceed n.
     * 
     * RECURSION TREE for n=13:
     *                          0
     *            /  |  |  ... (0-9) ... |  |  \
     *           1   2  3  4  5  6  7  8  9  X(10+)
     *          /|\
     *       10 11 12 13 X(14+)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(log n)
     */
    public static void lexicographicalCount(int current, int n) {
        // Base case: exceeded n
        if (current > n) {
            return;
        }
        
        // Print current number
        System.out.print(current + " ");
        
        // Try appending each digit 0-9
        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i;
            if (next <= n) {
                lexicographicalCount(next, n);
            }
        }
    }
    
    // Wrapper function to start from 1 (or 0)
    public static void printLexicographical(int n) {
        // Start with 0, then 1-9
        lexicographicalCount(0, n);
    }
    
    /**
     * Alternative: Generate all numbers in lexicographical order
     */
    public static void lexicographicalCountAlternate(int n) {
        for (int i = 1; i <= 9; i++) {
            lexicographicalHelper(i, n);
        }
    }
    
    private static void lexicographicalHelper(int current, int n) {
        if (current > n) {
            return;
        }
        
        System.out.print(current + " ");
        
        for (int i = 0; i <= 9; i++) {
            lexicographicalHelper(current * 10 + i, n);
        }
    }
    
    
    // ========================================================================
    // BONUS: N-QUEENS PROBLEM (Preview of Backtracking)
    // ========================================================================
    /**
     * N-QUEENS PROBLEM:
     * -----------------
     * Place N queens on an N×N chessboard so that no two queens attack each other.
     * 
     * Queens can attack:
     * - Same row
     * - Same column
     * - Same diagonal
     * 
     * Example: 4-Queens solution:
     * . Q . .
     * . . . Q
     * Q . . .
     * . . Q .
     * 
     * This is a classic backtracking problem!
     */
    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nQueensHelper(board, 0, n);
    }
    
    private static void nQueensHelper(char[][] board, int row, int n) {
        // Base case: placed all queens
        if (row == n) {
            printBoard(board);
            System.out.println();
            return;
        }
        
        // Try placing queen in each column
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                nQueensHelper(board, row + 1, n);
                board[row][col] = '.'; // Backtrack
            }
        }
    }
    
    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    // ========================================================================
    // PRACTICE PROBLEMS FOR YOU TO SOLVE
    // ========================================================================
    
    /**
     * PRACTICE 1: Unique Permutations
     * --------------------------------
     * Generate all unique permutations when string has duplicate characters.
     * 
     * Example: "AAB"
     * Output: AAB, ABA, BAA (not 6 permutations, only 3 unique ones)
     * 
     * Hint: Use a HashSet to track already used characters at each level
     */
    public static void uniquePermutations(String str, String current, boolean[] used) {
        // TODO: Implement this
    }
    
    /**
     * PRACTICE 2: Reverse Tower of Hanoi
     * -----------------------------------
     * Instead of printing moves, count minimum moves needed for n disks.
     * Return the count.
     * 
     * Hint: Formula is 2^n - 1
     */
    public static int countHanoiMoves(int n) {
        // TODO: Implement this
        return 0;
    }
    
    /**
     * PRACTICE 3: Print Numbers in Range Lexicographically
     * -----------------------------------------------------
     * Print all numbers between start and end in lexicographical order.
     * 
     * Example: start = 5, end = 15
     * Output: 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
     * (Lexicographically: 10, 11, 12, 13, 14, 15, 5, 6, 7, 8, 9)
     * 
     * Hint: Similar to lexicographical counting but with range check
     */
    public static void lexicographicalRange(int current, int start, int end) {
        // TODO: Implement this
    }
    
    /**
     * PRACTICE 4: Josephus Problem
     * -----------------------------
     * n people stand in a circle. Starting from person 0, every k-th person
     * is eliminated. Find the position of the last survivor.
     * 
     * Example: n=5, k=2
     * People: 0, 1, 2, 3, 4
     * Elimination order: 1, 3, 0, 4
     * Survivor: 2
     * 
     * Hint: josephus(n, k) = (josephus(n-1, k) + k) % n
     *       Base case: josephus(1, k) = 0
     */
    public static int josephus(int n, int k) {
        // TODO: Implement this
        return 0;
    }
    
    /**
     * PRACTICE 5: Rat in a Maze
     * --------------------------
     * A rat is at position (0,0) in a maze. Find all paths to reach (n-1, n-1).
     * The rat can move Right (R) or Down (D) only.
     * 1 represents open path, 0 represents blocked.
     * 
     * Example: maze = [[1,1,0],
     *                  [1,1,1],
     *                  [0,1,1]]
     * Paths: RRD, DRR (if both valid)
     * 
     * Hint: At each cell, try moving right and down if valid
     */
    public static void ratInMaze(int[][] maze, int row, int col, String path) {
        // TODO: Implement this
    }
    
    
    // ========================================================================
    // TEST CASES
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("=== RECURSION PART 3: ADVANCED RECURSION II ===\n");
        
        // Test Permutations (Swap Method)
        System.out.println("--- PERMUTATIONS (SWAP METHOD) ---");
        System.out.println("Permutations of 'abc':");
        permuteSwap("abc", 0);
        System.out.println();
        
        // Test Permutations (Include Method)
        System.out.println("--- PERMUTATIONS (INCLUDE METHOD) ---");
        System.out.println("Permutations of 'abc':");
        permuteInclude("abc", "", new boolean[3]);
        System.out.println("Total permutations of 4 items: " + countPermutations(4)); // Expected: 24
        System.out.println();
        
        // Test Tower of Hanoi
        System.out.println("--- TOWER OF HANOI ---");
        System.out.println("Solution for 3 disks:");
        towerOfHanoi(3, 'A', 'B', 'C');
        System.out.println("Total moves for 3 disks: " + towerOfHanoiMoves(3)); // Expected: 7
        System.out.println("Total moves for 5 disks: " + towerOfHanoiMoves(5)); // Expected: 31
        System.out.println();
        
        // Test Lexicographical Counting
        System.out.println("--- LEXICOGRAPHICAL COUNTING ---");
        System.out.println("Numbers 0 to 15 in lexicographical order:");
        printLexicographical(15);
        System.out.println("\n");
        
        System.out.println("Numbers 1 to 25 in lexicographical order:");
        lexicographicalCountAlternate(25);
        System.out.println("\n");
        
        // Test N-Queens (Bonus)
        System.out.println("--- N-QUEENS (4-QUEENS) ---");
        System.out.println("All solutions for 4-Queens:");
        solveNQueens(4);
        System.out.println();
        
        
        // ===== PRACTICE PROBLEMS TEST CASES =====
        System.out.println("\n=== PRACTICE PROBLEMS - UNCOMMENT AFTER IMPLEMENTATION ===\n");
        
        /*
        // Test Unique Permutations
        System.out.println("--- UNIQUE PERMUTATIONS ---");
        System.out.println("Unique permutations of 'AAB':");
        uniquePermutations("AAB", "", new boolean[3]);
        System.out.println();
        
        // Test Hanoi Moves Count
        System.out.println("--- HANOI MOVES COUNT ---");
        System.out.println("Moves for 4 disks: " + countHanoiMoves(4)); // Expected: 15
        System.out.println("Moves for 6 disks: " + countHanoiMoves(6)); // Expected: 63
        System.out.println();
        
        // Test Lexicographical Range
        System.out.println("--- LEXICOGRAPHICAL RANGE ---");
        System.out.println("Numbers 5 to 15 in lexicographical order:");
        lexicographicalRange(5, 5, 15);
        System.out.println("\n");
        
        // Test Josephus Problem
        System.out.println("--- JOSEPHUS PROBLEM ---");
        System.out.println("Survivor position (n=5, k=2): " + josephus(5, 2)); // Expected: 2
        System.out.println("Survivor position (n=7, k=3): " + josephus(7, 3)); // Expected: 3
        System.out.println();
        
        // Test Rat in Maze
        System.out.println("--- RAT IN MAZE ---");
        int[][] maze = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };
        System.out.println("All paths in maze:");
        ratInMaze(maze, 0, 0, "");
        */
    }
}
