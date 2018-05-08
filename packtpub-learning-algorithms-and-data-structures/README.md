# Learn Algorithms and Data Structures in Java for Day-to-Day Applications

* https://www.packtpub.com/application-development/learn-algorithms-and-data-structures-java-day-day-applications-video
* Author: Tomasz Lelek
* There is example code.


## Chapter 1 : Basic Data Structures
* **Stacks**:
    * LIFO
    * When to use Stacks:
        * Undo/redo operation in word processors.
        * Expression evaluation and syntax parsing.
        * JVM are stack oriented.
    * `peek()`: returns the element at the top of the stack without removing it.
* **Queue**:
    * FIFO
    * enqueue() and
    * dequeue()
* **Linked lists**:
    * Fast insertion: O(1)
    * Fast remove: O(1)
    * Slow lookup: O(n)
    * Node: it contains data and a pointer to the next node
    * Every linked list neads a head.
    * The last node points to null
* **Arrays**:
    * Fast lookup.
    * A container object that holds a fixed number of values of a single type.
    * The length of an array is established the array is created.
    * Each element has an **index**.
    * Lookup: O(1)


## Chapter 2 : Hash Tables and Binary Search Trees
* **Hash tables and hash functions**
    * keys --> hash function --> buckets
    * Each bucket would contain a linked list.
    * Search: O(1)
    * Insert: O(1)
    * Delete: O(1)
* **Binary search tree (BST**
    * Insert: O(log(n))
    * Find: O(log(n))
    * Delete: O(log(n))
    * Display: O(n) >> prints the entire tree in increasing order
    * Delete a node with 2 children: substitue it by the smallest node on its right subtree

## Chapter 3 : Sorting and Recursion
* **Bubble sort**
    * O(n^2)
    * Outer and inner loop
* **Heap sort**
    * Heap: ordered binary tree
    * Max heap: parent > child
    * Steps:
        * We first transform the array to a heap: basically, to a Tree >> heapify
        * Then we transform it into a max/min heap, sorting the elements in ascending/descending order
        * Then we swap the first and last node and delete the last node from the heap
    * Min heap: minimum value is the root (the first element of the array)
    * Max heap: maximum value is the root (the first element of the array)
    * O(n log(n))
        * Iterate over each element (O(n)) and build a BST (O(log(n)))
    * https://www.youtube.com/watch?v=MtQL_ll5KhQ
    * https://www.youtube.com/watch?v=t0Cq6tVNRBA
    * https://www.youtube.com/watch?v=PqS5T9ZKZno
    * Functions used:
        * generate-tree()
        * build-max-heap(): creates max heap from unsorted array  >> it takes O(n)
        * heapify(): similar to build-max-heap(), but assumes part of array is already sorted >> O(log(n))
* **Recursion**
* **Tail recursion**


## Chapter 4 : Multithreading Algorithms and Probabilistic Data Structures
TBD


## Chapter 5 : Graph Algorithms and Advanced Data Structures
TBD


## Interesting links
TBD


Bookmark: 3.3