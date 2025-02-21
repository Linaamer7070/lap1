public class ArrayBinaryTree<E> implements BinaryTree<E> {
    private static final int CAPACITY = 1000;    // السعة الافتراضية
    private E[] data;                            // المصفوفة لتخزين العناصر
    private int size = 0;                        // عدد العناصر
    
    // المنشئات Constructors
    public ArrayBinaryTree() { this(CAPACITY); }
    
    @SuppressWarnings("unchecked")
    public ArrayBinaryTree(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    // الدوال الأساسية للشجرة الثنائية
    public int size() { return size; }
    
    public boolean isEmpty() { return size == 0; }
    
    public Position<E> root() {
        if (isEmpty()) return null;
        return new ArrayPosition(0);
    }
    
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        ArrayPosition node = validate(p);
        int j = (node.index - 1) / 2;
        if (j < 0) return null;
        return new ArrayPosition(j);
    }
    
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        ArrayPosition node = validate(p);
        int j = 2 * node.index + 1;
        if (j >= size) return null;
        return new ArrayPosition(j);
    }
    
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        ArrayPosition node = validate(p);
        int j = 2 * node.index + 2;
        if (j >= size) return null;
        return new ArrayPosition(j);
    }
    
    // دوال إضافية للتعامل مع الشجرة
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        data[0] = e;
        size = 1;
        return new ArrayPosition(0);
    }
    
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        ArrayPosition parent = validate(p);
        int j = 2 * parent.index + 1;
        if (j >= data.length) throw new IllegalArgumentException("Array capacity exceeded");
        if (j < size) throw new IllegalArgumentException("Left child exists");
        data[j] = e;
        size = Math.max(size, j + 1);
        return new ArrayPosition(j);
    }
    
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        ArrayPosition parent = validate(p);
        int j = 2 * parent.index + 2;
        if (j >= data.length) throw new IllegalArgumentException("Array capacity exceeded");
        if (j < size) throw new IllegalArgumentException("Right child exists");
        data[j] = e;
        size = Math.max(size, j + 1);
        return new ArrayPosition(j);
    }
    
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        ArrayPosition node = validate(p);
        E temp = data[node.index];
        data[node.index] = e;
        return temp;
    }
    
    // صف داخلي لتمثيل المواقع في الشجرة
    private class ArrayPosition implements Position<E> {
        private int index;
        
        public ArrayPosition(int index) {
            this.index = index;
        }
        
        public E getElement() throws IllegalStateException {
            if (index >= size)
                throw new IllegalStateException("Position no longer valid");
            return data[index];
        }
    }
    
    // التحقق من صحة الموقع
    private ArrayPosition validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof ArrayPosition))
            throw new IllegalArgumentException("Not valid position type");
        ArrayPosition position = (ArrayPosition) p;
        if (position.index >= size)
            throw new IllegalArgumentException("Position is no longer valid");
        return position;
    }
    
    // طباعة الشجرة (للتوضيح)
    public void printTree() {
        for (int i = 0; i < size; i++) {
            if (data[i] != null)
                System.out.println("Index " + i + ": " + data[i]);
        }
    }

    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        // Implementation needed
        throw new UnsupportedOperationException("Method not implemented");
    }
}

public interface Position<E> {
    E getElement() throws IllegalStateException;
}

public interface BinaryTree<E> extends Tree<E> {
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}