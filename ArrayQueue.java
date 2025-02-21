public class ArrayQueue<E> implements Queue<E>, Cloneable {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;  // index of front element
    private int sz = 0; // number of elements
    
    public ArrayQueue() { this(CAPACITY); }
    
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    // تنفيذ rotate بكفاءة
    public void rotate() {
        if (sz <= 1) return;  // لا داعي للتدوير
        
        // حفظ العنصر الأمامي
        E temp = data[f];
        
        // تحديث مؤشر المقدمة
        f = (f + 1) % data.length;
        
        // وضع العنصر في النهاية
        data[(f + sz - 1) % data.length] = temp;
    }
    
    // تنفيذ clone
    @Override
    public ArrayQueue<E> clone() throws CloneNotSupportedException {
        ArrayQueue<E> result = (ArrayQueue<E>) super.clone();
        result.data = data.clone();
        return result;
    }
    
    // ... باقي عمليات الطابور الأساسية
} 

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    
    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2.isEmpty()) return;
        
        // ربط نهاية الطابور الحالي مع بداية Q2
        list.tail.next = Q2.list.head;
        list.tail = Q2.list.tail;
        
        // تفريغ Q2
        Q2.list.head = null;
        Q2.list.tail = null;
        Q2.list.size = 0;
    }
}