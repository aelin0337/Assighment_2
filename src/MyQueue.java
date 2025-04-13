public class MyQueue <T extends Comparable<T>> {
    private MyLinkedList<T> data;

    public MyQueue() {
        data = new MyLinkedList<>();
    }

    // adds the element at the end of the queue
    public void enqueue(T item) {
        data.addLast(item);
    }

    // retrieves and deletes the front element of the queue
    public T dequeue() {
        if(data.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T front = data.getFirst();
        data.removeFirst();
        return front;
    }

    // returns a reference to the front element of the queue
    public T peek(){
        if(data.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data.getFirst();
    }

    // returns whether the queue is empty
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // returns the size of the queue
    public int size(){
        return data.size();
    }
}
