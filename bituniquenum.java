public class bituniquenum {
    public static void main(String[] args) {
       
        int k = 3;
        int result = 0;
        int nums[] = {6,6,6,3,1,1,1,4,4,4};
   for(int i = 0; i < 32; i++){

     int sum = 0;

for (int num : nums) {
    if(((num >> i) & 1) == 1){
sum+=1;
    }
}

sum %= k;



if(sum != 0){

    result |= (1 << i);
}





   }


System.out.println( result );
    }
}
