/**
 * ═══════════════════════════════════════════════════════════════════════════
 * MERGE SORT vs QUICK SORT - COMPLETE COMPARISON & VISUAL GUIDE
 * ═══════════════════════════════════════════════════════════════════════════
 */

/*

╔════════════════════════════════════════════════════════════════════════════╗
║                        QUICK VISUAL COMPARISON                            ║
╚════════════════════════════════════════════════════════════════════════════╝

┌─────────────────────────────────────────────────────────────────────────┐
│ MERGE SORT - "Divide into halves, then merge"                          │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                         │
│                     [5, 2, 4, 1, 3, 6]                                 │
│                            ↓                                            │
│                     DIVIDE (Split equally)                            │
│                            ↓                                            │
│              [5, 2, 4]          [1, 3, 6]                            │
│              /    |  \          /   |   \                            │
│           [5]   [2]   [4]    [1]  [3]  [6]                          │
│             ↓     ↓     ↓      ↓    ↓    ↓                            │
│                  MERGE (Combine in sorted order)                      │
│             ↓     ↓     ↓      ↓    ↓    ↓                            │
│          [2,5]   [4]  ...   [1,3]  [6]                              │
│              \    |  /          |   /                                │
│              [2, 4, 5]      [1, 3, 6]                               │
│                        \    /                                        │
│              [1, 2, 3, 4, 5, 6] ✓                                   │
│                                                                         │
│ Approach: Even division, guaranteed splits                             │
│ How it works: Splits equally, then intelligently merges               │
└─────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────┐
│ QUICK SORT - "Choose pivot, partition, then recurse"                  │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                         │
│           [5, 2, 4, 1, 3, 6]                                          │
│           ↓ Choose pivot (6)                                           │
│        Partition:                                                       │
│        Small → [5, 2, 4, 1, 3]  |  Pivot  |  Large                  │
│                                    [6]                                  │
│        No elements > 6, so just go left                               │
│                                                                         │
│        [5, 2, 4, 1, 3] → Choose pivot (3)                            │
│        [2, 1] | [3] | [5, 4]                                         │
│                                                                         │
│        Continue recursing...                                           │
│        [1, 2, 3, 4, 5, 6] ✓                                           │
│                                                                         │
│ Approach: Uneven division based on pivot                              │
│ How it works: Picks a pivot, partitions around it, then recurses    │
└─────────────────────────────────────────────────────────────────────────┘


╔════════════════════════════════════════════════════════════════════════════╗
║                    DETAILED CHARACTERISTIC TABLE                          ║
╚════════════════════════════════════════════════════════════════════════════╝

┌──────────────────┬──────────────────────────┬──────────────────────────┐
│   CHARACTERISTIC │      MERGE SORT          │      QUICK SORT          │
├──────────────────┼──────────────────────────┼──────────────────────────┤
│ Best Case        │ O(n log n)               │ O(n log n)               │
│ Average Case     │ O(n log n)               │ O(n log n)               │
│ Worst Case       │ O(n log n)               │ O(n²) ← Bad!             │
│ Space Complexity │ O(n) ← Need temp arrays  │ O(log n) ← Just stack   │
│ Stable?          │ YES ✓                    │ NO ✗                     │
│ In-Place?        │ NO ✗                     │ YES ✓                    │
│ Divide Strategy  │ Equal halves             │ Based on pivot           │
│ Best For         │ Linked lists, guaranteed │ Arrays, general purpose  │
│                  │ O(n log n)               │ sorting                  │
└──────────────────┴──────────────────────────┴──────────────────────────┘


╔════════════════════════════════════════════════════════════════════════════╗
║                        WHY EACH APPROACH?                                 ║
╚════════════════════════════════════════════════════════════════════════════╝

WHEN TO USE MERGE SORT:
───────────────────────

✓ When you NEED guaranteed O(n log n) performance
  (e.g., real-time systems where worst case matters)

✓ When sorting LINKED LISTS
  (Merge sort works better on linked lists than Quick Sort)

✓ When you NEED STABLE sorting
  (Equal elements must keep their relative order)

✓ When external sorting is needed (sorting data that doesn't fit in memory)
  (Merge sort naturally works with sequential I/O)

✓ When space is NOT a concern
  (You have plenty of RAM, predictable performance matters more)

Example: Sorting user records by name where insertion order matters

---

WHEN TO USE QUICK SORT:
──────────────────────

✓ When you want FASTER average case performance
  (Typically faster in practice than Merge Sort)

✓ When SPACE is LIMITED
  (Mobile devices, embedded systems)

✓ When you're sorting IN-MEMORY arrays
  (Cache-friendly, locality of reference)

✓ When stable sort is NOT required
  (Most real-world sorting doesn't care about stability)

✓ When average O(n log n) is acceptable
  (Most data won't hit worst case)

Example: Sorting pixels in an image, sorting transaction amounts


╔════════════════════════════════════════════════════════════════════════════╗
║                    STEP-BY-STEP CODE FLOW                                 ║
╚════════════════════════════════════════════════════════════════════════════╝

MERGE SORT FLOW:
───────────────

1. mergeSort([5, 2, 4, 1], 0, 3)
2.   if left < right? (0 < 3) YES
3.   mid = 1
4.   mergeSort([5, 2], 0, 1)           ← Sort left half
5.     if 0 < 1? YES
6.     mid = 0
7.     mergeSort([5], 0, 0)            ← Single element, return
8.     mergeSort([2], 1, 1)            ← Single element, return
9.     merge([5], [2]) → [2, 5]        ← Merge! (KEY STEP)
10.  mergeSort([4, 1], 2, 3)          ← Sort right half
11.    ...similar process...
12.    merge([4], [1]) → [1, 4]
13.  merge([2, 5], [1, 4]) → [1, 2, 4, 5]  ← Final merge!


QUICK SORT FLOW:
────────────────

1. quickSort([5, 2, 4, 1], 0, 3)
2.   if 0 < 3? YES
3.   pivot = partition([5, 2, 4, 1], 0, 3)
4.     Choose pivot = arr[3] = 1
5.     Rearrange: smaller elements left, larger right
6.     After partition: [1, 2, 4, 5], pivotIndex = 0
7.   quickSort([...], 0, -1)  ← No left part
8.   quickSort([...], 1, 3)   ← Sort right part
9.     pivot = partition([...], 1, 3)
10.    ...continue recursing until sorted...


╔════════════════════════════════════════════════════════════════════════════╗
║                      MEMORY VISUALIZATION                                 ║
╚════════════════════════════════════════════════════════════════════════════╝

MERGE SORT MEMORY:
─────────────────

Original Array:  [5] [2] [4] [1]
Temp arrays needed during merge:
                 [2] [5]     [1] [4]      ← Need extra space O(n)
                 [1] [2] [4] [5]          ← More temp space
                 
Total: Original array + Temp arrays = O(n) space


QUICK SORT MEMORY:
─────────────────

Original Array:  [1] [2] [4] [5]  ← Sorts IN PLACE!
Stack:           quickSort(0,1)
                 quickSort(2,3)
                 quickSort(0,0)     ← Recursion stack only O(log n)
                 
Total: Original array + Call stack = O(log n) space


╔════════════════════════════════════════════════════════════════════════════╗
║                    REAL-WORLD EXAMPLES                                    ║
╚════════════════════════════════════════════════════════════════════════════╝

MERGE SORT is used in:
──────────────────────
• Java's Arrays.sort() for objects (Merge Sort variant)
• Python's sorted() and list.sort() (Timsort, which uses Merge)
• External merge sort (sorting data larger than RAM)
• Database sorting (when guaranteed performance matters)
• Git's merge sort implementation


QUICK SORT is used in:
───────────────────────
• C's qsort() standard library function
• Java's Arrays.sort() for primitives (Dual Pivot Quick Sort)
• Python's internal sorted for primitives
• Most OS sorting implementations
• General-purpose sorting in competitive programming


╔════════════════════════════════════════════════════════════════════════════╗
║                    SOLVING PROBLEMS WITH THESE                            ║
╚════════════════════════════════════════════════════════════════════════════╝

PROBLEMS SOLVED BY MERGE SORT:
──────────────────────────────

1. Count Inversions (Modified merge step)
   ← Use the merge step to count pairs where arr[i] > arr[j], i < j

2. Merge K Sorted Arrays
   ← Use same merge logic extended

3. Finding median of sorted arrays
   ← Merge then find middle element

4. Stable sorting requirement
   ← Only algorithm guaranteed to be stable


PROBLEMS SOLVED BY QUICK SORT:
──────────────────────────────

1. Kth Smallest/Largest Element (Quick Select)
   ← Use partition to find kth position in O(n) average

2. Sort when space is limited
   ← In-place sorting crucial

3. 3-way partitioning (Handling duplicates)
   ← Quick sort naturally handles this

4. Finding percentiles
   ← Use partition to divide by percentile


╔════════════════════════════════════════════════════════════════════════════╗
║                    PRACTICE PROBLEMS FROM PDF                             ║
╚════════════════════════════════════════════════════════════════════════════╝

P06_MergeSort.java
───────────────────
✓ Implement full merge sort
✓ Test on various inputs

P07_QuickSort.java
──────────────────
✓ Implement full quick sort with partition
✓ Test on various inputs

P08_KthSmallest.java
────────────────────
✓ Use quick sort's partition logic (Quick Select)
✓ Find kth smallest element in O(n) average

P09_CountInversions.java
────────────────────────
✓ Modify merge sort to count inversions
✓ While merging, count pairs where left > right


╔════════════════════════════════════════════════════════════════════════════╗
║                    KEY TAKEAWAYS TO REMEMBER                              ║
╚════════════════════════════════════════════════════════════════════════════╝

1. MERGE SORT:
   "Guaranteed O(n log n), stable, but needs O(n) extra space"
   
2. QUICK SORT:
   "Usually faster O(n log n), in-place O(log n) space, but can hit O(n²)"
   
3. PARTITION LOGIC (Quick Sort):
   "The key trick for Quick Select, count inversions, etc."
   
4. MERGE LOGIC (Merge Sort):
   "Two-pointer technique, used in many problems"
   
5. STABILITY MATTERS:
   "If original order of equal elements must be preserved → Merge Sort"
   
6. SPACE MATTERS:
   "If memory is critical → Quick Sort"
   
7. WORST CASE MATTERS:
   "If guaranteed performance needed → Merge Sort"
   
8. AVERAGE CASE MATTERS:
   "If typical performance is all that matters → Quick Sort"


╔════════════════════════════════════════════════════════════════════════════╗
║                    FILES TO STUDY                                         ║
╚════════════════════════════════════════════════════════════════════════════╝

1. MergeSortComplete.java    ← Understand merge logic, how it divides equally
2. QuickSortComplete.java    ← Understand partition, how pivot works
3. P06_MergeSort.java        ← Implement merge sort
4. P07_QuickSort.java        ← Implement quick sort
5. P08_KthSmallest.java      ← Use partition logic for selection
6. P09_CountInversions.java  ← Modify merge logic for counting


═══════════════════════════════════════════════════════════════════════════════
*/

public class SortingComparison {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║     MERGE SORT vs QUICK SORT - COMPREHENSIVE GUIDE             ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Read the comments in this file for detailed visual explanations!");
        System.out.println("\nKey Files to Study:");
        System.out.println("  1. MergeSortComplete.java");
        System.out.println("  2. QuickSortComplete.java");
        System.out.println("  3. P06_MergeSort.java");
        System.out.println("  4. P07_QuickSort.java");
        System.out.println("  5. P08_KthSmallest.java");
        System.out.println("  6. P09_CountInversions.java");
    }
}
