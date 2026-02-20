import java.util.*;

// The first argument is the number of bits.
// You need to save all binary strings in the ArrayList passed as 4th argument.
// Don't print the strings.
// i is initially passed as 0.
// currStr is a char array to store the current string.

class Solve
{
    void generateAllStrings(int n, int i, char currStr[], ArrayList<String> strs)
    {
        // Write your code here





        
        
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Solve obj = new Solve();
        ArrayList<String> strs = new ArrayList<>();
        char[] currStr = new char[n];
        
        obj.generateAllStrings(n, 0, currStr, strs);
        
        for(String s : strs)
        {
            System.out.println(s);
        }
        
        sc.close();
    }
}
