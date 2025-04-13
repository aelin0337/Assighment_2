public class MyStack <T extends Comparable<T>> {
    private MyArrayList<T> data;

    public MyStack(){
        data = new MyArrayList<>();
    }

    // adds the element at the top of the stack
    public void push(T item){
        data.add(item);
    }

    // retrieves and deletes the topmost element of the stack
    public T pop(){
        if(data.isEmpty()) {
            return null;
        }
        T top = data.get(data.size()-1);
        data.removeLast();
        return top;
    }

    // returns a reference to the topmost element of the stack
    public T peek(){
        if(data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.get(data.size()-1);
    }

    // returns whether the stack is empty
    public boolean isEmpty(){
        return data.isEmpty();
    }
    // return size of the stack
    public int size(){
        return data.size();
    }
}
