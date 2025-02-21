public class ArrayStack<E> implements Stack<E>, Cloneable {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;
    
    public ArrayStack() {
        this(CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public ArrayStack<E> clone() throws CloneNotSupportedException {
        ArrayStack<E> other = (ArrayStack<E>) super.clone();
        other.data = data.clone();
        return other;
    }
    
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) 
            throw new IllegalStateException("Stack is full");
        data[++t] = e;
    }
    
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
    
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }
    
    public int size() { return t + 1; }
    
    public boolean isEmpty() { return t == -1; }
} 