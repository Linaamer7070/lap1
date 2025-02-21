public class CircularlyLinkedList<E> implements Cloneable {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    
    private Node<E> tail = null;
    private int size = 0;
    
    // 1. تنفيذ addFirst بدون متغيرات محلية
    public void addFirst(E element) {
        if (isEmpty()) {
            tail = new Node<>(element, null);
            tail.next = tail;
        } else {
            tail.next = new Node<>(element, tail.next);
        }
        size++;
    }
    
    // 2. تنفيذ size بدون متغير instance
    public int size() {
        if (isEmpty()) return 0;
        
        int count = 1;
        Node<E> current = tail.next;
        while (current != tail) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // 3. تنفيذ equals
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CircularlyLinkedList)) return false;
        
        CircularlyLinkedList<?> other = (CircularlyLinkedList<?>) o;
        if (size != other.size) return false;
        if (isEmpty()) return other.isEmpty();
        
        Node<E> walkA = tail.next;  // start at front
        Node<?> walkB = other.tail.next;
        while (walkA != tail) {
            if (!walkA.element.equals(walkB.element)) return false;
            walkA = walkA.next;
            walkB = walkB.next;
        }
        return walkA.element.equals(walkB.element);  // check last element
    }
    
    // 4. مقارنة قائمتين دائريتين بغض النظر عن نقطة البداية
    public boolean isEquivalent(CircularlyLinkedList<E> other) {
        if (size != other.size) return false;
        if (isEmpty()) return other.isEmpty();
        
        Node<E> walkA = tail.next;
        for (int start = 0; start < size; start++) {
            boolean match = true;
            Node<E> walkB = walkA;
            Node<E> otherWalk = other.tail.next;
            
            for (int k = 0; k < size; k++) {
                if (!walkB.element.equals(otherWalk.element)) {
                    match = false;
                    break;
                }
                walkB = walkB.next;
                otherWalk = otherWalk.next;
            }
            
            if (match) return true;
            walkA = walkA.next;
        }
        return false;
    }
    
    // 5. تقسيم القائمة إلى نصفين
    public CircularlyLinkedList<E>[] split() {
        if (size % 2 != 0)
            throw new IllegalStateException("List size must be even");
            
        CircularlyLinkedList<E> first = new CircularlyLinkedList<>();
        CircularlyLinkedList<E> second = new CircularlyLinkedList<>();
        
        if (isEmpty())
            return new CircularlyLinkedList[]{first, second};
            
        Node<E> midPoint = tail.next;
        for (int i = 0; i < size/2 - 1; i++)
            midPoint = midPoint.next;
            
        // تقسيم القائمة
        first.tail = midPoint;
        second.tail = tail;
        Node<E> temp = midPoint.next;
        first.tail.next = tail.next;
        second.tail.next = temp;
        
        first.size = second.size = size/2;
        
        return new CircularlyLinkedList[]{first, second};
    }
    
    // 6. تنفيذ clone
    @Override
    public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
        CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) super.clone();
        if (size > 0) {
            other.tail = new Node<>(tail.element, null);
            Node<E> walk = tail.next;
            Node<E> otherTail = other.tail;
            while (walk != tail) {
                Node<E> newest = new Node<>(walk.element, null);
                otherTail.next = newest;
                otherTail = newest;
                walk = walk.next;
            }
            otherTail.next = other.tail;  // link to front
        }
        return other;
    }
    
    // Helper methods
    public boolean isEmpty() {
        return tail == null;
    }
} 