/**
 * Problem 5: Spam Filter in Email System (Remove Character)
 * 
 * An email filter removes all special symbols (like #) from incoming messages before delivery.
 * The system reads one character, decides whether to keep it or discard it, and then applies the
 * same rule to the rest of the message.
 * 
 * Task: Using recursion, remove a given character from the string.
 */
public class Q05_RemoveCharacter {

    /**
     * TODO: Implement this method
     * Remove all occurrences of a character from string using recursion
     * 
     * @param str - input string
     * @param ch - character to remove
     * @return string with all occurrences of ch removed
     */
    public static String removeChar(String str, char ch) {
        // YOUR CODE HERE
        return ""; // placeholder
    }

    public static void main(String[] args) {
        System.out.println("=== Spam Filter in Email System (Remove Character) ===\n");

        // Test Case 1: Remove # from string
        String test1 = "Hello#World#Test#";
        System.out.println("Test 1: String = \"Hello#World#Test#\", Remove = '#'");
        System.out.println("Expected: HelloWorldTest");
        System.out.println("Your Output: " + removeChar(test1, '#'));
        System.out.println();

        // Test Case 2: Remove 'a' from string
        String test2 = "banana";
        System.out.println("Test 2: String = \"banana\", Remove = 'a'");
        System.out.println("Expected: bnn");
        System.out.println("Your Output: " + removeChar(test2, 'a'));
        System.out.println();

        // Test Case 3: Character not present
        String test3 = "Hello World";
        System.out.println("Test 3: String = \"Hello World\", Remove = 'x'");
        System.out.println("Expected: Hello World");
        System.out.println("Your Output: " + removeChar(test3, 'x'));
        System.out.println();

        // Test Case 4: Remove spaces
        String test4 = "I am a student";
        System.out.println("Test 4: String = \"I am a student\", Remove = ' '");
        System.out.println("Expected: Iamastudent");
        System.out.println("Your Output: " + removeChar(test4, ' '));
        System.out.println();

        // Test Case 5: All characters are same
        String test5 = "aaaa";
        System.out.println("Test 5: String = \"aaaa\", Remove = 'a'");
        System.out.println("Expected: (empty string)");
        System.out.println("Your Output: \"" + removeChar(test5, 'a') + "\"");
        System.out.println();

        // Test Case 6: Single character string
        String test6 = "X";
        System.out.println("Test 6: String = \"X\", Remove = 'X'");
        System.out.println("Expected: (empty string)");
        System.out.println("Your Output: \"" + removeChar(test6, 'X') + "\"");
        System.out.println();

        // Test Case 7: Email with special symbols
        String test7 = "user@email#$%spam#filter";
        System.out.println("Test 7: String = \"user@email#$%spam#filter\", Remove = '#'");
        System.out.println("Expected: user@email$%spamfilter");
        System.out.println("Your Output: " + removeChar(test7, '#'));
    }
}
