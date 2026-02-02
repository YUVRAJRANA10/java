# Recursion Learning Path 🚀

A comprehensive guide to mastering recursion in Java, covering fundamental concepts to advanced backtracking problems.

## 📚 Learning Structure

### Part 1: Fundamental Concepts
**File:** `Part1_FundamentalConcepts.java`

**Topics Covered:**
- What is Recursion?
- Call Stack Visualization
- Recurrence Relations
- Base Case & Recursive Case

**Examples with Full Solutions:**
- ✅ Factorial (with iterative comparison)
- ✅ Power Function (both O(n) and O(log n) versions)
- ✅ Sum of N Natural Numbers
- ✅ Print Numbers (understanding call stack order)
- ✅ Fibonacci (basic version)

**Practice Problems (For You to Solve):**
- 📝 Sum of Digits
- 📝 Count Digits
- 📝 Product of Array Elements
- 📝 GCD (Greatest Common Divisor)
- 📝 Check if Array is Sorted

---

### Part 2: Advanced Recursion I
**File:** `Part2_AdvancedRecursion1.java`

**Topics Covered:**
- Multiple Recursive Calls (Branching)
- Decision Trees
- Backtracking Basics
- Memoization (Dynamic Programming Introduction)

**Examples with Full Solutions:**
- ✅ Fibonacci (with memoization - O(2^n) to O(n) optimization!)
- ✅ Subsequences (all subsets of a string)
- ✅ Coin Toss (all possible outcomes)
- ✅ Board Path (climbing stairs with 1, 2, or 3 steps)

**Practice Problems (For You to Solve):**
- 📝 Print All Binary Strings
- 📝 Subset Sum
- 📝 Dice Throw
- 📝 Climbing Stairs (1 or 2 steps)
- 📝 Generate Valid Parentheses

---

### Part 3: Advanced Recursion II
**File:** `Part3_AdvancedRecursion2.java`

**Topics Covered:**
- Complex Backtracking
- State Management
- Multiple Base Cases
- Mathematical Recursion

**Examples with Full Solutions:**
- ✅ Permutations (two different approaches)
- ✅ Tower of Hanoi (classic puzzle with visualization)
- ✅ Lexicographical Counting
- ✅ **BONUS:** N-Queens Problem (preview of advanced backtracking)

**Practice Problems (For You to Solve):**
- 📝 Unique Permutations (handling duplicates)
- 📝 Count Hanoi Moves
- 📝 Lexicographical Range
- 📝 Josephus Problem
- 📝 Rat in a Maze

---

## 🎯 How to Use This Learning Path

### Step 1: Read & Understand Examples
Each file has **detailed explanations** including:
- Concept explanation in plain English
- Recurrence relation (mathematical formula)
- Decision tree/call stack visualization
- Time & Space complexity analysis
- Complete working code with comments

### Step 2: Run the Examples
```bash
# Compile and run each part
javac Part1_FundamentalConcepts.java
java Part1_FundamentalConcepts

javac Part2_AdvancedRecursion1.java
java Part2_AdvancedRecursion1

javac Part3_AdvancedRecursion2.java
java Part3_AdvancedRecursion2
```

### Step 3: Trace the Execution
- Use a pen and paper to trace recursive calls
- Draw the call stack for small inputs
- Understand when base cases are hit
- See how values are returned and combined

### Step 4: Solve Practice Problems
- Each practice problem has hints
- Test cases are provided (commented out)
- Uncomment test cases after you implement
- Verify your solution matches expected output

### Step 5: Create Your Own Problems
- Modify existing problems
- Create variations (different constraints)
- Challenge yourself with edge cases

---

## 📊 Complexity Reference

| Problem Type | Time Complexity | Space Complexity |
|-------------|-----------------|------------------|
| Linear Recursion (factorial, sum) | O(n) | O(n) |
| Binary Recursion (fibonacci naive) | O(2^n) | O(n) |
| Fibonacci with Memoization | O(n) | O(n) |
| Power (optimized) | O(log n) | O(log n) |
| Subsequences | O(2^n) | O(n) |
| Permutations | O(n! × n) | O(n) |
| Tower of Hanoi | O(2^n) | O(n) |

---

## 🧠 Key Recursion Patterns

### 1. **Single Branch Recursion**
```java
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

### 2. **Multiple Branch Recursion**
```java
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);
}
```

### 3. **Include/Exclude Pattern**
```java
void subsequences(String str, String current, int index) {
    if (index == str.length()) {
        print(current);
        return;
    }
    subsequences(str, current + str.charAt(index), index + 1); // Include
    subsequences(str, current, index + 1); // Exclude
}
```

### 4. **Backtracking Pattern**
```java
void permute(String str, int index) {
    if (index == str.length()) {
        print(str);
        return;
    }
    for (int i = index; i < str.length(); i++) {
        swap(str, index, i);  // Make choice
        permute(str, index + 1);  // Recurse
        swap(str, index, i);  // Undo choice (BACKTRACK)
    }
}
```

---

## ✅ Progress Checklist

### Part 1 - Fundamentals
- [ ] Understand call stack concept
- [ ] Master factorial implementation
- [ ] Complete all 5 practice problems
- [ ] All test cases pass

### Part 2 - Advanced I
- [ ] Understand decision trees
- [ ] Master include/exclude pattern
- [ ] Learn memoization technique
- [ ] Complete all 5 practice problems
- [ ] All test cases pass

### Part 3 - Advanced II
- [ ] Master backtracking technique
- [ ] Understand Tower of Hanoi logic
- [ ] Solve permutations problem
- [ ] Complete all 5 practice problems
- [ ] All test cases pass

---

## 💡 Tips for Success

1. **Start Small:** Always test with small inputs (n=2, n=3) first
2. **Draw It Out:** Visualize the recursion tree on paper
3. **Trust the Recursion:** Assume smaller problems are solved correctly
4. **Check Base Cases:** These prevent infinite recursion
5. **Trace Carefully:** Follow execution step-by-step for understanding
6. **Memoize When Needed:** If you see repeated calculations, use memoization
7. **Practice Daily:** Solve at least one recursion problem daily

---

## 🎓 Learning Outcomes

After completing this course, you will be able to:
- ✅ Identify when recursion is the right approach
- ✅ Write base cases and recursive cases correctly
- ✅ Optimize recursive solutions using memoization
- ✅ Solve complex backtracking problems
- ✅ Analyze time and space complexity of recursive algorithms
- ✅ Debug recursive code effectively
- ✅ Apply recursion to real-world problems

---

## 📝 Next Steps

After mastering these concepts:
1. Study **Dynamic Programming** (builds on memoization)
2. Explore **Graph Algorithms** (DFS uses recursion)
3. Practice on platforms like LeetCode, HackerRank
4. Solve contest problems involving recursion

---

## 🤝 How to Practice

1. **Read** the explanation and example
2. **Run** the code and observe output
3. **Trace** the execution manually
4. **Implement** the practice problem yourself
5. **Test** with the provided test cases
6. **Debug** if tests fail
7. **Optimize** after getting correct solution
8. **Repeat** for next problem

---

**Good luck with your recursion journey! 🚀**

Remember: *Recursion is not about understanding recursion, it's about understanding recursion.* 😄

---

**Created:** February 2, 2026  
**Topics:** Recursion, Backtracking, Dynamic Programming  
**Language:** Java  
**Difficulty:** Beginner to Advanced
