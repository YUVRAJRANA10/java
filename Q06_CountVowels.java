/**
 * Problem 6: Voice Assistant – Vowel Counter (Count Vowels)
 * 
 * A voice assistant analyzes spoken text and needs to count how many vowels are present in a
 * sentence to calculate pronunciation accuracy.
 * It checks one character at a time and delegates the remaining analysis to itself.
 * 
 * Task: Count the number of vowels in a string using recursion.
 */
public class Q06_CountVowels {

    /**
     * TODO: Implement this method
     * Count the number of vowels in a string using recursion
     * Vowels: a, e, i, o, u (both lowercase and uppercase)
     * 
     * @param str - input string
     * @param index - current index to check
     * @return count of vowels in the string
     */

    public static int countVowels(String str, int index) {
        // YOUR CODE HERE

       if(index == str.length()){
          return 0;
       };

       char ch = str.charAt(index);

       if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){

           return 1 + countVowels(str, index + 1);

       }
       else{

           return countVowels(str, index + 1);

        }

    }

    // Helper method to check if a character is a vowel
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        System.out.println("=== Voice Assistant – Vowel Counter ===\n");

        // Test Case 1: Normal sentence
        String test1 = "Hello World";
        System.out.println("Test 1: String = \"Hello World\"");
        System.out.println("Expected: 3 (e, o, o)");
        System.out.println("Your Output: " + countVowels(test1, 0));
        System.out.println();

        // Test Case 2: All vowels
        String test2 = "aeiouAEIOU";
        System.out.println("Test 2: String = \"aeiouAEIOU\"");
        System.out.println("Expected: 10");
        System.out.println("Your Output: " + countVowels(test2, 0));
        System.out.println();

        // Test Case 3: No vowels
        String test3 = "rhythm";
        System.out.println("Test 3: String = \"rhythm\"");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + countVowels(test3, 0));
        System.out.println();

        // Test Case 4: Mixed case sentence
        String test4 = "Programming Is Fun";
        System.out.println("Test 4: String = \"Programming Is Fun\"");
        System.out.println("Expected: 5 (o, a, i, I, u)");
        System.out.println("Your Output: " + countVowels(test4, 0));
        System.out.println();

        // Test Case 5: Single vowel
        String test5 = "a";
        System.out.println("Test 5: String = \"a\"");
        System.out.println("Expected: 1");
        System.out.println("Your Output: " + countVowels(test5, 0));
        System.out.println();

        // Test Case 6: Empty string
        String test6 = "";
        System.out.println("Test 6: String = \"\" (empty)");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + countVowels(test6, 0));
        System.out.println();

        // Test Case 7: Numbers and special characters
        String test7 = "H3ll0 W0rld! @2025";
        System.out.println("Test 7: String = \"H3ll0 W0rld! @2025\"");
        System.out.println("Expected: 0");
        System.out.println("Your Output: " + countVowels(test7, 0));
        System.out.println();

        // Test Case 8: Long sentence
        String test8 = "The quick brown fox jumps over the lazy dog";
        System.out.println("Test 8: String = \"The quick brown fox jumps over the lazy dog\"");
        System.out.println("Expected: 11 (e, u, i, o, o, u, o, e, e, a, o)");
        System.out.println("Your Output: " + countVowels(test8, 0));
    }
}
