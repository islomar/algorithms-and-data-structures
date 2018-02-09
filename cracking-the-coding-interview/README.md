# Cracking the coding interview
http://www.crackingthecodinginterview.com/
Examples and annotations of the book "Cracking the coding interview".
Trying to improve my algorithmics skills :-)

## Five algorithm approaches
* Examplify
* Pattern Matching
* Simplify and Generalize
* Bae Case and Build
* Data Structure Brainstorm

## General advices
* Use Structures Generously
* Appropriate Code Reuse
* Modular
* Flexible and Robust
* Error Checking
 * Do not make assumptions about the input, assert it!!

## Data structures
https://www.youtube.com/playlist?list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P

### Hash Tables
* Highly efficient lookup.
* In a very simple implementation, it has an array and a hash function. A hash function maps the key to an integer, which indicates the index in the array (index=hash(key)). The object is then stored at that index. But the array should be very large to avoid collisions between the same hash(key) generated.
* Better: store the object in a linked list at index hash(key)%array_length.
* Another implementation is a binary search tree. We can then guarantee an O(log n) lookup time, since we can keep the tree balanced.

### Binary search tree (BST)
* Efficient structure to organize quick search as well as quick update.
* BST is a search tree where, for each node, the value of all nodes in left sub-tree is lesser (or equal) and the value of all nodes in right sub-tree is greater.
* Data structure must be an array and it **must be sorted**.
* Binary search tree MUST be balanced to stay in cost of O(log n). After insertion/deletion, the tree goes unbalanced (there are ways to fix it).
* In the worst case, for an unbalanced binary search tree, we would have a cost of O(n).
* Binary search in a sorted array: O(log(n))
* Insert: first, find the position where it should be inserted. Then, shift the elements on the right.
* Insert:   O(log n)
* Removal:  O(log n)
* We go from having a space of N, to N/2, N/4... until we only have 1 (the match). That means we would have up to log n steps.

### LinkedList
* Tend not to do very well with accessing and sorting numbers.
* Search:   O(n)
* Insert:   O(1) at head, O(n) at tail.
* Removal:  O(n)
* Links of interest:
 * http://algs4.cs.princeton.edu/32bst/
 * https://www.youtube.com/watch?v=pYT9F8_LFTM

### Array
* Searching is not optimal: you might need to look at all the elements of the array until finding the one loooked.
* Removal means that you have to shift all the records to the right of element removed.
* In an unsorted array:
  * Search:   O(n)
  * Insert:   O(1)
  * Removal:  O(n)
* In a sorted array:
 * Search: O(log n)
 * Insert: O(n)
 * Removal: O(n)

### ArrayList (dynamically resizing Array)
It is an array that resizes itself as needed while stil providing O(1) access.

### Binary trees
Do fairly well with ordering. If the binary search tree is perfectly balanced, the top might be the median. But if there's an even number of elements, the median is actually the average of the middle two elements.
* Link: https://www.youtube.com/watch?v=H5JubkIy_p8

### Heap
Really ood at basic ordering and keeping track of max and mins.

### String
Sorting the chars of a String takes O(n log(n))

## Big-O-notation
http://en.wikipedia.org/wiki/Big_O_notation
O(x + 2x + 3x + 4x + ...nx) = O(xn^2)

## Statistics
* **Median**: the median is the number separating the higher half of a data sample, a population, or a probability distribution, from the lower half.
* **Mean**: the average.
* **Mode**: the most frequent value.
* **Range**: difference between the largest and smallest value.
* (1 + 2 + 3 + ... + n) = n(n+1)/2 = n^2

## Logarithms
log2( 2^31 ) = 31
y = log2(x) --> 2^y = x


## Interesting links
* http://blog.koalite.com/2013/09/eficiencia-de-distintos-tipos-de-colecciones/
