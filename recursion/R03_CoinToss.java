/**
 * R03: Coin Toss Outcomes
 * ========================
 * 
 * Problem:
 * Given n coins, print all possible outcomes when you toss them.
 * Each coin can show Head (H) or Tail (T).
 * 
 * Examples:
 * 
 * Input: n = 1
 * Output: H, T  (2 outcomes)
 * 
 * Input: n = 2
 * Output: HH, HT, TH, TT  (4 outcomes)
 * 
 * Input: n = 3
 * Output: HHH, HHT, HTH, HTT, THH, THT, TTH, TTT  (8 outcomes)
 * 
 * Pattern:
 * For n coins, there are 2^n possible outcomes
 * 
 * Focus:
 * - Similar to subsequences (2 choices at each step)
 * - Building result string as you go
 * - Base case: when all coins are tossed
 * 
 * Hints:
 * - Base case: when n becomes 0, print the current outcome
 * - At each step, make 2 recursive calls: one for H, one for T
 * - Build the outcome string by appending H or T
 * 
 * Think about it:
 * For n=3:
 *                    ""
 *              /           \
 *             H             T
 *           /   \         /   \
 *         HH     HT      TH     TT
 *        / \    / \     / \    / \
 *      HHH HHT HTH HTT THH THT TTH TTT
 */

public class R03_CoinToss {

    /**
     * TODO: Implement this method
     * Print all possible outcomes of tossing n coins
     * 
     * @param n - number of coins remaining to toss
     * @param current - current outcome being built
     */
    public static void coinToss(int n, String current) {
     
        if(n == 0){
            System.out.println(current); 
            return;
        }
        
       
        coinToss(n - 1, current + "H");
        
    
        coinToss(n - 1, current + "T");
    }

    /**
     * TODO: Implement this method (BONUS)
     * Count total number of outcomes
     * 
     * @param n - number of coins
     * @return count of outcomes
     */
    public static int countCoinToss(int n) {
        // YOUR CODE HERE
        if(n == 0){
            return 1;
        }

        int includetail = countCoinToss(n -1 );
        int includehead = countCoinToss(n -1 );
        return includehead + includetail; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Coin Toss Outcomes ===\n");

        // Test Case 1: Single coin
        System.out.println("Test 1: Toss 1 coin");
        System.out.println("Expected: H, T (2 outcomes)");
        System.out.println("Your Output:");
        coinToss(1, "");
        System.out.println();

        // Test Case 2: Two coins
        System.out.println("Test 2: Toss 2 coins");
        System.out.println("Expected: HH, HT, TH, TT (4 outcomes)");
        System.out.println("Your Output:");
        coinToss(2, "");
        System.out.println();

        // Test Case 3: Three coins
        System.out.println("Test 3: Toss 3 coins");
        System.out.println("Expected: 8 outcomes");
        System.out.println("Your Output:");
        coinToss(3, "");
        System.out.println();

        // Test Case 4: Four coins
        System.out.println("Test 4: Toss 4 coins");
        System.out.println("Expected: 16 outcomes");
        System.out.println("Your Output:");
        coinToss(4, "");
        System.out.println();

        // BONUS: Test count function
        System.out.println("\n=== BONUS: Count Outcomes ===\n");
        System.out.println("Count for 2 coins: " + countCoinToss(2) + " (Expected: 4)");
        System.out.println("Count for 3 coins: " + countCoinToss(3) + " (Expected: 8)");
        System.out.println("Count for 5 coins: " + countCoinToss(5) + " (Expected: 32)");
    }
}
