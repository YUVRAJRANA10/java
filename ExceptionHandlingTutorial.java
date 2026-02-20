/**
 * Exception Handling in Java - Complete Tutorial
 * Topics: try-catch, throw, throws, finally, custom exceptions
 */

public class ExceptionHandlingTutorial {
    
    // ==============================================
    // 1. BASIC TRY-CATCH
    // ==============================================
    
    /**
     * Try-catch is used to handle exceptions (errors) that might occur
     * - try: contains code that might throw an exception
     * - catch: handles the exception if it occurs
     */
    public static void basicTryCatch() {
        System.out.println("\n=== BASIC TRY-CATCH ===");
        
        try {
            int result = 10 / 0;  // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception message: " + e.getMessage());
        }
        
        System.out.println("Program continues after exception handling");
    }
    
    // ==============================================
    // 2. MULTIPLE CATCH BLOCKS
    // ==============================================
    
    /**
     * You can have multiple catch blocks to handle different exception types
     * More specific exceptions should be caught first
     */
    public static void multipleCatchBlocks() {
        System.out.println("\n=== MULTIPLE CATCH BLOCKS ===");
        
        try {
            String str = null;
            System.out.println(str.length());  // NullPointerException
            
            int[] arr = new int[5];
            arr[10] = 50;  // ArrayIndexOutOfBoundsException
            
        } catch (NullPointerException e) {
            
            System.out.println("Error: Null pointer - " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds - " + e.getMessage());
        } catch (Exception e) {
            // Generic catch for any other exception
            System.out.println("Error: Something went wrong - " + e.getMessage());
        }
    }
    
    // ==============================================
    // 3. FINALLY BLOCK
    // ==============================================
    
    /**
     * Finally block ALWAYS executes, whether exception occurs or not
     * Used for cleanup operations (closing files, connections, etc.)
     */
    public static void finallyBlock() {
        System.out.println("\n=== FINALLY BLOCK ===");
        
        try {
            System.out.println("Inside try block");
            int result = 10 / 2;  // No exception
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside finally block - ALWAYS executes!");
        }
        
        // Example with exception
        try {
            System.out.println("\nTrying division by zero...");
            int result = 10 / 0;  // Exception occurs
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally executes even after exception!");
        }
    }
    
    // ==============================================
    // 4. THROW KEYWORD
    // ==============================================
    
    /**
     * 'throw' is used to explicitly throw an exception
     * You create and throw an exception object
     */
    public static void throwExample(int age) {
        System.out.println("\n=== THROW KEYWORD ===");
        
        try {
            if (age < 18) {
                // Explicitly throwing an exception
                throw new IllegalArgumentException("Age must be 18 or above!");
            }
            System.out.println("Valid age: " + age);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // ==============================================
    // 5. THROWS KEYWORD
    // ==============================================
    
    /**
     * 'throws' is used in method signature to declare that method might throw exceptions
     * Caller of the method must handle these exceptions
     */
    
    // This method declares it might throw ArithmeticException
    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero not allowed");
        }
        return a / b;
    }
    
    // This method can throw multiple exception types
    public static void readFile(String filename) throws java.io.IOException, 
                                                         java.io.FileNotFoundException {
        // Method implementation that might throw these exceptions
        throw new java.io.FileNotFoundException("File not found: " + filename);
    }
    
    public static void throwsExample() {
        System.out.println("\n=== THROWS KEYWORD ===");
        
        // Caller must handle the exception declared with 'throws'
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception from divide(): " + e.getMessage());
        }
        
        try {
            readFile("test.txt");
        } catch (java.io.IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
    
    // ==============================================
    // 6. CUSTOM EXCEPTIONS
    // ==============================================
    
    /**
     * You can create your own exception classes
     */
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }
    
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age " + age + " is not valid!");
        }
        System.out.println("Valid age: " + age);
    }
    
    public static void customExceptionExample() {
        System.out.println("\n=== CUSTOM EXCEPTIONS ===");
        
        try {
            validateAge(25);   // Valid
            validateAge(200);  // Invalid - throws exception
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }
    
    // ==============================================
    // 7. CHECKED vs UNCHECKED EXCEPTIONS
    // ==============================================
    
    /**
     * CHECKED EXCEPTIONS:
     * - Must be declared with 'throws' or handled with try-catch
     * - Compiler forces you to handle them
     * - Examples: IOException, SQLException, FileNotFoundException
     * 
     * UNCHECKED EXCEPTIONS (Runtime Exceptions):
     * - Not required to be declared or caught
     * - Usually programming errors
     * - Examples: NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException
     */
    
    // Checked exception - MUST use throws or try-catch
    public static void checkedExceptionExample() throws Exception {
        throw new Exception("This is a checked exception");
    }
    
    // Unchecked exception - no need for throws declaration
    public static void uncheckedExceptionExample() {
        throw new RuntimeException("This is an unchecked exception");
    }
    

    // ==============================================
    // 8. PRACTICAL EXAMPLES
    // ==============================================
    
    
    public static void practicalExample1_BankAccount() {
        System.out.println("\n=== PRACTICAL EXAMPLE: Bank Account ===");
        
        class InsufficientFundsException extends Exception {
            public InsufficientFundsException(String msg) {
                super(msg);
            }
        }
        
        class BankAccount {
            private double balance;
            
            public BankAccount(double initialBalance) {
                this.balance = initialBalance;
            }
            
            public void withdraw(double amount) throws InsufficientFundsException {
                if (amount > balance) {
                    throw new InsufficientFundsException(
                        "Cannot withdraw $" + amount + ". Available balance: $" + balance
                    );
                }
                balance -= amount;
                System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
            }
            
            public double getBalance() {
                return balance;
            }
        }
        
        BankAccount account = new BankAccount(1000);
        
        try {
            account.withdraw(500);   // Success
            account.withdraw(700);   // Will throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            System.out.println("Final balance: $" + account.getBalance());
        }
    }
    
    public static void practicalExample2_ArrayAccess() {
        System.out.println("\n=== PRACTICAL EXAMPLE: Safe Array Access ===");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Unsafe array access
        try {
            System.out.println("Element at index 2: " + numbers[2]);
            System.out.println("Element at index 10: " + numbers[10]);  // Error!
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index");
        }
        
        // Safe array access method
        int value = safeArrayAccess(numbers, 10);
        System.out.println("Safe access returned: " + value);
    }
    
    public static int safeArrayAccess(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is out of bounds. Returning -1");
            return -1;
        }
    }
    
    // ==============================================
    // KEY DIFFERENCES: throw vs throws
    // ==============================================
    
    /**
     * THROW:
     * - Used to explicitly throw an exception
     * - Used inside method body
     * - Followed by an exception object
     * - Example: throw new Exception("error");
     * 
     * THROWS:
     * - Used to declare exceptions
     * - Used in method signature
     * - Followed by exception class name(s)
     * - Example: public void method() throws IOException
     */
    
    // ==============================================
    // MAIN METHOD - RUN ALL EXAMPLES
    // ==============================================
    
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("EXCEPTION HANDLING TUTORIAL");
        System.out.println("====================================");
        
        // Run all examples
        basicTryCatch();
        multipleCatchBlocks();
        finallyBlock();
        throwExample(15);
        throwExample(20);
        throwsExample();
        customExceptionExample();
        practicalExample1_BankAccount();
        practicalExample2_ArrayAccess();
        
        System.out.println("\n====================================");
        System.out.println("TUTORIAL COMPLETE!");
        System.out.println("====================================");
        
        // Summary
        System.out.println("\n*** QUICK REFERENCE ***");
        System.out.println("1. try-catch: Handle exceptions that might occur");
        System.out.println("2. finally: Code that always executes");
        System.out.println("3. throw: Explicitly throw an exception");
        System.out.println("4. throws: Declare that method might throw exceptions");
        System.out.println("5. Custom exceptions: Create your own exception classes");
    }
}
