import java.util.*;

class Solution {
    public int solve(int[] arr) {
        // Write your code here
        return 0;
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
