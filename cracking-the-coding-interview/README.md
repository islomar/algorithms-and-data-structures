# Cracking the coding interview
http://www.crackingthecodinginterview.com/
https://github.com/gaylemcd/CtCI-6th-Edition
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

### Chapter 1: Arrays and Strings
* Hash tables:
  * It has an underlying array and a hash function
  * The hash function maps the key to an integer, which is the index in the array.
  * If there are lots of values, collisions: use of key % array_length >> there is a linked list in each array position
  * It can be implemented with a BST: being balanced, the lookup time would be O(log n)
    * we may use less space, since we don't need to make a reservation of the whole space up front
* ArrayLists:
  * dinamically resizing array
  * O(1) access
  * It doubles the space when it reaches the limit: that operation is O(n) but it happens rarely
* StringBuffer
  * Concatenating Strings: it makes new copies.
  * StringBuffer creates an array of strings, and only at the end it copies it to a new String.
* Exercises
  * Has a string all unique characters?
    * Ask if it's ASCII or Unicode, different size.
    * If the lenght is bigger than the number of characters, return false.


### Chapter 2: LinkedLists
* No constant time access
* Slow lookup: O(n)
* Node = data/value + next node pointer + appendToTail()
* Singly vs Doubly linked list
* You can not directly acces an element, you have to traverse the list
* **Runner technique**:
  * you iterate through the linked list with two pointers simultaneosly, with one ahead of the other.
  * fast vs slow pointers. The fast one hops several nodes
* Some linked list problems can be better solved with recursion.
* Links of interest:
 * http://algs4.cs.princeton.edu/32bst/
 * https://www.youtube.com/watch?v=pYT9F8_LFTM


### Chapter 3: Stacks and Queues
* Stack: LIFO
  * pop()
  * push()
  * peek()
  * You can implement a Stack with a LinkedList, where the head Node is called *top*
* Queue: FIFO
  * enqueue()
  * dequeue()
  * peek()


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


### Binary trees
Do fairly well with ordering. If the binary search tree is perfectly balanced, the top might be the median. But if there's an even number of elements, the median is actually the average of the middle two elements.
* Link: https://www.youtube.com/watch?v=H5JubkIy_p8

### Heap
Really ood at basic ordering and keeping track of max and mins.

## Statistics
* **Median**: the median is the number separating the higher half of a data sample, a population, or a probability distribution, from the lower half.
* **Mean**: the average.
* **Mode**: the most frequent value.
* **Range**: difference between the largest and smallest value.
* (1 + 2 + 3 + ... + n) = n(n+1)/2 = n^2

## Logarithms
log2( 2^31 ) = 31
y = log2(x) --> 2^y = x

## General info
* http://en.wikipedia.org/wiki/Big_O_notation
* O(n + 2n + ... + nx) = O(x*n^2)  >>> cost of concatenating a list of n words with x characters each word
  * new_word = word + word >>> it requires to copy each word, character by character
* Double loop: O(n^2)
* ASCII: 128 characters, 7-8 bits  >> Latin-1 (ISO-8859-1)
* **Recursive algorithms** take at elast O(n) space, where n is the depth of the recursive cal. All recursive algorithms can be implemented iteratively, although they may be much more complex.


## Questions for the challenge
* Do a specific example. Start with the simplest one and add complexity from there on.
* Which are the input parametsrs? Which are the expected outcome? (number of them, types, etc.)
* Possible restrictions: ¿specific type of the elements? E.g. only letters,
* Case sensitive?
* Corner cases
* characters: encoding? ASCII, UTF-8?
* Take into account maximum number of different elements: guard clause
* Do we know the size of the structure? (e.g. the size of a linked list)
* Think about optimizing space: is it important?
* Can we fix from the beginning the size of the strcture?


## Interesting links
* http://blog.koalite.com/2013/09/eficiencia-de-distintos-tipos-de-colecciones/
