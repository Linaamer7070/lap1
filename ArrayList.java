public class ArrayList<E> implements List<E>, Iterable<E> {
    // المتغيرات الأساسية
    public static final int CAPACITY = 16;     // السعة الافتراضية
    private E[] data;                          // المصفوفة الداخلية
    private int size = 0;                      // عدد العناصر الحالي
    
    // المنشئات Constructors
    public ArrayList() { this(CAPACITY); }
    
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    // العمليات الأساسية
    public int size() { return size; }
    
    public boolean isEmpty() { return size == 0; }
    
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }
    
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }
    
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length)              // need to resize
            resize(2 * data.length);
        for (int k = size - 1; k >= i; k--)   // shift elements up
            data[k + 1] = data[k];
        data[i] = e;                          // place new element
        size++;
    }
    
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++)    // shift elements down
            data[k] = data[k + 1];
        data[size - 1] = null;                // help garbage collection
        size--;
        return temp;
    }
    
    // دوال المساعدة
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }
    
    @SuppressWarnings("unchecked")
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++)
            temp[k] = data[k];
        data = temp;
    }
    
    // تنفيذ Iterator
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator implements Iterator<E> {
        private int j = 0;                     // مؤشر للعنصر التالي
        private boolean removable = false;      // هل يمكن استخدام remove?
        
        @Override
        public boolean hasNext() { return j < size; }
        
        @Override
        public E next() throws NoSuchElementException {
            if (j == size) throw new NoSuchElementException("No next element");
            removable = true;
            return data[j++];
        }
        
        @Override
        public void remove() throws IllegalStateException {
            if (!removable) throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j-1);
            j--;
            removable = false;
        }
    }
} 