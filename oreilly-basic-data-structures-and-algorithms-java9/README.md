# Basic data structures and algorithms in Java 9
* https://www.packtpub.com/application-development/basic-data-structures-and-algorithms-java-9-video
* Author: Debasish Ray Chawdhuri
* Course Length2 hours 44 minutes
* Code files: https://www.packtpub.com/books/content/support/30382

## Chapter 1: why bothers?
* input + output + auxiliary space
* Sometimes Time(already sorted list) < Time(random list)
* Best case != worst case != average case
* Asymptotic complexity:
  * O(4n) ~ O(n) => asymptotic bound = O(n)
  * Upper bound: puts an upper limit on a functions growth
  * Lower bound: it shows minimum rate of growth for large input
  * Theta bound: used when the complexity remains unchanged by the input
  * Big-O
  * O(n) is read "O of n"
  * X^3 is read "x cube"
  * 2^x is read "two times x"


## Chapter 2: cogs and pulleys - building blocks
* **Arrays**
    * Limited and fixed size
    * Any element can be accessed randomly, with an index = O(1)
    * Stored in contiguous memory
    * Inserting elements
        * Create a new array with one more element AND copy the entire original data along with the new value.
        * O(n)
* **Linked Lists**
    * insert: O(n) (worst case)
    * peak: O(n)
* **Doubly linked lists**
    * each Node stores the previous reference
* **Circular linked list**
    * lastElement.next = first

## Chapter 3: Protocols - Abstract Data Types
* ADT: a description of what a data type should do for their user. A list of operations that should be supported.
* **Stack**
    * LIFO
    * push(), pop(), peek()
    * You can implement it with an Array or a LinkedList.
        * Array: keep a reference to the *top* element.
            * Problem: you have a fixed size from the beginning.
        * LinkedList: keep a reference to the *root/first* (base) element (because we need O(1) for getting the "pop" and "push" operation)
* **Queue**
    * FIFO
    * enqueue(), dequeue(), peek()


## Chapter 4: Detour - Functional Programming
TBD

## Chapter 5: Efficient Searching - Binary Search and Sorting

## General
* Java bitwise operations: https://www.geeksforgeeks.org/bitwise-shift-operators-in-java/
  * > > (Signed right shift)
  * > > > (Unsigned right shift): It always fills 0 irrespective of the sign of the number.

## Pending
* Write down main operations on each data structure:
    * Array
    * LinkedList (doubly, circular)
        * it keeps everything for "first" and "last".
    * Stack
    * Queue
    * Vector
    * Tree
    * Graph
* TBD