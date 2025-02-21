public class DoublyLinkedList<E> implements Cloneable {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node<E> header;    // sentinel node at front
    private Node<E> trailer;   // sentinel node at back
    private int size = 0;
    
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }
    
    // 1. إيجاد العنصر الأوسط
    public Node<E> findMiddle() {
        Node<E> left = header.next;
        Node<E> right = trailer.prev;
        
        while (left != right && left.next != right) {
            left = left.next;
            right = right.prev;
        }
        return left;
    }
    
    // 2. حساب الحجم بدون متغير instance
    public int size() {
        int count = 0;
        Node<E> current = header.next;
        while (current != trailer) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // 3. تنفيذ equals
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof DoublyLinkedList)) return false;
        
        DoublyLinkedList<?> other = (DoublyLinkedList<?>) o;
        if (size() != other.size()) return false;
        
        Node<E> walkA = header.next;
        Node<?> walkB = other.header.next;
        while (walkA != trailer) {
            if (!walkA.element.equals(walkB.element)) return false;
            walkA = walkA.next;
            walkB = walkB.next;
        }
        return true;
    }
    
    // 4. دمج قائمتين
    public static <E> DoublyLinkedList<E> concatenate(
            DoublyLinkedList<E> L, DoublyLinkedList<E> M) {
        DoublyLinkedList<E> result = new DoublyLinkedList<>();
        
        // ربط آخر عنصر في L مع أول عنصر في M
        Node<E> lastL = L.trailer.prev;
        Node<E> firstM = M.header.next;
        
        lastL.next = firstM;
        firstM.prev = lastL;
        
        result.header = L.header;
        result.trailer = M.trailer;
        
        return result;
    }
    
    // 6. نسخة دائرية من القائمة المزدوجة
    public static class CircularDoublyLinkedList<E> {
        private Node<E> cursor = null;
        private int size = 0;
        
        public void rotate() {
            if (cursor != null)
                cursor = cursor.next;
        }
        
        public void rotateBackward() {
            if (cursor != null)
                cursor = cursor.prev;
        }
        
        // ... باقي العمليات الأساسية
    }
    
    // 7. تنفيذ clone
    @Override
    public DoublyLinkedList<E> clone() throws CloneNotSupportedException {
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) super.clone();
        
        // إنشاء sentinels جديدة
        other.header = new Node<>(null, null, null);
        other.trailer = new Node<>(null, other.header, null);
        other.header.next = other.trailer;
        
        // نسخ العناصر
        Node<E> walk = header.next;
        Node<E> otherTail = other.header;
        while (walk != trailer) {
            Node<E> newest = new Node<>(walk.element, otherTail, null);
            otherTail.next = newest;
            otherTail = newest;
            walk = walk.next;
        }
        otherTail.next = other.trailer;
        other.trailer.prev = otherTail;
        
        return other;
    }
} 