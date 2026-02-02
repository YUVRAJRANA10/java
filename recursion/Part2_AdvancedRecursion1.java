/**
 * RECURSION - PART 2: ADVANCED RECURSION I
 * ==========================================
 * 
 * Topics Covered:
 * 1. Fibonacci (with optimization techniques)
 * 2. Subsequences
 * 3. Coin Toss
 * 4. Board Path (similar to climbing stairs)
 * 
 * ADVANCED CONCEPTS:
 * ------------------
 * - Multiple Recursive Calls (branching)
 * - Decision Trees
 * - Backtracking Basics
 * - Memoization (Dynamic Programming intro)
 */

public class Part2_AdvancedRecursion1 {
    
    // ========================================================================
    // EXAMPLE 1: FIBONACCI - DETAILED ANALYSIS
    // ========================================================================
    /**
     * FIBONACCI DEEP DIVE:
     * --------------------
     * Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     * 
     * Recurrence: F(n) = F(n-1) + F(n-2)
     * Base Cases: F(0) = 0, F(1) = 1
     * 
     * PROBLEM WITH NAIVE RECURSION:
     * ------------------------------
     * fib(5) calls:
     *                    fib(5)
     *                  /        \
     *             fib(4)          fib(3)
     *            /      \        /      \
     *        fib(3)   fib(2)  fib(2)  fib(1)
     *        /    \   /    \  /    \
     *    fib(2) fib(1) fib(1) fib(0) fib(1) fib(0)
     *    /   \
     * fib(1) fib(0)
     * 
     * Notice: fib(3) is calculated TWICE, fib(2) is calculated THREE times!
     * This leads to EXPONENTIAL time complexity: O(2^n)
     * 
     * Time Complexity: O(2^n) - exponential growth
     * Space Complexity: O(n) - call stack depth
     */
    public static int fibonacciNaive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
    }
    
    /**
     * FIBONACCI WITH MEMOIZATION:
     * ---------------------------
     * Store already computed values to avoid recalculation.
     * This is called "Top-Down Dynamic Programming" or "Memoization"
     * 
     * Time Complexity: O(n) - each value computed once
     * Space Complexity: O(n) - array + call stack
     */
    public static int fibonacciMemo(int n, int[] memo) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        
        // Check if already computed
        if (memo[n] != -1) {
            return memo[n];
        }
        
        // Compute and store
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }
    
    // Helper function for memoization
    public static int fibonacci(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return fibonacciMemo(n, memo);
    }
    
    
    // ========================================================================
    // EXAMPLE 2: SUBSEQUENCES
    // ========================================================================
    /**
     * SUBSEQUENCES EXPLANATION:
     * -------------------------
     * A subsequence is formed by deleting some (or no) characters from a string
     * without changing the order of remaining characters.
     * 
     * Example: Subsequences of "abc"
     * "", "a", "b", "c", "ab", "ac", "bc", "abc"
     * Total: 2^n subsequences (each character can be included or excluded)
     * 
     * DECISION TREE for "abc":
     *                          ""
     *                    /           \
     *                   /             \
     *              (include a)    (exclude a)
     *                 "a"              ""
     *              /      \          /      \
     *          (inc b) (exc b)   (inc b) (exc b)
     *           "ab"     "a"       "b"      ""
     *          /   \    /   \     /   \    /   \
     *        "abc" "ab" "ac" "a" "bc" "b" "c"  ""
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) - recursion depth
     */
    public static void printSubsequences(String str, String current, int index) {
        // Base case: processed all characters
        if (index == str.length()) {
            System.out.println("\"" + current + "\"");
            return;
        }
        
        // Get current character
        char ch = str.charAt(index);
        
        // Decision 1: Include current character
        printSubsequences(str, current + ch, index + 1);
        
        // Decision 2: Exclude current character
        printSubsequences(str, current, index + 1);
    }
    
    /**
     * Count number of subsequences
     */
    public static int countSubsequences(String str, int index) {
        if (index == str.length()) {
            return 1; // Empty subsequence
        }
        
        // Include + Exclude
        return countSubsequences(str, index + 1) + countSubsequences(str, index + 1);
    }
    
    
    // ========================================================================
    // EXAMPLE 3: COIN TOSS
    // ========================================================================
    /**
     * COIN TOSS PROBLEM:
     * ------------------
     * Given n coins, print all possible outcomes of tossing them.
     * Each toss can result in Head (H) or Tail (T).
     * 
     * Example: n = 2
     * Output: HH, HT, TH, TT
     * 
     * Example: n = 3
     * Output: HHH, HHT, HTH, HTT, THH, THT, TTH, TTT
     * 
     * DECISION TREE for n=3:
     *                          ""
     *                    /           \
     *                   H             T
     *                 /   \         /   \
     *               HH     HT      TH     TT
     *              / \    / \     / \    / \
     *           HHH HHT HTH HTT THH THT TTH TTT
     * 
     * Total outcomes: 2^n
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static void coinToss(int n, String current) {
        // Base case: tossed all coins
        if (n == 0) {
            System.out.println(current);
            return;
        }
        
        // Choice 1: Head
        coinToss(n - 1, current + "H");
        
        // Choice 2: Tail
        coinToss(n - 1, current + "T");
    }
    
    /**
     * Count total possible outcomes
     */
    public static int countCoinToss(int n) {
        if (n == 0) {
            return 1;
        }
        return countCoinToss(n - 1) + countCoinToss(n - 1); // 2 * countCoinToss(n-1)
    }
    
    
    // ========================================================================
    // EXAMPLE 4: BOARD PATH (CLIMBING STAIRS)
    // ========================================================================
    /**
     * BOARD PATH PROBLEM:
     * -------------------
     * You are standing at position 0 and want to reach position n.
     * At each step, you can move 1, 2, or 3 steps forward.
     * Find all possible paths to reach position n.
     * 
     * Example: n = 3
     * Paths: [1,1,1], [1,2], [2,1], [3]
     * 
     * Example: n = 4
     * Paths: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [1,3], [3,1], [2,2]
     * 
     * DECISION TREE for n=3:
     *                      0 (start)
     *                   /  |  \
     *                  1   2   3 (goal!)
     *                /|\   |
     *               2 3 X  3 (goal!)
     *               |     
     *               3 (goal!)
     * 
     * Recurrence Relation:
     * paths(n) = paths(n-1) + paths(n-2) + paths(n-3)
     * This is similar to Tribonacci sequence!
     * 
     * Time Complexity: O(3^n) without memoization
     * Space Complexity: O(n)
     */
    public static void printBoardPath(int current, int end, String path) {
        // Base case: reached the end
        if (current == end) {
            System.out.println(path);
            return;
        }
        
        // Base case: overshot
        if (current > end) {
            return;
        }
        
        // Try all possible moves: 1, 2, or 3 steps
        for (int step = 1; step <= 3; step++) {
            printBoardPath(current + step, end, path + step);
        }
    }
    
    /**
     * Count number of paths
     */
    public static int countBoardPath(int current, int end) {
        if (current == end) {
            return 1;
        }
        if (current > end) {
            return 0;
        }
        
        int count = 0;
        for (int step = 1; step <= 3; step++) {
            count += countBoardPath(current + step, end);
        }
        return count;
    }
    
    /**
     * Count paths with memoization
     */
    public static int countBoardPathMemo(int current, int end, int[] memo) {
        if (current == end) {
            return 1;
        }
        if (current > end) {
            return 0;
        }
        
        if (memo[current] != -1) {
            return memo[current];
        }
        
        int count = 0;
        for (int step = 1; step <= 3; step++) {
            count += countBoardPathMemo(current + step, end, memo);
        }
        
        memo[current] = count;
        return count;
    }
    
    
    // ========================================================================
    // PRACTICE PROBLEMS FOR YOU TO SOLVE
    // ========================================================================
    
    /**
     * PRACTICE 1: Print All Binary Strings of Length N
     * -------------------------------------------------
     * Print all binary strings of length n (strings with only 0s and 1s).
     * 
     * Example: n = 2
     * Output: 00, 01, 10, 11
     * 
     * Example: n = 3
     * Output: 000, 001, 010, 011, 100, 101, 110, 111
     * 
     * Hint: Similar to coin toss, but with 0 and 1
     */
    public static void printBinaryStrings(int n, String current) {
        // TODO: Implement this
    }
    
    /**
     * PRACTICE 2: Subset Sum
     * -----------------------
     * Given an array and a target sum, print all subsets that sum to target.
     * 
     * Example: arr = [2, 3, 5], target = 5
     * Output: [2, 3], [5]
     * 
     * Example: arr = [1, 2, 3, 4], target = 5
     * Output: [1, 4], [2, 3]
     * 
     * Hint: At each element, you can include it or exclude it (like subsequences)
     */
    public static void subsetSum(int[] arr, int index, int target, String current) {
        // TODO: Implement this
    }
    
    /**
     * PRACTICE 3: Dice Throw
     * -----------------------
     * You have n dice, each showing 1-6. Print all possible combinations.
     * 
     * Example: n = 2
     * Output: 11, 12, 13, 14, 15, 16, 21, 22, ... 66 (36 combinations)
     * 
     * Hint: Similar to board path, but each die has 6 choices
     */
    public static void diceCombinations(int n, String current) {
        // TODO: Implement this
    }
    
    /**
     * PRACTICE 4: Climbing Stairs (Different Step Sizes)
     * ---------------------------------------------------
     * You can climb 1 or 2 steps at a time. Count ways to reach nth stair.
     * 
     * Example: n = 4
     * Ways: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]
     * Count: 5
     * 
     * Hint: This is actually the Fibonacci sequence!
     * ways(n) = ways(n-1) + ways(n-2)
     */
    public static int climbStairs(int n) {
        // TODO: Implement this
        return 0;
    }
    
    /**
     * PRACTICE 5: Generate Parentheses
     * ---------------------------------
     * Generate all valid combinations of n pairs of parentheses.
     * 
     * Example: n = 2
     * Output: (()), ()()
     * 
     * Example: n = 3
     * Output: ((())), (()()), (())(), ()(()), ()()()
     * 
     * Rules:
     * - Can add '(' if we haven't used all n opening brackets
     * - Can add ')' if it won't make the string invalid (more closing than opening)
     * 
     * Hint: Keep track of open and close bracket counts
     */
    public static void generateParentheses(int n, int open, int close, String current) {
        // TODO: Implement this
    }
    
    
    // ========================================================================
    // TEST CASES
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("=== RECURSION PART 2: ADVANCED RECURSION I ===\n");
        
        // Test Fibonacci
        System.out.println("--- FIBONACCI ---");
        System.out.println("Naive approach:");
        System.out.println("fibonacci(10) = " + fibonacciNaive(10)); // Expected: 55
        System.out.println("\nMemoization approach:");
        System.out.println("fibonacci(40) = " + fibonacci(40)); // Expected: 102334155 (fast!)
        System.out.println();
        
        // Test Subsequences
        System.out.println("--- SUBSEQUENCES ---");
        System.out.println("Subsequences of 'abc':");
        printSubsequences("abc", "", 0);
        System.out.println("Count: " + countSubsequences("abc", 0)); // Expected: 8
        System.out.println();
        
        // Test Coin Toss
        System.out.println("--- COIN TOSS ---");
        System.out.println("Coin toss outcomes for 3 coins:");
        coinToss(3, "");
        System.out.println("Total outcomes: " + countCoinToss(3)); // Expected: 8
        System.out.println();
        
        // Test Board Path
        System.out.println("--- BOARD PATH ---");
        System.out.println("All paths to reach position 4:");
        printBoardPath(0, 4, "");
        System.out.println("Total paths: " + countBoardPath(0, 4)); // Expected: 7
        System.out.println();
        
        // Memoized version
        int[] memo = new int[11];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        System.out.println("Paths to position 10 (memoized): " + countBoardPathMemo(0, 10, memo));
        System.out.println();
        
        
        // ===== PRACTICE PROBLEMS TEST CASES =====
        System.out.println("\n=== PRACTICE PROBLEMS - UNCOMMENT AFTER IMPLEMENTATION ===\n");
        
        /*
        // Test Binary Strings
        System.out.println("--- BINARY STRINGS ---");
        System.out.println("All binary strings of length 3:");
        printBinaryStrings(3, "");
        System.out.println();
        
        // Test Subset Sum
        System.out.println("--- SUBSET SUM ---");
        System.out.println("Subsets that sum to 5 from [2, 3, 5]:");
        subsetSum(new int[]{2, 3, 5}, 0, 5, "");
        System.out.println();
        
        // Test Dice Combinations
        System.out.println("--- DICE COMBINATIONS ---");
        System.out.println("All dice combinations for 2 dice:");
        diceCombinations(2, "");
        System.out.println();
        
        // Test Climbing Stairs
        System.out.println("--- CLIMBING STAIRS ---");
        System.out.println("Ways to climb 5 stairs: " + climbStairs(5)); // Expected: 8
        System.out.println("Ways to climb 10 stairs: " + climbStairs(10)); // Expected: 89
        System.out.println();
        
        // Test Generate Parentheses
        System.out.println("--- GENERATE PARENTHESES ---");
        System.out.println("Valid parentheses for n=3:");
        generateParentheses(3, 0, 0, "");
        */
    }
}
