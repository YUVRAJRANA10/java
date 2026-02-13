public class Pwer {
    
    public static void printPowerSet(int[] arr) {
        int n = arr.length;  // n = 3 for {1, 2, 3}
        
        // First loop: i goes from 0 to (2^n - 1)
        // (1 << n) means 2^n (left shift 1 by n positions)
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            
            // Second loop: check each bit position from 0 to n-1
            for (int j = 0; j < n; j++) {
                // Check if jth bit of i is set (is 1)
                if ((i & (1 << j)) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            
            System.out.println("}");
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Power Set of {1, 2, 3}:");
        printPowerSet(arr);
    }
}
