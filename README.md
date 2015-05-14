# Cracking the coding interview
Examples and annotations of the book "Cracking the coding interview". 
Trying to improve my algorithmics skills :-)

##Five algorithm approaches
* Examplify
* Pattern Matching
* Simplify and Generalize
* Bae Case and Build
* Data Structure Brainstorm

##General advices
* Use Structures Generously
* Appropriate Code Reuse
* Modular
* Flexible and Robust
* Error Checking
 * Do not make assumptions about the input, assert it!!

##Data structures
###Hash Tables
* Highly efficient lookup. 
* In a very simple implementation, it has an array and a hash function. A hash function maps the key to an integer, which indicates the index in the array (index=hash(key)). The object is then stored at that index. But the array should be very large to avoid collisions between the same hash(key) generated.
* Better: store the object in a linked list at index hash(key)%array_length.
* Another implementation is a binary search tree. We can then guarantee an O(log n) lookup time, since we can keep the tree balanced.

###Binary search tree
* Efficient structure to organize quick search as well as quick update.
* Data structure must be an array and it **must be sorted**.
* Binary search in a sorted array: O(log(n))
* Insert: first, find the position where it should be inserted. Then, shift the elements on the right.
* Insert:   O(log n)
* Removal:  O(log n)

###LinkedList
* Tend not to do very well with accessing and sorting numbers.
* Search:   O(n)
* Insert:   O(1) at head, O(n) at tail.
* Removal:  O(n)
* Links of interest:
 * http://algs4.cs.princeton.edu/32bst/
 * https://www.youtube.com/watch?v=pYT9F8_LFTM

###Array
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

###Binary trees
Do fairly well with ordering. If the binary search tree is perfectly balanced, the top might be the median. But if there's an even number of elements, the median is actually the average of the middle two elements.

###Heap
Really ood at basic ordering and keeping track of max and mins.

##Big-O-notation
http://en.wikipedia.org/wiki/Big_O_notation

##Logarithms
log2( 2^31 ) = 31
