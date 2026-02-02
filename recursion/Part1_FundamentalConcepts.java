/**
 * RECURSION - PART 1: FUNDAMENTAL CONCEPTS
 * =========================================
 * 
 * WHAT IS RECURSION?
 * ------------------
 * Recursion is a programming technique where a function calls itself to solve a problem.
 * A recursive function breaks down a complex problem into smaller, similar sub-problems.
 * 
 * KEY COMPONENTS OF RECURSION:
 * 1. BASE CASE: The condition that stops the recursion (prevents infinite loop)
 * 2. RECURSIVE CASE: The function calling itself with modified parameters
 * 3. PROGRESS: Each recursive call must move towards the base case
 * 
 * THE CALL STACK:
 * ---------------
 * - When a function is called, it's pushed onto the call stack
 * - When a function returns, it's popped from the call stack
 * - Each recursive call creates a new stack frame with its own local variables
 * - If recursion is too deep, you get StackOverflowError
 * 
 * Example of Call Stack for factorial(3):
 * factorial(3) → calls factorial(2) → calls factorial(1) → calls factorial(0)
 *                                                              ↓ returns 1
 *                                                   returns 1*1 = 1
 *                                      returns 2*1 = 2
 *                     returns 3*2 = 6
 * 
 * RECURRENCE RELATIONS:
 * ---------------------
 * Mathematical way to express recursive relationships:
 * - factorial(n) = n * factorial(n-1), where factorial(0) = 1
 * - power(x, n) = x * power(x, n-1), where power(x, 0) = 1
 */

public class Part1_FundamentalConcepts {
    
    // ========================================================================
    // EXAMPLE 1: FACTORIAL
    // ========================================================================
    /**
     * FACTORIAL EXPLANATION:
     * ----------------------
     * factorial(n) = n! = n × (n-1) × (n-2) × ... × 2 × 1
     * 
     * Recurrence Relation:
     * factorial(n) = n * factorial(n-1)
     * Base Case: factorial(0) = 1
     * 
     * Example: factorial(5)
     * = 5 * factorial(4)
     * = 5 * 4 * factorial(3)
     * = 5 * 4 * 3 * factorial(2)
     * = 5 * 4 * 3 * 2 * factorial(1)
     * = 5 * 4 * 3 * 2 * 1 * factorial(0)
     * = 5 * 4 * 3 * 2 * 1 * 1
     * = 120
     * 
     * Time Complexity: O(n) - n recursive calls
     * Space Complexity: O(n) - call stack depth
     */
    public static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        
        // Recursive case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }
    
    // Iterative version for comparison
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    
    // ========================================================================
    // EXAMPLE 2: POWER FUNCTION
    // ========================================================================
    /**
     * POWER EXPLANATION:
     * ------------------
     * power(x, n) = x^n = x × x × x × ... (n times)
     * 
     * Recurrence Relation:
     * power(x, n) = x * power(x, n-1)
     * Base Case: power(x, 0) = 1
     * 
     * Example: power(2, 4)
     * = 2 * power(2, 3)
     * = 2 * 2 * power(2, 2)
     * = 2 * 2 * 2 * power(2, 1)
     * = 2 * 2 * 2 * 2 * power(2, 0)
     * = 2 * 2 * 2 * 2 * 1
     * = 16
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int power(int x, int n) {
        // Base case: any number to power 0 is 1
        if (n == 0) {
            return 1;
        }
        
        // Recursive case: x^n = x * x^(n-1)
        return x * power(x, n - 1);
    }
    
    /**
     * OPTIMIZED POWER - DIVIDE AND CONQUER
     * -------------------------------------
     * Using the property: x^n = (x^(n/2))^2
     * 
     * If n is even: x^n = (x^(n/2))^2
     * If n is odd:  x^n = x * (x^(n/2))^2
     * 
     * Example: power(2, 8)
     * = (power(2, 4))^2
     * = ((power(2, 2))^2)^2
     * = (((power(2, 1))^2)^2)^2
     * = ((((2 * power(2, 0))^2)^2)^2)
     * = ((((2 * 1)^2)^2)^2)
     * = (((4)^2)^2)
     * = (16)^2
     * = 256
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public static int powerOptimized(int x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        
        // Recursive case: divide and conquer
        int halfPower = powerOptimized(x, n / 2);
        
        if (n % 2 == 0) {
            // Even power: x^n = (x^(n/2))^2
            return halfPower * halfPower;
        } else {
            // Odd power: x^n = x * (x^(n/2))^2
            return x * halfPower * halfPower;
        }
    }
    
    
    // ========================================================================
    // EXAMPLE 3: SUM OF N NATURAL NUMBERS
    // ========================================================================
    /**
     * Sum of first n natural numbers: 1 + 2 + 3 + ... + n
     * 
     * Recurrence Relation:
     * sum(n) = n + sum(n-1)
     * Base Case: sum(0) = 0
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int sumN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumN(n - 1);
    }
    
    
    // ========================================================================
    // EXAMPLE 4: PRINT NUMBERS (UNDERSTANDING CALL STACK)
    // ========================================================================
    /**
     * Print numbers 1 to n - shows how call stack works
     */
    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        // First make recursive call (go deeper)
        printIncreasing(n - 1);
        // Then print (while returning)
        System.out.print(n + " ");
    }
    
    /**
     * Print numbers n to 1 - different order
     */
    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        // First print (while going deeper)
        System.out.print(n + " ");
        // Then make recursive call
        printDecreasing(n - 1);
    }
    
    
    // ========================================================================
    // EXAMPLE 5: FIBONACCI NUMBER (nth)
    // ========================================================================
    /**
     * FIBONACCI SEQUENCE:
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
     * 
     * Recurrence Relation:
     * fib(n) = fib(n-1) + fib(n-2)
     * Base Cases: fib(0) = 0, fib(1) = 1
     * 
     * WARNING: This is inefficient! Explained more in Part 2
     * 
     * Time Complexity: O(2^n) - exponential!
     * Space Complexity: O(n)
     */
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    
    // ========================================================================
    // PRACTICE PROBLEMS FOR YOU TO SOLVE
    // ========================================================================
    
    /**
     * PRACTICE 1: Sum of Digits
     * --------------------------
     * Write a recursive function to find sum of digits of a number.
     * Example: sumOfDigits(1234) should return 1+2+3+4 = 10
     * 
     * Hint: 
     * - Base case: when number becomes 0
     * - Recursive case: last digit + sum of remaining digits
     * - Use % 10 to get last digit, / 10 to remove it
     */
    public static int sumOfDigits(int n) {
        // TODO: Implement this
        return 0;
    }
    
    /**
     * PRACTICE 2: Count Digits
     * -------------------------
     * Write a recursive function to count digits in a number.
     * Example: countDigits(12345) should return 5
     * 
     * Hint:
     * - Base case: when n becomes 0
     * - Recursive case: 1 + count of remaining digits
     */
    public static int countDigits(int n) {
        // TODO: Implement this
        return 0;
    }
    
    /**
     * PRACTICE 3: Product of Array Elements
     * --------------------------------------
     * Write a recursive function to find product of all elements in array.
     * Example: product([2, 3, 4]) should return 24
     * 
     * Hint:
     * - Base case: when index reaches array length
     * - Recursive case: arr[index] * product of rest
     */
    public static int productArray(int[] arr, int index) {
        // TODO: Implement this
        return 0;
    }
    
    /**
     * PRACTICE 4: GCD (Greatest Common Divisor)
     * ------------------------------------------
     * Implement Euclidean algorithm recursively.
     * GCD(a, b) = GCD(b, a % b)
     * Base case: GCD(a, 0) = a
     * 
     * Example: GCD(48, 18) = 6
     */
    public static int gcd(int a, int b) {
        // TODO: Implement this
        return 0;
    }
    
    /**
     * PRACTICE 5: Check if Array is Sorted
     * -------------------------------------
     * Write a recursive function to check if array is sorted in ascending order.
     * Example: isSorted([1, 2, 3, 4]) should return true
     *          isSorted([1, 3, 2, 4]) should return false
     * 
     * Hint:
     * - Base case: when only 1 element left (always sorted)
     * - Recursive case: check current pair + check rest
     */
    public static boolean isSorted(int[] arr, int index) {
        // TODO: Implement this
        return false;
    }
    
    
    // ========================================================================
    // TEST CASES
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("=== RECURSION PART 1: FUNDAMENTAL CONCEPTS ===\n");
        
        // Test Factorial
        System.out.println("--- FACTORIAL ---");
        System.out.println("factorial(5) = " + factorial(5)); // Expected: 120
        System.out.println("factorial(0) = " + factorial(0)); // Expected: 1
        System.out.println("factorial(7) = " + factorial(7)); // Expected: 5040
        System.out.println();
        
        // Test Power
        System.out.println("--- POWER ---");
        System.out.println("power(2, 3) = " + power(2, 3)); // Expected: 8
        System.out.println("power(5, 0) = " + power(5, 0)); // Expected: 1
        System.out.println("power(3, 4) = " + power(3, 4)); // Expected: 81
        System.out.println();
        
        // Test Optimized Power
        System.out.println("--- OPTIMIZED POWER ---");
        System.out.println("powerOptimized(2, 10) = " + powerOptimized(2, 10)); // Expected: 1024
        System.out.println("powerOptimized(3, 5) = " + powerOptimized(3, 5));   // Expected: 243
        System.out.println();
        
        // Test Sum
        System.out.println("--- SUM OF N NUMBERS ---");
        System.out.println("sumN(5) = " + sumN(5)); // Expected: 15
        System.out.println("sumN(10) = " + sumN(10)); // Expected: 55
        System.out.println();
        
        // Test Print Functions
        System.out.println("--- PRINT FUNCTIONS ---");
        System.out.print("printIncreasing(5): ");
        printIncreasing(5); // Expected: 1 2 3 4 5
        System.out.println();
        System.out.print("printDecreasing(5): ");
        printDecreasing(5); // Expected: 5 4 3 2 1
        System.out.println("\n");
        
        // Test Fibonacci
        System.out.println("--- FIBONACCI ---");
        System.out.println("fibonacci(6) = " + fibonacci(6)); // Expected: 8
        System.out.println("fibonacci(8) = " + fibonacci(8)); // Expected: 21
        System.out.println();
        
        
        // ===== PRACTICE PROBLEMS TEST CASES =====
        System.out.println("\n=== PRACTICE PROBLEMS - UNCOMMENT AFTER IMPLEMENTATION ===\n");
        
        /*
        // Test Sum of Digits
        System.out.println("--- SUM OF DIGITS ---");
        System.out.println("sumOfDigits(1234) = " + sumOfDigits(1234)); // Expected: 10
        System.out.println("sumOfDigits(9999) = " + sumOfDigits(9999)); // Expected: 36
        System.out.println("sumOfDigits(0) = " + sumOfDigits(0));       // Expected: 0
        System.out.println();
        
        // Test Count Digits
        System.out.println("--- COUNT DIGITS ---");
        System.out.println("countDigits(12345) = " + countDigits(12345)); // Expected: 5
        System.out.println("countDigits(7) = " + countDigits(7));         // Expected: 1
        System.out.println("countDigits(1000) = " + countDigits(1000));   // Expected: 4
        System.out.println();
        
        // Test Product Array
        System.out.println("--- PRODUCT ARRAY ---");
        System.out.println("productArray([2,3,4]) = " + productArray(new int[]{2, 3, 4}, 0)); // Expected: 24
        System.out.println("productArray([1,2,3,4,5]) = " + productArray(new int[]{1,2,3,4,5}, 0)); // Expected: 120
        System.out.println();
        
        // Test GCD
        System.out.println("--- GCD ---");
        System.out.println("gcd(48, 18) = " + gcd(48, 18)); // Expected: 6
        System.out.println("gcd(100, 50) = " + gcd(100, 50)); // Expected: 50
        System.out.println("gcd(17, 19) = " + gcd(17, 19)); // Expected: 1
        System.out.println();
        
        // Test isSorted
        System.out.println("--- IS SORTED ---");
        System.out.println("isSorted([1,2,3,4]) = " + isSorted(new int[]{1,2,3,4}, 0)); // Expected: true
        System.out.println("isSorted([1,3,2,4]) = " + isSorted(new int[]{1,3,2,4}, 0)); // Expected: false
        System.out.println("isSorted([5]) = " + isSorted(new int[]{5}, 0)); // Expected: true
        */
    }
}
