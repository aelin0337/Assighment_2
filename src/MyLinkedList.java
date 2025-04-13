import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class MyNode{
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data){
            this.data = data;
        }
    }
    private MyNode head;
    private MyNode tail;
    private int size = 0;

    @Override // add data in the end
    public void add(T item) {
        addLast(item);
    }

    @Override // set data by index instead of last data
    public void set(int index, T item) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        MyNode current;
        if(index == 0){
            current = head;
        }
        else if (index == size-1){
            current = tail;
        }
        else if(index < size/2){
            current = head;
            for(int i =0; i<index; i++){
                current = current.next;
            }
        }else {
            current = tail;
            for(int i = size-1; i> index; i--){
                current = current.prev;
            }
        }
        current.data = item;
    }

    @Override // add data by index
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        MyNode newNode = new MyNode(item);
        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    @Override // add data in the beginning before head
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);

        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override // add data in the end
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if(tail ==null){
            tail = head = newNode;
        } else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override // return data from certain index
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        MyNode current;
        if (index <size/2){
            current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        }else{
            current = tail;
            for(int i = size -1; i > index; i--){
                current = current.prev;
            }
        }
        return current.data;
    }

    @Override // return first data
    public T getFirst() {
        if(head == null){
            return null;
        }
        return head.data;
    }

    @Override // return last data
    public T getLast() {
        if(tail == null){
            return null;
        }
        return tail.data;
    }

    @Override // remove data from certain index
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        MyNode current;
        if(index < size/2){
            current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        } else{
            current = tail;
            for(int i = size -1; i > index; i--){
                current = current.prev;
            }
        }
        T removedData = current.data;
        if(current.prev != null){
            current.prev.next = current.next;
        } else{
            current.next = head;
        }
        if(current.next != null){
            current.next.prev = current.prev;
        } else{
            current.prev = null;
        }
        size--;
        return removedData;
    }

    @Override // remove first data
    public T removeFirst() {
        if(head == null){
            throw new IndexOutOfBoundsException("List is empty");
        }
        T data = head.data;
        head = head.next;

        if(head != null){
            head.prev = null;
        } else{
            tail = null;
        }
        size--;
        return data;
    }

    @Override // remove last data
    public T removeLast() {
        if(tail == null){
            throw new IndexOutOfBoundsException("List is empty");
        }
        T data = tail.data;
        tail = tail.prev;

        if(tail != null){
            tail.next = null;
        } else{
            head = null;
        }
        size--;
        return data;
    }

    @Override // Bubble Sort
    public void sort() {
        if (size < 2) return;
        boolean swapped;
        do{
            swapped = false;
            MyNode current = head;

            while(current != null && current.next != null){
                if(current.data.compareTo(current.next.data) < 0){
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while(swapped);
    }

    @Override // finds the first occurrence of the object
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;

        while (current != null){
            if(((object == null) & (current.data == null)) || ((object == null) && object.equals(current.data))){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override // finds the last occurrence of the object
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size -1;

        while (current != null){
            if((object == null && current.data == null) || ((object == null) && object.equals(current.data))){
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override // checks if an item exists in the list
    public boolean exists(Object object) {
        MyNode current = head;

        while(current != null){
            if((object != null && current.data != null)|| (object == null && object.equals(current.data))){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override // returns an array of all elements
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode current = head;
        int index = 0;

        while(current != null){
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override // delete all data
    public void clear() {
        MyNode current = head;
        while(current != null){
            MyNode next = current.next;
            current.next = null;
            current.prev = null;
            current.data = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    // returns whether the list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    @Override // return size
    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T val = current.data;
                current = current.next;

                return val;
            }
        };
    }
}

