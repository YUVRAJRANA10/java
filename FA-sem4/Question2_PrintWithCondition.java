import java.util.*;

/*
 * Question 2 — Print all string of n-bits with condition
 * 
 * Problem Statement:
 * Given n bits we can generate 2^n different strings.
 * You need to write a function to find all strings for a given number of bits
 * with the condition that the given bit position is always 1.
 * 
 * Bit numbering rule:
 * 👉 Starting from MSB as bit 0
 * 
 * Example:
 * With 3 bits:
 * Index: 0 1 2
 * Bits : _ _ _
 * 
 * If bit number 1 must always be set (1), then:
 * Strings like: 000, 001, 100, 101 become invalid.
 * Only valid strings: 010, 011, 110, 111
 * 
 * Input Format:
 * First line contains an integer denoting number of bits.
 * Second line contains an integer denoting the bit position to be set.
 * 
 * Output Format:
 * Print all strings for given number of bits in ascending order.
 * 
 * Sample Input:
 * 3
 * 1
 * 
 * Sample Output:
 * 010
 * 011
 * 110
 * 111
 */

// The first argument is the number of bits.
// You need to save all binary strings in the ArrayList passed as 5th argument.
// Don't print the strings.
// i is initially passed as 0.
// k is the bit position to be set always.
// Bit numbering starts from MSB as bit 0.
// currStr is a char array to store the current string.

class Solve
{
    void generateAllStrings(int n, int i, int k, char currStr[], ArrayList<String> strs)
    {
        // Write your code here


        int index = i;
        if (i == n ) {
          
            strs.add(new String(currStr));
            
            return;
        }
        
    if (i == k) {
    // Position k MUST be '1', no other option
    currStr[i] = '1';
    generateAllStrings(n, i+1, k, currStr, strs);
} else {
    // For other positions, try both '0' and '1'
    currStr[i] = '0';
    generateAllStrings(n, i+1, k, currStr, strs);
    
    currStr[i] = '1';
    generateAllStrings(n, i+1, k, currStr, strs);
}
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Solve obj = new Solve();
        ArrayList<String> strs = new ArrayList<>();
        char[] currStr = new char[n];
        
        obj.generateAllStrings(n, 0, k, currStr, strs);
        
        for(String s : strs)
        {
            System.out.println(s);
        }
        
        sc.close();
    }
}
