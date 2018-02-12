# Udacity course: Algorithms and data structures for technical interviewing
https://www.udacity.com/course/technical-interview--ud513
Tutor: Brynn Claypoole (https://www.linkedin.com/in/bclaypoole/)
Forums: https://forums.udacity.com/?forum_path=c/standalone-courses/careers-interviewing-algorithm


## Lesson 1: Introduction and Efficiency
* Efficiency:
    * How well you're using your computer's resources to get a particular job's done.
    * both in  time and space terms.
    * Get the most done with minimal resources.
* Big O Notation:
    * O(n), where n represents the lenght of an input to your function.
    * O(1) = O(0n + 1)
    * Think about best, worst and average scenario (e.g. for iterating through an alphabet, the average scenario would be 13 times)
    * In the end, what it matters is "the relationship": O(16n + 2) or O(29n + 2) means O(n))
    * Always specify your interviewr which case you're talking about (best, average, worst)


## Lesson 2: List-based collections
* **Collections** don't have a particular order.
    * They don't need to have the same type of objects.
* **Arrays** are the most common implementation of **Lists**.
    * It differs in different programming languages (some allow different types of elements, some don't, etc.)
    * An **Array** is a List with some added rules: e.g. each Array has a localtion called an "index".
    * inserting at the end is usually easy (unless it has a specifi size). But doing it in the middle, means to move up to n elements (O(n))
    * deleting an element in the middles can also be inefficient.
    * List time complexity in Python: https://wiki.python.org/moin/TimeComplexity
    * Behind the scenes **a Python list is built as an array**.
        * Internally, a list is represented as an array; the largest costs come from growing beyond the current allocation size (because everything must move), or from inserting or deleting somewhere near the beginning (because everything after that must move).
* **Linked Lists**:
    * It's an extension of a List, but it is not an Array.
    * Each elements has a reference to the next element in the list (a pointer to the memory address).
    * Adding and removing elements from a Linked list is easy: you just need to change a couple of references. It takes constant time (you change pointers, you don't iterate)
    * There isn't a built-in data structure in Python that looks like a linked list.
    * **Doubly Linked Lists**: you have pointers to both the next and previous elements.
* **Stacks**
    * Stacks are also list-based data structures.
    * You can only access what it is on the top of the stack.
    * Stacks are useful when you only care about the most recent elements.
    * push and pop: both operations are O(1)
    * LIFO
    * Stack practice: Here's an alternative solution to delete_first() - https://gist.github.com/adarsh0806/02d8e1d54d510294e75dfbc0d9bd7059
* **Queues**
    * FIFO
    * The opposite to a Stack
    * head and tail
    * enqueue: adding an element to the tail
    * dequeue: deleting an element from the head
    * peek: look at the head element, but you don't remove it
    * **Dequeue = Double ended queue**: it's a queue that goes in both ways. You can enqueue and dequeue from either end.
    * A **deck** is kind of a generalized version of both stacks and queues.
    * **Priority queue**: you include a priority to every element that you insert in the queue.
        * When you dequeue, you remove the element with the highest priority.
        * If the elements have the same priority, the oldest element is the one that gets dequeued first.


## Lesson 3: Searching and Sorting
* **Binary search**
    * If the array is sorted, you start in the middle.
    * Efficiency: when I double the elements, I need one more iteration.
        * 2^n = y >>> log(y) = n >> The log would be "base 2". The logarithm is the inverse operation to the power.
        * O(log(n))
    * If you don't know or see the efficiency of an algorith, create a table in order to extract: "Array size" vs "Iterations"
    * Visualization: http://www.cs.armstrong.edu/liang/animation/web/BinarySearch.html
    * Searching Sorted List Visualization: https://www.cs.usfca.edu/~galles/visualization/Search.html
* **Recursion**:
    * A recursion function needs:
        * to call itself at some poing
        * a base case: it's like an exit condition.
        * Alter the input parameter at some point
* **Intro to sorting**
    * "In place sorting algorithms" just rearrange the elements inside the same data structure.
* **Bubble sort**
    * aka "sinking sort", it's a naive approach
    * In each iteration, the highest value pops up.
    * In-place algorithm
    * Efficiency:
        * Worst case: O(n^2)
        * Average case: O(n^2)
        * Best case: O(n)
    * Space = O(1) (in-place algorithm)
    * https://en.wikipedia.org/wiki/Bubble_sort
* **Merge sort**:
     * Split and sort: First divide the list into the smallest unit (1 element), then compare each element with the adjacent list to sort and merge the two adjacent lists. Finally all the elements are sorted and merged.
     * Divide and conquer
     * At the beginning, we leave an array of size 1 at the start, and all the rest take size 2.
     * Number of iterations x Number of comparisions in each iteration
     * Efficiency:  O(n*log(n))   >> we do log(n) iterations, and n comparisons in each iteration.
     * The time efficiency is better than Bubble sort, but the space efficiency is worse >> auxilliary space = O(n)
        * But indeed, we can remove the "old arrays" each time, so we only need 2 arrays: the one where our numbers were, and the new array that we're copying the values into.
    * https://xkcd.com/1185/
    * https://algs4.cs.princeton.edu/22mergesort/
* **Quick sort**
    * Divide and conquer
    * Pick a value (pivot): move all the values bigger, to its right. And move all the values lower than the pivot, to the left.
    * The convention is to pick the last element as your pivot.
    * Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it
    * Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.
    * Efficiency:
        * worst case: O(n^2)
        * Average and best case: O(n*log(n))
    * If we know that we're a getting an almost sorted array, we don't want to use Quick sort, since we would get O(n^2)
    * Space = O(1)
    * https://en.wikipedia.org/wiki/Quicksort


## Lesson 4: Maps and Hashing
* **Sets**
    * Sets don't have any specific order, but it doesn't allow repeated elements.
    * A Map is a set-based structure (<Key, Value>).
    * A group of keys is a Set: the keys of map need to be unique (like in a dictionary)

## Interesting links
* Watch all kind of sorting algorithms in action:  https://visualgo.net/en/sorting?slide=1