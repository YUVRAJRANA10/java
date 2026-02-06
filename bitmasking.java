public class bitmasking {
    
// find the unique num from the nums array where maximumu duplicate number it contains is two


    public static void main(String[] args) {
        
        int a = 9;
        int b = 10;


        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~1);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.bitCount(b));
        
        int nums[] = {2,2,9,3,1,3,1};
        int ans = 0;
        for(int num: nums){

          ans^= num;

        }

        System.out.println(ans);  
       

        

    }
}
