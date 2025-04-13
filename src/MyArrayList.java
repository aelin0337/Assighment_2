import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>  {
    private Object[] array;
    private int size;

    public MyArrayList(){
        array = new Object[10];
        size = 0;
    }

    // ensure that we have needed capacity
    private void ensureCapacity(){
        if(size >= array.length){
            Object[] newArray = new Object[array.length * 2];
            for(int i = 0; i < array.length; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void add(T item) { // add new element in the end of array
        ensureCapacity();
        array[size++] = item;
    }

    @Override
    public void set(int index, T item) { //replacing an element by index
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = item;
    }

    @Override // add element into array by the index
    public void add(int index, T item) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        for(int i = size; i>index; i--){
            array[i] = array[i-1];
        }
        array[index]= item;
        size++;
    }

    @Override // add element in the start use add() method
    public void addFirst(T item) {
        add(0,item);
    }

    @Override // add element in the end use add() method
    public void addLast(T item) {
        add(item);
    }


    // return an element by the index
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    @Override // return the 1st element
    public T getFirst() {
        if(size == 0){
            throw new IllegalStateException("List is empty");
        }
        return get(0);
    }

    @Override // return a last element
    public T getLast() {
        if(size == 0){
            throw new IllegalStateException("List is empty");
        }
        return get(size-1);
    }

    @Override // remove an element by the index, shifting all elements to the left.
    public T remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removed = (T) array[index];
        for(int i = index; i<size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return removed;
    }

    @Override // remove first element by use remove() method.
    public T removeFirst() {
        if(size == 0){
            throw new IllegalStateException("List is empty");
        }
        remove(0);
        return null;
    }

    @Override // remove last element by use remove() method.
    public T removeLast() {
        if(size == 0){
            throw new IllegalStateException("List is empty");
        }
        remove(size-1);
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable current = (Comparable) array[j];
                Comparable next = (Comparable) array[j + 1];

                if (current.compareTo(next) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override // finds the index of the first occurrence of the element.
    public int indexOf(Object object) {
        for(int i = 0; i < size; i++){
            if (object == null){
                if(array[i] == null) return i;
            } else {
                if(object.equals(array[i])) return i;
            }
        }
        return -1;
    }

    @Override // same as indexOf but occurrence of the last element.
    public int lastIndexOf(Object object) {
        for(int i = size - 1; i>= 0; i--){
            if(object == null){
                if(array[i] == null) return i;
            } else{
                if(object.equals(array[i])) return i;
            }
        }
        return -1;
    }

    @Override // return true if an element was found
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    // delete all array
    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }

    // return size
    @Override
    public int size() {
        return size;
    }

    // returns whether the array is empty
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    System.out.println("No more elements");
                }
                return (T) array[index++];
            }
        };
    }
}
