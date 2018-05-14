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
    * You can implement it with an Array or a LinkedList.
        * Array: keep a reference to both the first and last (start and end) elements. Use module (%) for changing the start
    * LinkedList: it plays with first and last
* **Double ended queue**
    * Combination of a stack and a queue.
    * You can add or remove elements from both the start and the end:
        * remove from the same place where you add: stack
        * remove from the opposite side: queue
    * You can implement it with an Array or a LinkedList.
    * Operations: inject(), eject(), peekLast(), pop(), push()
        * pop() = dequeue()
        * inject() = enqueue() => append at the end of the list (appendLast())


## Chapter 4: Detour - Functional Programming
* **Recursive algorithms**
    * No updation of any variable
    * Easier to understand and debug
* **Lambda expressions**
    * Functional Interface:
        * @FunctionalInterface
        * It passes a block of code as argument
        * An interface with one unimplemented method
        * Can have more methods declared or inherited
        * Implemented by one method
        * It's also a functional interface if all by one have a default implementation (with `default` keyword)
        * expression syntax vs block syntax (when the implementation of the method requires several lines of code)
* **Functional data structure**:
    * simmutability and inductive definition (composition of smaller versions of the data structure)
    * Functional linked list:
        * head and tail. The recursion finishes when the tail is an empty list.
        * foldLeft(): aggregates the head and moves on to the tail
        * foldRight(): aggregates the tail and moves towards the head
* **Monads**
    * It's a kind of container: it stores objects of other classes
    * `Option`
    * `flatMap()`: returns a monad, extracts the output and creates a transformed monad.


## Chapter 5: Efficient Searching - Binary Search and Sorting
* **Searching algorithms**
    * Linear search = O(n)
        * Needed for an arbitrary array.
    * Binary search = O(log (n))
        * Better for sorted array
* **Sorting**
    * Selection sort (swap and recursion) = O(n^2)
    * Insertion sort = O(n^2)
    * Bubble sort = O(n^2)
        * It moves up, swapping.
        * It sorts the biggest each step
* Single recursion: the function calls itself only once.
* **Tail recursion**: it calls itself only at the end. Used to avoid a stack overflow.


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
        * Double ended queue
    * Vector
    * Tree
    * Graph
* TBD