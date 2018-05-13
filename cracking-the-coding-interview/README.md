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
  * **Heap**: Really ood at basic ordering and keeping track of max and mins.


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

### Array
* Searching is not optimal: you might need to look at all the elements of the array until finding the one loooked.
* Removal means that you have to shift all the records to the right of element removed.
* In an unsorted array:
  * Search: O(n)
  * Insert: O(1)
  * Removal: O(n)
* In a sorted array:
* Search: O(log n)
* Insert: O(n)
* Removal: O(n)

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
  * You can implement a Stack with a LinkedList, where the head Node is called _top_
* Queue: FIFO
  * enqueue()
  * dequeue()
  * peek()


### Chapter 4: Trees and Graphs
* Binary tree IS NOT Binary **search** tree
  * BST: the left children are less than or equal to the current node, which is less than all the right nodes.
* Balanced vs Unbalanced
  * Unbalanced: describe your algorithm in terms of both the average and the worst case time. The depth of subtrees does not vary by more than a certain amount.
* Full and complete: all leaves are at the bootom of the tree, and all non-leaf nodes have exactly two children.
* Binary tree traversal: be comfortable implementing in-order, post-order, and pre-order traversal.
* **Graph Traversal**
  * DFS is typically the easiest if we want to visit every node in the graph, or at least visit every node until we find whatever we're looking for.
  * BFS: better when we have a very large tree and want to be prepared to quit when we get too far from the original node.
* **Depth First Search (DFS)***
  * We visit a node r and then iterate through each of r's adjacen nodes
* **Breadth First Search (BFS)**
  * we visit each of a node r's adjacent nodes before searching any of r's grandchildren
  * An iterative solution using a Queue usually works best.
* **Binary trees**: do fairly well with ordering. If the binary search tree is perfectly balanced, the top might be the median. But if there's an even number of elements, the median is actually the average of the middle two elements.
  * Link: https://www.youtube.com/watch?v=H5JubkIy_p8

#### Binary search tree (BST)
* Efficient structure to organize quick search as well as quick update.
* BST is a search tree where, for each node, the value of all nodes in left sub-tree is lesser (or equal) and the value of all nodes in right sub-tree is greater.
* Data structure must be an array and it **must be sorted**.
* Binary search tree MUST be balanced to stay in cost of O(log n). After insertion/deletion, the tree goes unbalanced (there are ways to fix it).
* In the worst case, for an unbalanced binary search tree, we would have a cost of O(n).
* Binary search in a sorted array: O(log(n))
* Insert: first, find the position where it should be inserted. Then, shift the elements on the right.
* Insert: O(log n)
* Removal: O(log n)
* We go from having a space of N, to N/2, N/4... until we only have 1 (the match). That means we would have up to log n steps.

### Chapter 5: Bit manipulation

* Operations: ^, ~, &, |
* ^ is XOR (1 only if both bits are different)
* ~ is a not (negation)
* `xxxx >> n`: it clears the n leftmost bits. E.g. for 2 = `00xx`
* `1101 >> 2 = 0011`
* `0110 + 0110 = 0110 * 2 = shift 0110 left by 1 = 1100`
* `0100 * 0011 = 0011 * 4 = 0011 * 2^n = move 0011 n times to the left = 1100`
* `a^(~a) = 111...1`
* `^0` = a sequence of 1s
* `x & (~0 << n)` = it clears the rightmost bits of x
* `x ^ 1s = ~x`
* `x ^ x = 0`
* `x & 0s = 0`
* `x & 1s = x`
* `x | 0s = x`
* `x | 1s = 1s`
* `x | x = x`
* ```
  boolean getBit(int num, int i) {
    return ((num & (1 << i)) != 0);
  }
  ```

````
* ```
int setBit(int num, int i) {
  return num | (1 << i);
}
````

* ```
  int clearBit(int num, int i) {
    int mask = ~(1 << i);
    return num & mask;
  }
  ```

````
* ```
int updateBit(int num, int i, int v) {
  int mask = ~(1 << i);
  return (num & mask) | (v << i);
}
````

### Chapter 7: Mathematics and Probability

* **gcd**: greatest common divisor (máximo común divisor)
  * mayor divisor común de todos los número. Mayor número entero, común a todos, que permite dividirlos a todos
  * Primero sacar los números primos. Después tomar los factores comunes (de todos los números) con menor exponentes y multiplicarlos.
  * E.g. para 6 y 32 es 2 (6= 2\*3, 32 = 2^5 => factor común con menor exponente=2).
  * E.g. para 40, 36 y 12 es 4 (40=2^3*5, 36=2^2 * 3^2, 12=2^2\*3 => factor común con menor exponente=2^2=4).
* **lcm**: least common multiple (mínimo común múltiplo)
  * Número más pequeño de los múltiplos comunes.
  * Primero, descomponerlos en sus primos. Después, multiplicar los factores comunes y no comunes con mayor exponente.
  * E.g. para 6 y 4 sería 12 (6=2*3, 4=2^2, 12=2^2 * 3).
* gcd(x, y) _ lcm(x, y) = x _ y
* Checking for primality: loop from i=2 to i < n (but it's enough up to Math.sqrt(n))
* Generating a list of primes: the sieve of Eratosthenes
  * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
* **Statistics**
  * **Median**: the median is the number separating the higher half of a data sample, a population, or a probability distribution, from the lower half.
  * **Mean**: the average.
  * **Mode**: the most frequent value.
  * **Range**: difference between the largest and smallest value.
  * (1 + 2 + 3 + ... + n) = n(n+1)/2 = n^2
* **Logarithms**
  * log2( 2^31 ) = 31
  * y = log2(x) --> 2^y = x

### Chapter 9: Recursion and Dynamic Programming

* Recursive solutions, by definition, are built off solutions to sub-problems.
* Bottom-Up recursion: start solving it for one element, then two, etc.
* Top-Down recursion: think about how to divide the problem for case N into subproblems.
* Dynamic programming = memoization (recursion + cache, typical for Fibonacci)
* Think how to build the solution to f(n) from the solution to f(n-1). Think of a base case.

### Chapter 10: Scalability and memory limits

* The step-by-step approach
  * Step 1: make believe. Think about the solution for "not so much" data.
  * Step 2: get real
* Demonstrate you can analyze and solve problems: poke holes in your own solution
* Dividing lots of data:
  * by order of appearance
  * by hash value
  * by actual value
  * arbitrarily
* We need to understand whether this is a one time operation

### Chapter 11: Sorting and searching

TBD

### Chapter 12: Testing

* Who will use it? And why?
* What are the use cases?
  * normal case
  * extremes
  * nulls and "illegal" input
  * strange input
* What are the bounds of use?
* What are the stress/failure conditions?
* troubleshooting questions

### Chapter 15: Databases

* https://www.sohamkamani.com/blog/2016/07/07/a-beginners-guide-to-sql/
* Normalized databases are designed to minimize redundancy, while denormalized databases are designed to optimize read time.
* Dernormalization is commonly used to create highly scalable systems.
* In a SQL statement, we can only select values that are in an aggregate function or in the GROUP BY clause.
* JOIN types:
  * https://www.w3schools.com/sql/sql_join.asp
  * (INNER) JOIN: Returns records that have matching values in both tables
  * LEFT (OUTER) JOIN: Return all records from the left table, and the matched records from the right table
  * RIGHT (OUTER) JOIN: Return all records from the right table, and the matched records from the left table
  * FULL (OUTER) JOIN: Return all records when there is a match in either left or right table
* Explicit JOIN: `FROM Students INNER JOIN Teachers`
* Implicit JOIN `FROM Students, Teachers`
* `WHERE` and `ON` are only simmilar when using `INNER JOIN`. In outer joins:
  * `ON`: Before joining. Records (from right table) will be filtered before joining. This may end up as null in the result (since OUTER join).
  * `WHERE`: After joining. Records will be filtered after join has taken place.
  * Example:
    * ```
      SELECT documents.name, downloads.id
        FROM documents
          LEFT OUTER JOIN downloads
            ON documents.id = downloads.document_id
              AND username = 'sandeep'
      ```
    ```
    * It returns ALL documents names (LEFT JOIN). Those with a matching downloads id, will get also the downloads.id.
    ```
* **Aggregations** are used to convert many rows into a single row.
  * Almost all aggregations we do come with the `GROUP BY` statement and using a function (sum, count, etc.) on the `SELECT`
* Whenever you write a `GROUP BY` clause, make sure that anything in the SELECT clause is either an aggregate function or contained within the `GROUP BY` clause.

### Chapter 16: Threads and locks

A process is an independent entity to which system resources (e.g. CPU time and memory) are allocated.

* Each process is executed in a separate address space, and one process cannot access the variables and data structures of another process.
* A thread exists within a process and shares the process' resources (including its heap space).
* A thread is a particular execution of a process. Each thread still has its own resgisters and its own stack, but other threads can read and write the heap memory.
* A context switch is the time spent switching between two processes.

#### Threads in Java

* Every thread in Java is created and controlled by a unique object of the java.lang.Thread.
* To create and use a thread using a Runnable interface (with a run() method to be implemented):
  * Create a class which implements the `Runnable`interface.
  * Create an object of type `Thread` by passing a `Runnable`object as argument.
  * Start the Thread.
* Alternatively, we can create a thread by extending the `Thread` class.
* Implementing the `Runnable`interface may be preferable:
  * Java does not support multiple inheritance.
  * A class might only be interested in being runnable, and therefore, inherinting the full overhead of the Thread class would be excessive.

#### Synchronization and locks

* Keyword `synchronized`:
  * Synchronizad methods: it can be applied to methods and code blocks, and restricts multiple threads from executing the code simultaneously **on the same object**. So, different instances wouldn't be restricted.
    * blocks: `synchronized(this){..}`. Only one thread per instance can execute the block.
  * Static methods synchronize on the **class lock**. So, different instances would be restricted.
* Keyword `lock`:
  * More granular control, it's a monitor used to synchronize acces to a shared resource by associating with the lock.
  * `Lock lock = new ReentreatLock()` >> `lock.lock()` >> `lock.unlock()`
* Deadlocks: it can happen when there is a circular wait, mutual exlusion, hold and wait and no preemption.

## General info
* http://en.wikipedia.org/wiki/Big_O_notation
* O(n + 2n + ... + nx) = O(x\*n^2) >>> cost of concatenating a list of n words with x characters each word
  * new_word = word + word >>> it requires to copy each word, character by character
* Double loop: O(n^2)
* Being N elements, if for each one you have to make 2 calls: O(2^n)
* ASCII: 128 characters, 7-8 bits >> Latin-1 (ISO-8859-1)
* **Recursive algorithms** take at elast O(n) space, where n is the depth of the recursive cal. All recursive algorithms can be implemented iteratively, although they may be much more complex.
* Dynamic programming: recursion + cache >> memoization (https://en.wikipedia.org/wiki/Memoization)
* Factorial. 4! = 4 _ 3 _ 2 \* 1
  * Used for permutations. Number of different ways to order 4 different letters = 4!
* Vocabulary
  * restar: substract
  * sumar: add
  * multiplicar: multiply
  * 2^3 = two to the three, two to the third, two to the power of three
  * breadth = ancho, anchura, amplitud


## How to read
* O(n) is read "O of n"
* X^3 is read "x cube"
* 2^x is read "two times x"


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
* Tree: balanced vs unbalanced? search tree?

## Interesting links
* http://blog.koalite.com/2013/09/eficiencia-de-distintos-tipos-de-colecciones/
