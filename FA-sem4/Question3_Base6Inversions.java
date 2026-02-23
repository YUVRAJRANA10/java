import java.util.*;

/*
 * Question 3 — Base 6 (Transformation + Inversion Count)
 * 
 * Problem Statement:
 * You are given a sequence of N integers.
 * 
 * Your task:
 * Step 1 — Convert to Base-6
 *   Convert each decimal number A[i] into its Base-6 (Senary) representation.
 * 
 * Step 2 — Calculate Digit Sum
 *   Calculate the sum of digits of this Base-6 number.
 *   Call this value C[i].
 * 
 * After generating the new sequence C, count the total number of inversions.
 * 
 * Inversion Definition:
 * An inversion is a pair of indices (i, j) such that:
 * i < j  AND  C[i] > C[j]
 * 
 * Input Format:
 * First line contains a single integer N.
 * Second line contains N integers separated by commas.
 * Example: 10,20,30
 * 
 * Output Format:
 * Print a single integer representing the number of inversions in the derived sequence.
 * 
 * Constraints:
 * N ≤ 50
 * Integers ≤ 10^7
 * 
 * Sample Input 1:
 * 5
 * 55,53,88,27,33
 * 
 * Sample Output 1:
 * 2
 * 
 * Sample Input 2:
 * 8
 * 120,21,47,64,72,35,18,98
 * 
 * Sample Output 2:
 * 11
 */

class Solution {
    public int solve(int[] arr) {
        // Write your code here

        int[] C =new int[arr.length];
for(int i = 0; i < arr.length; i++){
 int num = arr[i];
 int sum = 0;
    while (num > 0) {
        int rem = num % 6;
        sum = sum + rem;
        num = num /6;
        
    }

    C[i] = sum;

}

int count = 0;

for (int i = 0; i < C.length; i++) {
    for (int j = i+1; j < C.length; j++) {
        if(C[i] > C[j]){
            count++;
        }
    }
}


        return count;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        
        String[] input = sc.nextLine().split(",");
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        Solution obj = new Solution();
        int result = obj.solve(arr);
        
        System.out.println(result);
        
        sc.close();
    }
}
