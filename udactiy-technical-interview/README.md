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
* TBD