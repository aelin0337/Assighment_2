Custom Data Structures in Java: MyArrayList, MyLinkedList, MyStack, MyQueue, MyMinHeap

This project is a custom Java implementation of core data structures, following the assignment specification. It includes:

MyArrayList and MyLinkedList — physical data structures.
MyStack, MyQueue, and MyMinHeap — logical data structures based on the physical ones.
Interface-based architecture, testing, and documentation.

What’s Implemented
1. MyArrayList
Dynamic array implementation using Object[]
Implements MyList<E> interface
Methods: add, remove, get, set, addFirst, removeLast, contains, indexOf, etc.
Fully tested in Main.java

2. MyLinkedList (Doubly)
Custom doubly linked list using an inner class MyNode
Maintains head, tail, and size
Prevents circular references (loop prevention)
Implements MyList<E> interface
Methods fully tested

3. MyStack
Based on MyArrayList
LIFO behavior: push, pop, peek
No unrelated methods exposed

4. MyQueue
Based on MyLinkedList
FIFO behavior: enqueue, dequeue, peek
Clean interface, queue-specific logic only

5. MyMinHeap
Based on MyArrayList
Maintains heap invariant for minimum-heap
Provides methods like add, poll, peek, heapify
Uses generics with T extends Comparable<T>

All list structures implement:
public interface MyList<T> {
    void add(T item);
    void set(int index, T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    T remove(int index);
    T removeFirst();
    T removeLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();
    Iterator<T> iterator();
}

All classes are tested in Main.java with various operations:
Adding, removing, and accessing elements
Edge cases like removing from empty structures
Iteration using for-each.

