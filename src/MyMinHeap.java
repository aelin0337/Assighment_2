public class MyMinHeap <T extends Comparable<T>>{
    private MyArrayList<T> heap;

    public MyMinHeap(){
        this.heap = new MyArrayList<>();
    }

    // An auxiliary method for restoring the heap structure when adding. Lifts the element up until it is smaller than the parent.
    private void heapifyUp(int index) {
        int parentIndex = 0;
        T temp;

        while(index > 0){
            parentIndex = (index -1)/2;
        }
        if(heap.get(index).compareTo(heap.get(parentIndex)) < 0){
            temp = heap.get(index);
            heap.set(index, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            index = parentIndex;
        }
    }

    // An auxiliary method for restoring the heap structure during deletion. Moves the element down if it is larger than one of the children.
    private void heapifyDown(int index) {
        int leftChild, rightChild, minIndex;
        T temp;

        while(index < heap.size()){
            leftChild = index * 2 + 1;
            rightChild =index * 2 + 2;
            minIndex = index;

            if(leftChild < heap.size()&& heap.get(leftChild).compareTo(heap.get(minIndex)) < 0){
                minIndex = leftChild;
            }
            if(rightChild < heap.size()&& heap.get(rightChild).compareTo(heap.get(minIndex)) < 0){
                minIndex = rightChild;
            }
            if(minIndex != index){
                temp = heap.get(minIndex);
                heap.set(minIndex, heap.get(index));
                heap.set(index, temp);
                index = minIndex;
            } else{
                break;
            }
        }
    }

    // returns a reference to the root element of the heap
    public T getMin(){
        if(heap.isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public T removeMin(){
        if(heap.isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        T temp = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapifyDown(0);
        return temp;
    }

    // adds an item to the pile and restores the pile structure upwards
    public void add(T element){
        heap.add(element);
        heapifyUp(heap.size()-1); // raise the element if the order is broken.
    }

    public void insert(T item){
        heap.add(item);
        heapifyUp(heap.size()-1);
    }

    // deletes and returns the minimum (root) element from the heap.
    public T remove(){
        if(heap.size() == 0){
            return null;
        }
        T temp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return temp;
    }
    // returns the minimum element (at the root) without deleting it.
    public T peek(){
        return heap.size() > 0 ? heap.get(0) : null;
    }
    // Returns whether the heap is empty
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    // returns the size of items in the heap.
    public int size(){
        return heap.size();
    }
}
