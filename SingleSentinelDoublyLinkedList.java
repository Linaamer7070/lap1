public class SingleSentinelDoublyLinkedList<E> {
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
    
    private Node<E> sentinel;  // sentinel node guards both ends
    private int size = 0;
    
    public SingleSentinelDoublyLinkedList() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    
    public void addFirst(E element) {
        Node<E> newest = new Node<>(element, sentinel, sentinel.next);
        sentinel.next.prev = newest;
        sentinel.next = newest;
        size++;
    }
    
    public void addLast(E element) {
        Node<E> newest = new Node<>(element, sentinel.prev, sentinel);
        sentinel.prev.next = newest;
        sentinel.prev = newest;
        size++;
    }
    
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = sentinel.next.element;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return answer;
    }
    
    public E removeLast() {
        if (isEmpty()) return null;
        E answer = sentinel.prev.element;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return answer;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
} 