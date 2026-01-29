public class recursion {
    
   public static int permutaion(int n){

     if(n == 1 || n == 0){
        return 1;
     }


     return n * permutaion( n - 1);
   }

   
   public static int power(int n,int m){

     if( m == 0){
        return 1;
     }
     
     return n * power(n, m - 1);
   }


   public static int fib(int n){

     if (n <= 1) {  
            return n;
        }

     return fib(n - 1) + fib(n - 2);
   }

    

   

    public static void main(String[] args) {
        int n = 4;
        // System.out.println(permutaion(n));
        // System.out.println(power(n,3));  m
        for (int i = 0; i <= n; i++) {
          System.out.println(fib(i) + " ");
        }

       
    }
}
