public class practic {
    public static void main(String[] args) {
        

         try {
        
            int arr[] = new int[3];
          arr[180] = 44;
          int a = 10/0;
            

         } catch (ArithmeticException e) {

            // TODO: handle exception 
            System.out.println("Exception occured "+ e.getMessage());

         }
         catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Exception occuredd " + e.getMessage());

         }
         finally {
            System.out.println("Inside finally block - ALWAYS executes!");
        }











int age = 27;

                try {
            if (age < 18) {
                // Explicitly throwing an exception
                throw new ArithmeticException("Age must be 18 or above!");
            }
            System.out.println("Valid age: " + age);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
