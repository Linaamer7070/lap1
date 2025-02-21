public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    
    private Node<E> head = null;
    private int size = 0;
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SinglyLinkedList)) return false;
        
        SinglyLinkedList<?> other = (SinglyLinkedList<?>) o;
        if (size != other.size) return false;
        
        Node<E> walkA = head;
        Node<?> walkB = other.head;
        while (walkA != null) {
            if (!walkA.element.equals(walkB.element)) return false;
            walkA = walkA.next;
            walkB = walkB.next;
        }
        return true;
    }
    
    public Node<E> findSecondToLast() {
        if (head == null || head.next == null) {
            return null;  // القائمة فارغة أو تحتوي على عنصر واحد
        }
        
        Node<E> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        return current;
    }
    
    public int size() {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public void rotate() {
        if (head == null || head.next == null) {
            return;  // لا شيء للتدوير
        }
        
        // حفظ العنصر الأول
        Node<E> oldHead = head;
        
        // تحريك head إلى العنصر التالي
        head = head.next;
        
        // البحث عن آخر عنصر
        Node<E> walk = head;
        while (walk.next != null) {
            walk = walk.next;
        }
        
        // ربط العنصر القديم في النهاية
        walk.next = oldHead;
        oldHead.next = null;
    }
    
    public static <E> SinglyLinkedList<E> concatenate(
            SinglyLinkedList<E> L, SinglyLinkedList<E> M) {
        
        SinglyLinkedList<E> result = new SinglyLinkedList<>();
        result.head = L.head;
        
        // إذا كانت القائمة الأولى فارغة
        if (L.head == null) {
            result.head = M.head;
            return result;
        }
        
        // البحث عن نهاية القائمة الأولى
        Node<E> current = L.head;
        while (current.next != null) {
            current = current.next;
        }
        
        // ربط نهاية L مع بداية M
        current.next = M.head;
        
        return result;
    }
    
    public void reverse() {
        if (head == null || head.next == null) {
            return;  // لا شيء للعكس
        }
        
        Node<E> previous = null;
        Node<E> current = head;
        Node<E> next = null;
        
        while (current != null) {
            // حفظ العقدة التالية
            next = current.next;
            
            // عكس الإشارة
            current.next = previous;
            
            // التحرك للعنصر التالي
            previous = current;
            current = next;
        }
        
        // تحديث head ليشير إلى آخر عنصر (الذي أصبح الأول)
        head = previous;
    }
}