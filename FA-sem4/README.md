# FA Sem-4 Questions

## Question 1 — Print all strings of n-bits

**Problem Statement:**
Given n bits we can generate 2^n different binary strings.

**Example:** With 3 bits: 000, 001, 010, 011, 100, 101, 110, 111

**Input Format:**
- First line contains an integer denoting the number of bits.

**Output Format:**
- Print all strings for given number of bits in ascending order.

**Sample Input:**
```
3
```

**Sample Output:**
```
000
001
010
011
100
101
110
111
```

---

## Question 2 — Print all string of n-bits with condition

**Problem Statement:**
Given n bits we can generate 2^n different strings.
Find all strings for a given number of bits with the condition that the given bit position is always 1.

**Bit numbering rule:** Starting from MSB as bit 0

**Example:** With 3 bits:
```
Index: 0 1 2
Bits : _ _ _
```

If bit number 1 must always be set (1), then:
- Invalid: 000, 001, 100, 101
- Valid: 010, 011, 110, 111

**Input Format:**
- First line contains number of bits
- Second line contains bit position to be set

**Output Format:**
- Print all strings in ascending order

**Sample Input:**
```
3
1
```

**Sample Output:**
```
010
011
110
111
```

---

## Question 3 — Base 6 (Transformation + Inversion Count)

**Problem Statement:**
1. Convert each decimal number A[i] into Base-6 representation
2. Calculate the sum of digits of this Base-6 number → C[i]
3. Count total inversions in sequence C

**Inversion Definition:**
A pair (i, j) where i < j AND C[i] > C[j]

**Input Format:**
- First line: N (number of elements)
- Second line: N integers separated by commas

**Output Format:**
- Single integer representing number of inversions

**Constraints:**
- N ≤ 50
- Integers ≤ 10^7

**Sample Input 1:**
```
5
55,53,88,27,33
```

**Sample Output 1:**
```
2
```

**Sample Input 2:**
```
8
120,21,47,64,72,35,18,98
```

**Sample Output 2:**
```
11
```
