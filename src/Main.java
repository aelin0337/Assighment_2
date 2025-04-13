public class Main {
    public static void main(String[] args) {

        // MyArrayList
        MyList<Integer> arrList = new MyArrayList<>();
        arrList.add(10);
        arrList.add(20);
        arrList.addFirst(5);
        arrList.addLast(30);
        System.out.println("MyArrayList size: " + arrList.size());  // 4
        arrList.remove(Integer.valueOf(3));
        System.out.println("After removing 3 index: size = " + arrList.size());  // 3


        // MyLinkedList
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.addFirst("first");
        linkedList.removeLast();



        // MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack pop: " + stack.pop());   // 3
        System.out.println("Stack peek: " + stack.peek()); // 2
        System.out.println("Stack size: " + stack.size()); // 2


        // MyQueue
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Queue dequeue: " + queue.dequeue()); // 10
        System.out.println("Queue peek: " + queue.peek());       // 20
        System.out.println("Queue size: " + queue.size());       // 1


        // MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(5);
        heap.add(2);
        heap.add(8);
        heap.add(1);
        System.out.println("Min in heap: " + heap.peek());         // 1
        System.out.println("Remove min: " + heap.remove());        // 1
        System.out.println("New min after removal: " + heap.peek()); // 2
    }
}
