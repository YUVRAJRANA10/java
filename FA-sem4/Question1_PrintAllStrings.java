import java.util.*;

/*
 * Question 1 — Print all strings of n-bits
 * 
 * Problem Statement:
 * Given n bits we can generate 2^n different binary strings.
 * For example, with 3 bits: 000, 001, 010, 011, 100, 101, 110, 111
 * You need to write a function to find all strings for a given number of bits.
 * 
 * Input Format:
 * First line contains an integer denoting the number of bits.
 * 
 * Output Format:
 * Print all strings for given number of bits in ascending order.
 * 
 * Sample Input:
 * 3
 * 
 * Sample Output:
 * 000
 * 001
 * 010
 * 011
 * 100
 * 101
 * 110
 * 111
 */

// The first argument is the number of bits.
// You need to save all binary strings in the ArrayList passed as 4th argument.
// Don't print the strings.
// i is initially passed as 0.
// currStr is a char array to store the current string.

class Solve {
    void generateAllStrings(int n, int i, char currStr[], ArrayList<String> strs) {
        // Write your code here
      int index = i;
        if (i == n) {
            strs.add(new String(currStr));
            
            return;
        }

        
        currStr[index] = '0';
     
        generateAllStrings(n, i+1, currStr, strs);

        currStr[index] = '1';
        generateAllStrings(n, i+1, currStr, strs);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Solve obj = new Solve();
        ArrayList<String> strs = new ArrayList<>();
        char[] currStr = new char[n];

        obj.generateAllStrings(n, 0, currStr, strs);

        for (String s : strs) {
            System.out.println(s);
        }

        sc.close();
    }
}
